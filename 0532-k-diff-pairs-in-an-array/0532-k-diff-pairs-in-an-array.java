class Solution {
    public int findPairs(int[] arr, int k){
        if(arr.length < 2) return 0;
        
        Arrays.sort(arr);
        
        int count = 0;
        
        int i = 0;
        int j = 1;
        
        while(i < arr.length && j < arr.length){
            if(i != j && arr[j] - arr[i] == k){
                count++;
                i++;
                
                while(i < arr.length && arr[i] == arr[i - 1]) i++;
                
            }else if(arr[j] - arr[i] < k){
                j++;
            }else{
                i++;
            }
        }
        
        return count;
    }
    public int findPairs2(int[] nums, int k) {
        int count = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
           
            count += (int)Math.max(hm.getOrDefault(k + nums[i],0),hm.getOrDefault(-k + nums[i],0));
            
            hm.put(nums[i],hm.getOrDefault(nums[i],0) + 1);
        }
        
        return count;
    }
}