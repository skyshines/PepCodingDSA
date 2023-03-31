class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        
        for(char ch : s.toCharArray()){
            if(ch == 'c'){
                if(st.size() >= 2){
                    if(st.peek() == 'b') st.pop();
                    else{
                        return false;
                    }
                    
                    if(st.peek() == 'a') st.pop();
                    else{
                        return false;
                    }
                }else{
                    return false;
                }
            }else{
                st.push(ch);
            }
        }
        
        return st.size() == 0;
    }
}