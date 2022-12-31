class Solution {
    public int scoreOfParentheses(String s) {
        //using -1 as flag for '(' since rest elements will be positive
        Stack<Integer> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == '('){
                st.push(-1);
            }else if(ch == ')'){
                if(st.size() > 0 && st.peek() == -1){
                    st.pop();
                    st.push(1);
                }else{
                    int sum = 0;
                    while(st.size() > 0 && st.peek() != -1){
                        sum += st.pop();
                    }
                    
                    st.pop(); // to pop opening bracket
                    st.push(2 * sum);
                }
            }
        }
        
        int sum = 0;
        
        while(st.size() > 0){
            sum += st.pop();
        }
        
        return sum;
    }
}