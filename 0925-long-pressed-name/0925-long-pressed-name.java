class Solution {
    public boolean isLongPressedName(String name, String typed) {
        if(typed.length() < name.length()) return false;
        
        int i = 0;
        int j = 0;
        
        while(i < name.length() && j < typed.length()){
            if(name.charAt(i) == typed.charAt(j)){
                i++; j++;
            }else{
                if(j == 0) return false;
                
                if(typed.charAt(j) != typed.charAt(j - 1)){
                    return false;
                }
                
                while(j < typed.length() && typed.charAt(j) == typed.charAt(j - 1)){
                    j++;
                }
            }
        }
        
        while(j < typed.length() && typed.charAt(j) == typed.charAt(j - 1)){
                    j++;
                }
        
        if(i == name.length() && j == typed.length()){
            return true;
        }else{
            return false;
        }
    }
}