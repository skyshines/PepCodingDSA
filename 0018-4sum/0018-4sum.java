class Solution {
    public List<List<Integer>> twoSum(int[] nums,long target,int si) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int ei = nums.length - 1;
        while(si < ei){
            long sum = nums[si] + nums[ei];
            
            if(sum < target) si++;
            else if(sum > target) ei--;
            else{
                List<Integer> li = new ArrayList(Arrays.asList(nums[si], nums[ei]));
                ans.add(li);
                si++;
                ei--;
                
                while(si < ei && nums[si] == nums[si - 1]) si++;
                while(si < ei && nums[ei] == nums[ei + 1]) ei--;
            }
        }
        
        return ans;
    }
    
    
    public List<List<Integer>> kSumHelper(int[] nums,long target,int k,int si){
        if(k == 2){
            return twoSum(nums,target,si);
        }
        
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        
        if(n - k < 0){
            return res;
        }
        
   
        for(int i = si; i < n; i++){
            if(i != si && nums[i] == nums[i - 1]){
                continue;
            }
            
            long tar = target - nums[i];
            
            List<List<Integer>> subRes = kSumHelper(nums, tar, k - 1, i + 1);
            
            for(List<Integer> a : subRes){
                a.add(nums[i]);
                res.add(a);
            }
        }
        
        return res;
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int k = 4;
        return kSumHelper(nums,target*1L,k,0);
    }
}