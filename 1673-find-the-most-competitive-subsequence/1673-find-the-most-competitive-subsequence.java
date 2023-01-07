class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        if(nums.length == 1) return nums;
        
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < nums.length; i++){
       
            while(st.size() > 0 && st.peek() > nums[i] && nums.length - i - 1 >= k - st.size()) st.pop();
            
            if(st.size() < k) st.push(nums[i]);
        }
        
        int[] ans = new int[st.size()];
        
        for(int i = ans.length - 1; i >= 0; i--){
            ans[i] = st.pop();
        }
        
        return ans;
    }
}