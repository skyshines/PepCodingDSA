class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int n = pushed.length;
        
        int i = 0;
        int j = 0;
        
        while(i < n){
            st.push(pushed[i++]);
            
            while(st.size() > 0 && st.peek() == popped[j]){
                st.pop();
                j++;
            }
        }
        
        while(st.size() > 0){
            if(st.peek() == popped[j]){
                st.pop();
                j++;
            }else{
                return false;
            }
        }
        
        return true;
    }
}