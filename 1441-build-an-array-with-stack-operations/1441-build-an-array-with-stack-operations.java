class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> st = new ArrayList<>();
        int nums = 1;
        
        for(int val : target){
            if(val == nums){
                st.add("Push");
                nums++;
            }else{
                while(nums != val){
                    st.add("Push");
                    st.add("Pop");
                    nums++;
                }
                
                st.add("Push");
                nums++;
            }
        }
        
        return st;
    }
}