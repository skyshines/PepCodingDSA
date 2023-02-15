class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0 && t.length() == 0) return true;
        else if(s.length() == 0 && t.length() != 0) return true;
        else if(s.length() != 0 && t.length() == 0) return false;
        
        
        int i = 0;
        int j = 0;
        
        while(i < t.length()){
            if(s.charAt(j) == t.charAt(i)){
                if(j == s.length() - 1) return true;
                j++; i++;
            }else{
                i++;
            }
        }
        return false;
    }
}