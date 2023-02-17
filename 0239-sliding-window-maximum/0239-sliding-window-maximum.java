class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //stack solution
        
        //find ngr
        
        int[] ngr = new int[nums.length];
        //infinty array k right side, or consider it to be at index of nums.length
        
        Stack<Integer> st = new Stack<>();
        
        for(int i = nums.length - 1; i >= 0; i--){
            while(st.size() > 0 && nums[st.peek()] <= nums[i]) st.pop();
            
            if(st.size() == 0) ngr[i] = nums.length;
            else{
                ngr[i] = st.peek();
            }
            
            st.push(i);
        }
        
        int[] swm = new int[nums.length - k + 1];
        
        for(int i = 0, j = 0; i < swm.length ; i++){
            if(j < i) j = i;
            
            while(ngr[j] < i + k) j = ngr[j];
            
            
            swm[i] = nums[j];
        }
        
        return swm;
    }
}