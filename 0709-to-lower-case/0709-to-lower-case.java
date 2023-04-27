class Solution {
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        
        for(char ch : s.toCharArray()){
            if(ch >= 'A' && ch <= 'Z'){
                char nch = (char)(ch - 'A' + 'a');
                sb.append(nch);
            }else{
                sb.append(ch);
            }
        }
        
        return sb.toString();
    }
}