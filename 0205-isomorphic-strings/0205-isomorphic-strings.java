class Solution {
    public boolean helper(String s, String t) {
        if(s.length() != t.length()) return false;
        
        HashMap<Character,Character> hm = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            
            if(hm.containsKey(ch1)){
                if(hm.get(ch1) != ch2){
                    return false;
                }
            }else{
                hm.put(ch1,ch2);
            }
        }
        
        return true;
    }
    public boolean isIsomorphic(String s, String t) {
        return helper(s,t) && helper(t,s);
    }
}