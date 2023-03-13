class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1);
        int length = 0;
        int sum = 0;
        
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            if(num == 0) sum--;
            else sum++;
            
            Integer j = hm.get(sum);
            
            if(j != null){
                length = (int)Math.max(length, i - j);
            }
            
            if(j == null){
                hm.put(sum, i);
            }
        }
        
        return length;
    }
}