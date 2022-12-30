class Solution {
    public int[] ngr(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        ans[ans.length - 1] = -1;
        st.push(ans.length - 1);
        
        for(int i = arr.length - 2; i >= 0; i--){
            while(st.size() > 0 && arr[i] > arr[st.peek()]){
                st.pop();
            }
            
            if(st.size() != 0){
                ans[i] = st.peek();
            }else{
                ans[i] = -1;
            }
            
            st.push(i);
        }
        
        return ans;
    }
    
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ngr = ngr(nums2);
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums2.length; i++){
            int val = ngr[i] != -1 ? nums2[ngr[i]] : -1;
            map.put(nums2[i],val);
        }
        
        int[] ans = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            ans[i] = map.get(nums1[i]);
        }
        
        return ans;
    }
}