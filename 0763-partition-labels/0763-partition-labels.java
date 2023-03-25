class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        
        int[] map = new int[26];
        
        for(int i = 0; i < s.length(); i++){
            map[s.charAt(i) - 'a'] = i;
        }
        
        int idx = -1;
        int max = 0;
        
        for(int i = 0; i < s.length(); i++){
            max = max > map[s.charAt(i) - 'a'] ? max : map[s.charAt(i) - 'a'];
            
            if(max == i){
                ans.add(i - idx);
                idx = i;
            }
        }
        
        return ans;
    }
}