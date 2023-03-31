class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        
        for(char ch : s.toCharArray()){
            if(ch == 'c'){
                if(st.size() >= 2 && st.pop() == 'b' && st.pop() == 'a'){
                    
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