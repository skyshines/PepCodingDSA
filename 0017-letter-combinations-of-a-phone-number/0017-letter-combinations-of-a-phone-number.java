class Solution {
    String[] keypad = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public ArrayList<String> getKPC(String digits){
        if(digits.length() == 0){
            ArrayList<String> ans = new ArrayList<>();
            ans.add("");
            return ans;
        }
        
        int digit = digits.charAt(0) - '0';
        String keys = keypad[digit];
        
        ArrayList<String> rres = getKPC(digits.substring(1));
        ArrayList<String> ans = new ArrayList<>();
        
        for(char ch : keys.toCharArray()){
            for(String s : rres) ans.add(ch + s);
        }
        
        return ans;
    }
    
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<>();
        return getKPC(digits);
    }
}