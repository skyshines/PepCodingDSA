class Solution {
    public int numSplits(String s) {
        int[] freq = new int[26]; //using this instead of hashset
        int[] pref = new int[s.length()];
        int[] suff = new int[s.length()];
        int count = 0;
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            freq[ch - 'a']++;
            
            if(freq[ch - 'a'] == 1){
                count++;
            }
            
            pref[i] = count;
        }
        
        freq = new int[26];
        
        int ans = 0;
        count = 0;
        
        for(int i = s.length() - 1; i >= 1; i--){
            
            char ch = s.charAt(i);
            freq[ch - 'a']++;

            if(freq[ch - 'a'] == 1){
                count++;
            }
            
            suff[i] = count;
            
            
            if(suff[i] == pref[i - 1]){
                ans++;
            }
            
        }
        
        return ans;
    }
}