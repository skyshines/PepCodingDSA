class Solution {
    static int size;
    public int binarySearch(ArrayList<Integer> list, int num){
        int left = 0;
        int right = size;
        
        while(left < right){
            int mid = left + (right - left) / 2;
            
            
            if(list.get(mid) < num){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        
        return left;
    }
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> temp = new ArrayList<>();
        size = 0;
        
        for(int num : nums){
            if(size == 0 || temp.get(size - 1) < num){
                temp.add(num);
                size++;
            }else{
                int idx = binarySearch(temp, num);
                temp.set(idx, num);
            }
        }
        
        return size;
    }
}