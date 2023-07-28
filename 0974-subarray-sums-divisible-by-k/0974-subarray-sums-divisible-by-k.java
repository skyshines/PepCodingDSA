class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1);
        
        int ans = 0;
        int sum = 0;
        
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            int r = (sum) % k;
            if(r < 0) r += k;
            
            ans += hm.getOrDefault(r, 0);
            
            hm.put(r, hm.getOrDefault(r,0) + 1);
        }
        
        return ans;
    }
}