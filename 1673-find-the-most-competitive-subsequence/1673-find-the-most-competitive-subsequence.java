class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < nums.length; i++){
            while(st.size() > 0 && k - st.size() <= nums.length - 1 - i && st.peek() > nums[i]){
                st.pop();
            }
            
            if(st.size() < k) st.push(nums[i]);
        }
        
        int[] arr =  new int[k];
        int i = k - 1;
        while(st.size() > 0) arr[i--] = st.pop();
        
        return arr;
    }
}