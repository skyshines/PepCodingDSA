class Solution {
    public String largestMultipleOfThree(int[] digits) {
        int n = digits.length;
        int sum = 0;
        
        Arrays.sort(digits);
        StringBuilder sb = new StringBuilder();
 
        for(int i =  n - 1; i >= 0; i--){
            sum += digits[i];
            sb.append(digits[i]);
        }
        
        if(sum % 3 == 0){
            
            //checking for trailing zeroes
            if(digits[n - 1] == 0) return "0";
            
            return sb.toString();
            
        }else if(sum % 3 == 1){
            
            //oneModFound true
            for(int i = 0; i < n; i++){
                if(digits[i] % 3 == 1){
                    
                    sb.deleteCharAt(n - 1 - i);
                    
                    if(sb.length() > 0 && sb.charAt(0) == '0'){
                        return "0";
                    }
                    
                    return sb.toString();
                    
                }
            }
                
            //oneModFound false
            int modTwo = 0;
            
            for(int i = 0; i < n; i++){
                if(digits[i] % 3 == 2){
                    if(modTwo == 0){
                        sb.deleteCharAt(n - 1 - i);
                        modTwo++;
                    }else if(modTwo == 1){
                        sb.deleteCharAt(n - 1 - i);
                        modTwo++;
                        
                        if(sb.length() > 0 && sb.charAt(0) == '0'){
                            return "0";
                        }
                        
                        return sb.toString();
                    }
                }
            }
            
            return "";
            
        }else{
            //oneModFound true
            for(int i = 0; i < n; i++){
                if(digits[i] % 3 == 2){
                    
                    sb.deleteCharAt(n - 1 - i);
                    
                    if(sb.length() > 0 && sb.charAt(0) == '0'){
                        return "0";
                    }
                    
                    return sb.toString();
                    
                }
            }
                
            //oneModFound false
            int modOne = 0;
            
            for(int i = 0; i < n; i++){
                if(digits[i] % 3 == 1){
                    if(modOne == 0){
                        sb.deleteCharAt(n - 1 - i);
                        modOne++;
                    }else if(modOne == 1){
                        sb.deleteCharAt(n - 1 - i);
                        modOne++;
                        
                    if(sb.length() > 0 && sb.charAt(0) == '0'){
                        return "0";
                    }
                        
                        
                        return sb.toString();
                    }
                }
            }
            
            return "";
        }
    }
}