class Solution {
    public boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'||ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
    
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        
        int i = 0;
        int j = arr.length - 1;
        
        while(i < j){
            if(isVowel(arr[i]) && isVowel(arr[j])){
                
                char ch = arr[i];
                arr[i] = arr[j];
                arr[j] = ch;
                i++;
                j--;
                
            }else{
                while(i < j && isVowel(arr[i]) == false) i++;
                
                while(i < j && isVowel(arr[j]) == false) j--;
            }
        }
        
        StringBuilder sb = new StringBuilder("");
        
        for(char ch : arr) sb.append(ch);
        
        return sb.toString();
    }
}