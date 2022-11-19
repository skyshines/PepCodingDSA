class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int[] merged = new int[nums1.length + nums2.length];
        
        int i = 0, j = 0,c = 0;
        
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                merged[c] = nums1[i];
                i++;
                c++;
            }else{
                merged[c] = nums2[j];
                j++;
                c++;
            }
        }
        
        if(i == nums1.length){
            while(j < nums2.length){
                merged[c] = nums2[j];
                j++;
                c++;
            }
        }
        
        if(j == nums2.length){
            while(i < nums1.length){
                merged[c] = nums1[i];
                i++;
                c++;
            }
        }
        
        
        if(merged.length % 2 == 0){
            double ans = merged[merged.length / 2] + merged[-1 + merged.length / 2];
            return ans / 2;
        }else{
            return merged[merged.length / 2];
        }
    }
}