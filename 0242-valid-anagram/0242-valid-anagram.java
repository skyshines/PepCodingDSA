class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        
        HashMap<Character, Integer> shm = new HashMap<>();
        
        for(char ch : s.toCharArray()){
            shm.put(ch, shm.getOrDefault(ch, 0) + 1);
        }
        
        for(char ch : t.toCharArray()){
            if(shm.containsKey(ch)){
                if(shm.get(ch) == 0){
                    return false;
                }else{
                    shm.put(ch, shm.get(ch) - 1);
                }
            }else{
                return false;
            }
        }
        
        return true;
    }
}