class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            if(hm.containsKey(target - nums[i])){
                return new int[]{i, hm.get(target - nums[i])};
            }else{
                hm.put(nums[i], i);
            }
        }
        
        return new int[]{};
    }
}

/*
Rough
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            hm.put(nums[i], i);
        }
        
        int[] arr = new int[2];
        int si = 0;
        int ei = nums.length - 1;
        
        while(si < ei){
            int sum = nums[si] + nums[ei];
            
            if(sum < target) si++;
            else if(sum > target) ei--;
            else{
                arr[0] = hm.get(nums[si]);
                arr[1] = hm.get(nums[ei]);
                break;
            }
        }
        
        return arr;
    }
}
*/