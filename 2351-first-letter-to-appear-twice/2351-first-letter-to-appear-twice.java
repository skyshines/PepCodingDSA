class Solution {
    public char repeatedCharacter(String s) {
        HashSet<Character> hs = new HashSet<>();
        
        for(char ch : s.toCharArray()){
            if(hs.contains(ch)){
                return ch;
            }else{
                hs.add(ch);
            }
        }
        
        return 'a';
    }
}