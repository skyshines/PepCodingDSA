class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[nums.length];
        int n = nums.length;
        for(int i = 2*n - 1; i >= 0; i--){
            int idx = i % n;
            while(st.size() > 0 && nums[idx] >= st.peek()) st.pop();
            
            if(i < n){
                ans[i] = st.size() != 0 ? st.peek() : -1;
            }
            
            st.push(nums[idx]);
        }
        
        return ans;
    }
}