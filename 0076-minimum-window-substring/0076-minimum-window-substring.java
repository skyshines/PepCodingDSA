class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map2 = new HashMap<>();
        
        for(char ch : t.toCharArray()){
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }
        
        int matchCount = 0;
        int desiredMatchCount = t.length();
        
        HashMap<Character, Integer> map1 = new HashMap<>();
        
        int i = -1;
        int j = -1;
        
        String ans = "";
        
        while(true){
            //loops wokring individually
            boolean flag1 = false;
            boolean flag2 = false;
            
            //acquire
            while(i < s.length() - 1 && matchCount < desiredMatchCount){
                i++;
                char ch = s.charAt(i);
                
                map1.put(ch, map1.getOrDefault(ch, 0) + 1);
                
                if(map1.getOrDefault(ch, 0) <= map2.getOrDefault(ch, 0)){
                    matchCount++;
                }
                
                flag1 = true;
            }
            
            //update ans and release
            while(j < i && matchCount == desiredMatchCount){
                int potentialAnsLength = i - j;
                
                if(ans.length() == 0 || ans.length() > potentialAnsLength){
                    String potentialAns = s.substring(j + 1, i + 1);
                    ans = potentialAns;
                }
                
                j++;
                char ch = s.charAt(j);
                
                if(map1.get(ch) == 1){
                    map1.remove(ch);
                }else{
                    map1.put(ch, map1.get(ch) - 1);
                }
                
                if(map1.getOrDefault(ch, 0) < map2.getOrDefault(ch, 0)){
                    matchCount--;
                }
                
                flag2 = true;
            }
            
            if((flag1 || flag2) == false){
                break;
            }
        }
        
        return ans;
    }
}