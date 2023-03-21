class Solution {
    public boolean isLongPressedName(String name, String typed) {
        if(name.charAt(0) != typed.charAt(0)) return false;
        if(name.length() > typed.length()) return false;
        
        int i = 1, j = 1;
        
        while(i < name.length() && j < typed.length()){
            if(name.charAt(i) == typed.charAt(j)){
                i++;
                j++;
            }else{
                while(j < typed.length() && (typed.charAt(j - 1) == typed.charAt(j))){
                    j++;
                }
                
                if(j < typed.length() && name.charAt(i) != typed.charAt(j)){
                    return false;
                }
            }
        }
        
        while(j < typed.length() && (typed.charAt(j - 1) == typed.charAt(j))){
            j++;
        }
        
        return (i == name.length()) && (j == typed.length());
        
    }
}