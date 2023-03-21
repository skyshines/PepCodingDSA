class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int num : nums){
            int mod = num % value;
            if(mod < 0) mod += value;
            hm.put(mod, hm.getOrDefault(mod, 0) + 1);
        }
        
        int ans = 0;
        int val = 0;
        
        while(true){
            if(hm.containsKey(val) && hm.get(val) > 0){
                hm.put(val, hm.get(val) - 1);
                ans++;
                val = (val + 1) % value;
            }else{
                break;
            }
        }
        
        return ans;
    }
}