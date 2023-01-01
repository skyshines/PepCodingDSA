class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        
        for(int val : asteroids){
            if(val > 0){
                st.push(val);
            }else{
                //popping small positive values
                
                while(st.size() > 0 && st.peek() > 0 && st.peek() < -val){
                    st.pop();
                }
                
                // now two things it has elements left or not
                // first dealing with elements left
                // could be equal or greater in magniute in + direction
                // in the last case where it had element s but all were in negative direction or stack got emptied out
                
                if(st.size() > 0 && st.peek() == -val){
                    // it was equal in magnitude
                    st.pop();
                }else if(st.size() > 0 && st.peek() > -val){
        
                }else{
                    st.push(val);
                    System.out.println(val);
                }
            }
        }
        
        int[] ans = new int[st.size()];
        for(int i = ans.length - 1; i >= 0; i--){
            ans[i] = st.pop();
        }
        
        return ans;
    }
}