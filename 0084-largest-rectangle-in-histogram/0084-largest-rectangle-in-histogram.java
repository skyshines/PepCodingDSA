class Solution {
    //linear space - one stack and linear time
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int max = 0;
        for(int i = 0; i <= heights.length; i++){
            int ht = i != heights.length ? heights[i] : 0;
            while(st.peek() != -1 && heights[st.peek()] >= ht){
                int height = heights[st.pop()];
                int leftminimum = st.peek();
                int rightminimum = i;
                int area = height * (rightminimum - leftminimum - 1);
                max = Math.max(area,max);
            }
            
            st.push(i);
        }
        
        return max;
    }
}

/*
//constant time linear space
class Solution {
    public int largestRectangleArea(int[] heights) {
        //creating array of next smaller element left and right
        int[] nsl = new int[heights.length];
        int[] nsr = new int[heights.length];
        nsl[0] = -1; nsr[nsr.length - 1] = heights.length;
        //identity for width calculation
        
        Stack<Integer> st = new Stack<>();
        st.push(0);
        
        for(int i = 1; i < heights.length; i++){
            
            while(st.size() > 0 && heights[st.peek()] >= heights[i]){
                nsr[st.pop()] = i;
                
            }
            nsl[i] = st.size() != 0 ? st.peek() : -1;
            st.push(i);
        }
        
        while(st.size() > 0){
            nsr[st.pop()] = heights.length;
        }
        
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < heights.length; i++){
            int width = nsr[i] - nsl[i] - 1;
            int area = heights[i] * width;
            max = (int)Math.max(max,area);
        }
        
        return max;
    }
}

*/