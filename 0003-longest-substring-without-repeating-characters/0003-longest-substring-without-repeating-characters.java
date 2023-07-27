class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int ans = 0;
        int i = -1;
        int j = -1;
        
        while(true){
            boolean flag1 = false;
            boolean flag2 = false;
            
            //acquire
            while(i < s.length() - 1){
                flag1 = true;
                
                i++;
                char ch = s.charAt(i);
                hm.put(ch, hm.getOrDefault(ch, 0) + 1);
                
                if(hm.get(ch) == 2){
                    break;
                }else{
                    if(ans < i - j) ans = i - j;
                }
                
                
            }
            
            //release
            while(j < i){
                flag2 = true;
                j++;
                
                char ch = s.charAt(j);
                hm.put(ch, hm.get(ch) - 1);
                
                if(hm.get(ch) == 1){
                    break;
                }
                
                
            }
            
            if(flag1 == false && flag2 == false){
                break;
            }
        }
        
        return ans;
    }
}