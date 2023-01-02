class Solution {
    public String removeDuplicateLetters(String s) {
        if(s.length() == 0|| s.length() == 1) return s;
        
        Stack<Character> st = new Stack<>();
        boolean[] exist = new boolean[26];
        int[] freq = new int[26];
        
        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }
        
        for(char ch : s.toCharArray()){
            freq[ch - 'a']--;
            
            if(exist[ch - 'a'] == false){
                
                while(st.size() > 0 && st.peek() > ch && freq[st.peek() - 'a'] > 0){
                    exist[st.pop() - 'a'] = false;
                }
                
                st.push(ch);
                exist[ch - 'a'] = true;
            }
        }
        
        char[] ans = new char[st.size()];
        for(int i = ans.length - 1; i>= 0; i--) ans[i] = st.pop();
        
        return new String(ans);
    }
}