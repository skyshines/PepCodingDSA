class Solution {
    public int calculate(String s) {
        Stack<Character> operators = new Stack<>();
        Stack<Integer> operands = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            if(Character.isDigit(ch) == true){
                int val = 0;
                
                while(i < s.length() && Character.isDigit(s.charAt(i))){
                    val = val*10 + (s.charAt(i) - '0');
                    i++;
                }
                
                i--;
                
                operands.push(val);
            }else if(ch == '+' || ch == '*' || ch == '/' || ch == '-'){
                while(operators.size() > 0 && priority(operators.peek()) >= priority(ch)){
                    int sec = operands.pop();
                    int first = operands.pop();
                    
                    char op = operators.pop();
                    
                    int val = solve(op,first,sec);
                    operands.push(val);
                }
                
                operators.push(ch);
            }
            
        }
        
        
        
        while(operators.size() > 0){
            
            int sec = operands.pop();
            int first = operands.pop();
                    
            char op = operators.pop();
            
            int val = solve(op,first,sec);
            
            operands.push(val);
            
        }
        
        return operands.pop();
    }
    
    public int priority(char ch){
        if(ch == '+' || ch == '-'){
            return 0;
        }else{
            return 1;
        }
    }
    
    public int solve(char op, int first, int sec){
        int val = 0;
                    if(op == '+'){
                        val = first + sec;
                    }else if(op == '-'){
                        val = first - sec;
                    }else if(op == '*'){
                        val = first * sec;
                    }else if(op == '/'){
                        val = first / sec;
                    }
        return val;        
    }
}