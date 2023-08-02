class Solution {
    public void createRes(List<List<Integer>> res,List<List<Integer>> ans, int val){
        
        for(List<Integer> a : ans){
            a.add(val);
            res.add(a);
        }
    }
    
    
    public List<List<Integer>> twoSum(int[] nums,int si,int ei,long target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
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
    
    public List<List<Integer>> threeSum(int[] nums,int si,int ei,long target) {
       List<List<Integer>> res = new ArrayList<List<Integer>>();
        
      
        
       for(int i = si; i <= ei - 2; i++){
            if(i != si && nums[i] == nums[i - 1]) continue;
            long tar = target - nums[i];
            List<List<Integer>> ans = twoSum(nums,i + 1, ei,tar);
            createRes(res,ans,nums[i]);
            
        }
        
        return res;
    }
        
    
    
    public List<List<Integer>> fourSum(int[] nums, int t) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        long target = t * 1L;
        int si = 0;
        int ei = nums.length - 1;
        
        for(int i = si; i <= ei - 3; i++){
            if(i != si && nums[i] == nums[i - 1]) continue;
            long tar = target - nums[i];
            
            List<List<Integer>> ans = threeSum(nums,i + 1, ei,tar);
            
            createRes(res,ans,nums[i]);
            
        }
        
        return res;
        
    }
}