class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int val : nums1) hm.put(val,hm.getOrDefault(val,0) + 1);
        
        for(int val : nums2){
            if(hm.containsKey(val)){
                ans.add(val);
                hm.remove(val);
            }
        }
        int[] arr = new int[ans.size()];
        for(int i = 0; i < arr.length; i++) arr[i] = ans.get(i);
        
        return arr;
    }
}