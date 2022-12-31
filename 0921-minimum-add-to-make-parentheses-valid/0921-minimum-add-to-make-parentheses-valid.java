class Solution {
    //linear time and constant space
    public int minAddToMakeValid(String s) {
      int opbr = 0;
      int clbr = 0;
        
        for(char ch : s.toCharArray()){
            if(ch == '('){
                opbr++;
            }else{
                if(opbr > 0){
                    opbr--;
                }else{
                    clbr++;
                }
            }
        }
        
        return opbr + clbr;
        
        
    }
}

/*
linear time and linear space
class Solution {
    public int minAddToMakeValid(String s) {
      Stack<Character> st = new Stack<>();
        
        for(char ch : s.toCharArray()){
            if(ch == '('){
                st.push(ch);
            }else{
                if(st.size() > 0 && st.peek() == '('){
                    st.pop();
                }else{
                    st.push(ch);
                }
                
            }
        }
        
        return st.size();
    }
}


*/