class Solution {
    public int distinctEchoSubstrings(String text) {
        HashSet<String> hs = new HashSet<>();
        
        //outer loop for length of a in 'a + a'
        //inner loop will check if barabar hai k nhi and kitne bar barabr mile
        for(int i = 1; i <= text.length() / 2; i++){ //O(N / 2)
            int count = 0;
            for(int l = 0, r = i; r < text.length(); l++,r++){ // O(N)
                if(text.charAt(l) == text.charAt(r)){
                    count++;
                }else{
                    count = 0;
                }
                
                
                if(count == i){
                    hs.add(text.substring(l,r)); // O(N)
                    count--;
                }
            }
        }
        
        return hs.size();

        // time complexity O(N^3)
    }
}
/*
class Solution {
    public boolean helper(String str){
        boolean flag = false;
        int i = 0;
        int j = str.length() / 2;
        
        while(i < str.length() / 2){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;j++;
        } 
        return true;
    }
    public int distinctEchoSubstrings(String text) {
        
        HashSet<String> hs = new HashSet<>();
        for(int i = 0; i < text.length() - 1; i++){
            for(int j = i + 1; j < text.length(); j += 2){
                String str = text.substring(i,j + 1);
                if(helper(str)) hs.add(str);
            }
        }
                   
        return hs.size();           
    }
}
*/