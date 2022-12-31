class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();
        ArrayDeque<Character> dq = new ArrayDeque<>();
        
        for(char ch : s.toCharArray()){
            if(ch == ')'){
                while(st.peek() != '('){
                    dq.add(st.pop());
                }
                
                st.pop(); // popping opening bracket
                
                while(dq.size() > 0){
                    st.push(dq.remove());
                }
            }else{
                st.push(ch);
            }
        }
        
        char[] ans = new char[st.size()];
        
        for(int i = ans.length - 1; i >= 0; i--){
            ans[i] = st.pop();
        }
        
        return new String(ans);
    }
}