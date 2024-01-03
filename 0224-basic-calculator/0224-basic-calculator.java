class Solution {
    public int calculate(String s) {
        int sum = 0;
        int sign = 1;
        
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            
                if(ch == '-'){
                    sign = (-1) * sign;
                }else if(ch == '('){
                    st.push(sum);
                    st.push(sign);
                    
                    sum = 0; sign = 1; //reseting sum and sign
                    
                }else if(ch == ')'){
                    sum = sum * (st.pop()); // multiplying with sign
                    sum += st.pop(); // adding the sum
    
                }else if(Character.isDigit(ch)){
                    //extracting the val
                    int val = 0;
                    
                    while(i < s.length() && Character.isDigit(s.charAt(i))){
                        val = val * 10 + (s.charAt(i) - '0');
                        i++;
                    }
                    
                    i--;
                    
                    val = val * sign;
                    
                    sum += val;
                    sign = 1;
                }
            
        }
        
        return sum;
    }
}