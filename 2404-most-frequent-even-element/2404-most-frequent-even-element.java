class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int num : nums){
            if((num & 1) == 0){
                hm.put(num, hm.getOrDefault(num, 0) + 1);
            }
        }
        
        if(hm.size() == 0) return -1;
        
        int ans = 0;
        
        for(int key : hm.keySet()){
            if(hm.getOrDefault(ans, 0) < hm.get(key)){
                ans = key;
            }else if(hm.getOrDefault(ans, 0) == hm.get(key)){
                if(key < ans){
                    ans = key;
                }
            }
        }
        
        return ans;
    }
}