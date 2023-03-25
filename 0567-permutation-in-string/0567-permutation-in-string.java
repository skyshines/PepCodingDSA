class Solution {
    public boolean isEqual(int[] arr1, int[] arr2){
        for(int i = 0; i < arr1.length; i++){
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        
        //Substring technique
        //desired result = total - waste
        
        int[] firstmap = new int[26];
        int[] secondmap = new int[26];
        
        for(char ch : s1.toCharArray()){
            firstmap[ch - 'a']++;
        }
        
        for(int i = 0; i < s2.length(); i++){
            if(i >= s1.length()){
                //release frequncy of i - s1.length character
                secondmap[s2.charAt(i - s1.length()) - 'a']--;
            }
            
            secondmap[s2.charAt(i) - 'a']++;
            
            if(isEqual(firstmap, secondmap)){
                return true;
            }
        }
        
        return false;
    }
}