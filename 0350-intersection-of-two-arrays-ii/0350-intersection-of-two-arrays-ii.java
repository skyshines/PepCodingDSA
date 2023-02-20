class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int val : nums1) hm.put(val,hm.getOrDefault(val,0) + 1);
        
        for(int val : nums2){
            if(hm.containsKey(val) && hm.get(val) > 0){
                ans.add(val);
                hm.put(val,hm.get(val) - 1);
            }
        }
        int[] arr = new int[ans.size()];
        for(int i = 0; i < arr.length; i++) arr[i] = ans.get(i);
        
        return arr;
    }
}