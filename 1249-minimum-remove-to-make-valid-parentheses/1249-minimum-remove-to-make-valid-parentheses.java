class Solution {
    public String minRemoveToMakeValid(String s) {
        boolean[] br = new boolean[s.length()];
        
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                st.push(i);
            }else if(ch == ')'){
                if(st.size() > 0){
                    br[i] = true;
                    br[st.pop()] = true;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder("");
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            if(ch == '(' || ch == ')'){
                if(br[i] == true){
                    sb.append(ch);
                }
            }else{
                sb.append(ch);
            }
        }
        
        return sb.toString();
    }
}