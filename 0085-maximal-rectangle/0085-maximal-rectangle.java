class Solution {
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
    
    
    public int maximalRectangle(char[][] matrix) {
        int max = 0;
        int[] arr = new int[matrix[0].length];
        
        for(int i = 0; i < matrix.length; i++){
            if(i == 0){
                for(int j = 0; j < matrix[i].length; j++){
                    arr[j] = matrix[i][j] - '0';
                }
            }else{
               for(int j = 0; j < matrix[i].length; j++){
                    if(matrix[i][j] == '0'){
                        arr[j] = 0;
                    }else{
                        arr[j]++;
                    }
                } 
            }
            max = Math.max(max,largestRectangleArea(arr));
        }
        
        return max;
    }
}