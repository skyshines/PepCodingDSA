class Solution {
    public boolean find132pattern(int[] nums) {
        if(nums.length < 3) return false;
        
        int[] min = new int[nums.length];
        min[0] = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            min[i] = (int)Math.min(min[i - 1],nums[i]);
        }
        
        Stack<Integer> st = new Stack<>();
        
        for(int i = nums.length - 1; i >= 1; i--){
            while(st.size() > 0 && min[i - 1] >= st.peek()) st.pop();
            
            if(st.size() > 0 && nums[i] > st.peek()) return true;
            
            st.push(nums[i]);
        }
        
        return false;
    }
}