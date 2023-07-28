class Solution {
    public boolean compare(int[] hm1,int[] hm2){
        for(int i = 0; i < 26; i++){
            if(hm1[i] != hm2[i]){
                return false;
            }
        }
        
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        
        if(p.length() > s.length()) return ans;
        
        int[] sm = new int[26]; // sourceMap
        int[] pm = new int[26]; // pattern Map
        
        //filling sourceMap, patternMap with p.length() size
        for(int i = 0; i < p.length(); i++){
            char ch = s.charAt(i);
            sm[ch - 'a']++;
        }
        
        for(int i = 0; i < p.length(); i++){
            char ch = p.charAt(i);
            pm[ch - 'a']++;   
        }
        
        //get ans,acquuire ith character,release i - p.length() character
        int i = p.length();
        
        while(i < s.length()){
            if(compare(sm, pm) == true){
                ans.add(i - p.length());
            }
            
            char ch = s.charAt(i);
            sm[ch - 'a']++;
            
            ch = s.charAt(i - p.length());
            sm[ch - 'a']--;
            i++;
        }
        
        //check for last window
        if(compare(sm, pm) == true){
            ans.add(i - p.length());
        }
        
        return ans;
        
        
    }
}