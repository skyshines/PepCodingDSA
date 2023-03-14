class Solution {
    public String fractionToDecimal(int num, int den) {
        long numerator = 1L * num;
        long denominator = 1L * den;
        
        StringBuilder ans = new StringBuilder("");
    
        boolean flag = ((1L * numerator * denominator) < 0);
        if(flag) ans.append("-");
        
        if(numerator < 0) numerator *= -1;
        if(denominator < 0) denominator *= -1;
        
        long quotient = (numerator / denominator);
        long remainder = (numerator % denominator);
        
        ans.append(quotient);
        
        if(remainder == 0){
            return ans.toString();
        }else{
            ans.append(".");
            
            HashMap<Long, Integer> hm = new HashMap<>();
            
            while(remainder != 0){
                
                if(hm.containsKey(remainder)){
                    ans.insert(hm.get(remainder), "(");
                    ans.append(")");
                    break;
                }else{
                    hm.put(remainder, ans.length());
                    remainder *= 10;

                    quotient = (remainder / denominator);
                    remainder = (remainder % denominator);

                    ans.append(quotient);
                }
            }
        }
        
        return ans.toString();
    }
}