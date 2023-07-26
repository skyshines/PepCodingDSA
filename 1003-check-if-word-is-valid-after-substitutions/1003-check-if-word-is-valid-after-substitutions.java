class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        
        for(char ch : s.toCharArray()){
            if(ch == 'a' || ch == 'b'){
                st.push(ch);
            }else{
                char ch1 = '#';
                char ch2 = '#';
                if(st.size() >= 2){
                    ch1 = st.pop();
                    ch2 = st.pop();
                }else{
                    return false;
                }
                
                if(ch1 == 'b' && ch2 == 'a'){
                    
                }else{
                    return false;
                }
            }
        }
        
        return st.size() == 0;
    }
}