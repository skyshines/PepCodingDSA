class Solution {
    public void createRes(List<List<Integer>> res,List<List<Integer>> ans, int val){
        for(List<Integer> a : ans){
            a.add(0,val);
            res.add(a);
        }
    }
    
    
    public List<List<Integer>> twoSum(int[] nums,int si,int ei,int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        while(si < ei){
            int sum = nums[si] + nums[ei];
            
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
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int target = 0;
        int si = 0;
        int ei = nums.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        
       for(int i = si; i <= ei; i++){
            if(i != si && nums[i] == nums[i - 1]) continue;
            
            List<List<Integer>> ans = twoSum(nums,i + 1, ei,target - nums[i]);
            createRes(res,ans,nums[i]);
        }
        
        return res;
    }
}