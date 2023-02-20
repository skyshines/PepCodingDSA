class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Boolean> hm = new HashMap<>();
        
        for(int val : nums) hm.put(val,true);
        
        for(int val : nums){
            if(hm.containsKey(val - 1)){
                hm.put(val,false);
            }
        }
        
        
        int max = 0;
        
        for(int val : nums){
            if(hm.get(val) == true){
                int count = 1;
                
                while(hm.containsKey(val + 1)){
                    count++; val++;
                }
                
                max = (int)Math.max(count,max);
            }
        }
        
        return max;
    }
}