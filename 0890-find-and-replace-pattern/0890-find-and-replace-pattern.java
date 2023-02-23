class Solution {
    public boolean isPattern(String word,String pattern){
        HashMap<Character, Character> hm = new HashMap<>();
        HashSet<Character> hs = new HashSet<>();
        
        for(int i = 0; i < word.length(); i++){
            char wordch = word.charAt(i);
            char patternch = pattern.charAt(i);
            
            if(hm.containsKey(patternch)){
                if(hm.get(patternch) != wordch) return false;
            }else{
                if(hs.contains(wordch)) return false;
                else{
                    hm.put(patternch, wordch);
                    hs.add(wordch);
                }
            }
            
            
        }
        
        return true;
    }
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        
        for(String word : words){
            if(isPattern(word, pattern) == true){
                ans.add(word);
            }
        }
        
        return ans;
    }
}