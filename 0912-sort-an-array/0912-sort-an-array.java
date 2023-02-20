class Solution {
    public int[] sortArray(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int val : nums) pq.add(val);
        
        for(int i = 0; i < nums.length; i++){
            nums[i] = pq.remove();
        }
        
        return nums;
    }
}