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
        int count1 = 0;
        int count2 = 0;
        int val1 = 0, val2 = 0;
        
        for(int val : nums){
            if(count1 == 0 && count2 == 0){
                count1 = 1;
                val1 = val;
            }else if(count1 == 0){
                if(val == val2){
                    count2++;
                }else{
                    count1 = 1;
                    val1 = val;
                }
            }else if(count2 == 0){
                if(val == val1){
                    count1++;
                }else{
                    count2 = 1;
                    val2 = val;
                }
            }else{
                if(val1 == val){
                    count1++;
                }else if(val2 == val){
                    count2++;
                }else{
                    count1--;
                    count2--;
                }
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