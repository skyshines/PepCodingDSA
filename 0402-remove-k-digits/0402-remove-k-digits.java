class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < num.length(); i++){
            char ch = num.charAt(i);
            
            while(st.size() > 0 && k > 0 && st.peek() > ch){
                st.pop();
                k--;
            }
            
            st.push(ch);
        }
        
        
        while(st.size() > 0 && k > 0){
            st.pop();
            k--;
        }
        // here we dont have to write st.size() > 0 because
        // as per constraint k <= nums.length
        
        
        char[] ans = new char[st.size()];
        for(int i = ans.length - 1; i >= 0; i--) ans[i] = st.pop();
        
        //leading zeroes removed
        
        int d = 0;
        while(d < ans.length && ans[d] == '0') d++;
        
        
        StringBuilder sb = new StringBuilder("");
        while(d < ans.length){
            sb.append(ans[d]);
            d++;
        }
        
        if(sb.length() == 0){
            return "0";
        }else{
            return sb.toString();
        }
    }
}