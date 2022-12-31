class Solution {
    //using linear space(stringbuilder) and linear time
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder("");
        int opbr = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                if(opbr > 0){
                    sb.append(ch);
                }
                opbr++;
            }else if(ch == ')'){
                if(opbr > 1){
                    sb.append(ch);
                }
                opbr--;
            }
        }
        
        return sb.toString();
    }
}

/*
linear time(traversing string one time and sb to string) and linear space(one stack and one substring)
class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder("");
        
        for(char ch : s.toCharArray()){
            if(ch == '('){
                if(st.size() != 0){
                    sb.append(ch);
                }
                
                st.push(ch);
            }else if(ch == ')'){
                if(st.size() > 1){
                    sb.append(ch);
                }
                st.pop();
            }
        }
        
        return sb.toString();
    }
}

*/
