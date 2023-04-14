class Solution {
    public void solver(String s,List<String> asf,List<List<String>> ans){
        if(s.length() == 0){
            ans.add(new ArrayList<>(asf));
            return;
        }
        
        
        for(int i = 0; i < s.length(); i++){
            String prefix = s.substring(0, i + 1);
            String ros = s.substring(i + 1);
            
            if(isPalindromic(prefix)){
                asf.add(prefix);
                solver(ros, asf, ans);
                asf.remove(asf.size() - 1);
            }
        }
    }
    
    public boolean isPalindromic(String str){
        int i = 0;
        int j = str.length() - 1;
        
        while(i < j){
            if(str.charAt(i) == str.charAt(j)){
                i++;
                j--;
            }else{
                return false;
            }
        }
        
        return true;
    }
    public List<List<String>> partition(String s) {
         List<List<String>> ans = new ArrayList<>();
         solver(s, new ArrayList<>(), ans);
        return ans;
    }
}