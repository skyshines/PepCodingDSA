class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int ans = 0;
        HashMap<Long, Integer>[] maps = new HashMap[nums.length];
        
        //initialising empty hashmap
        for(int i = 0; i < nums.length; i++){
            maps[i] = new HashMap<>();
        }
        
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                long cd = (long)nums[i] - (long)nums[j];
                if(cd <= Integer.MIN_VALUE || cd >= Integer.MAX_VALUE){
                    continue;
                }
                
                int apsEndingOnJ = maps[j].getOrDefault(cd, 0);
                int apsEndingOnI = maps[i].getOrDefault(cd, 0);
                
                ans += apsEndingOnJ;
                maps[i].put(cd, apsEndingOnI + apsEndingOnJ + 1);
            }
        }
        
        return ans;
    }
}