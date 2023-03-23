class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int width = height.length - 1;
        
        int water = 0;
        
        while(i < j){
            if(height[i] <= height[j]){
                if(water < height[i] * width) water = height[i] * width;
                i++;
            }else if(height[i] > height[j]){
                if(water < height[j] * width) water = height[j] * width;
                j--;
            }
            width--;
        }
        
        return water;
    }
}