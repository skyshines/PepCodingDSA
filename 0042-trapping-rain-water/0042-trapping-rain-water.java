class Solution {
    public int trap(int[] height) {
        int ans = 0;
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < height.length; i++){
            while(st.size() > 0 && height[st.peek()] <= height[i]){
                int rightmax = i;
                int current = st.pop();
                
                if(st.size() != 0){
                    int leftmax = st.peek();
                    int width = rightmax - leftmax - 1;
                
                    ans += ((int)Math.min(height[leftmax],height[rightmax]) - height[current]) * width;
                }
            }
            st.push(i);
        }
        return ans;
    }
}