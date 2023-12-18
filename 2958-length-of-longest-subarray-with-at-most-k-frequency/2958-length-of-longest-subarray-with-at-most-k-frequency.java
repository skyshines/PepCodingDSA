class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int ans = 0;
        int i = -1;
        int j = -1;
        
        while(true){
            boolean flag1 = false;
            boolean flag2 = false;
            
            //acquire
            while(i < nums.length - 1){
                flag1 = true;
                
                i++;
                hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
                
                if(hm.get(nums[i]) > k){
                    break;
                }else{
                    if(ans < i - j) ans = i - j;
                }
            }
            
            //release
            while(j < i){
                flag2 = true;
                j++;
                
                hm.put(nums[j], hm.get(nums[j]) - 1);
                
                if(hm.getOrDefault(nums[j], 0) == k){
                    break;
                }
            }
            
            if(flag1 == false && flag2 == false){
                break;
            }
        }
        
        return ans;
    }
}