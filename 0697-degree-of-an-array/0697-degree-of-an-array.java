class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> fm = new HashMap<>();
        HashMap<Integer, Integer> sm = new HashMap<>();
        
        int length = 0;
        int freq = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(fm.containsKey(nums[i])){
                fm.put(nums[i], fm.get(nums[i]) + 1);
            }else{
                fm.put(nums[i], 1);
                sm.put(nums[i], i);
            }
            
            int f = fm.get(nums[i]);
            
            if(f < freq){
                continue;
            }else if(f == freq){
                int start = sm.get(nums[i]);
                int end = i;
                int len = end - start + 1;
                
                if(len < length) length = len;
            }else{
                freq = f;
                
                int start = sm.get(nums[i]);
                int end = i;
                int len = end - start + 1;
                
                length = len;
            }
        }
        
        return length;
    }
}