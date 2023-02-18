class Solution {
    public String smallestNumber(String pattern) {
        StringBuilder ans = new StringBuilder("");
        
        Stack<Integer> st = new Stack<>();
        
        int nums = 1;
        
        for(char ch : pattern.toCharArray()){
            st.push(nums); nums++;
            if(ch == 'I') while(st.size() > 0) ans.append(st.pop());
        }
        
        st.push(nums);
        
        while(st.size() > 0) ans.append(st.pop());
        
        return ans.toString();
        
    }
}