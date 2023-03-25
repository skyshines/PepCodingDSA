class Solution {
    public boolean isFreqValid(int[] arr,int val){
        int freq = 0;
        for(int v : arr){
            if(v == val) freq++;
        } 
        
        return freq > (arr.length / 3);
        
    }
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        
        int val1 = 0,count1 = 0;
        int val2 = 0,count2 = 0;
        
        for(int num : nums){
            if((count1 == 0 && count2 == 0) || (count1 == 0 && count2 != 0 && val2 != num)){
                val1 = num;
                count1 = 1;
            }else if(val1 == num){
                count1++;
            }else if(count2 == 0){
                count2 = 1;
                val2 = num;
            }else if(val2 == num){
                count2++;
            }else{
                count1--;
                count2--;
            }
        }
        
        if(count1 != 0){
            if(isFreqValid(nums, val1)){
                ans.add(val1);
            }
        }
        
        if(count2 != 0){
            if(isFreqValid(nums, val2)){
                ans.add(val2);
            }
        }
        
        return ans;
    }
}