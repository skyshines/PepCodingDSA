class Solution {
    public boolean canReorderDoubled(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int val : arr){
            hm.put(val, hm.getOrDefault(val, 0) + 1);
        }
        
        Integer[] ar = new Integer[arr.length];
        
        for(int i = 0; i < arr.length; i++){
            ar[i] = arr[i];
        }
        
        Arrays.sort(ar, (a,b) -> {
            return Math.abs(a) - Math.abs(b);
        });
        
        for(int i = 0; i < arr.length; i++){
            int val = ar[i];
            
            if(hm.get(val) == 0) continue;
            
            if(hm.getOrDefault(2 * val, 0) == 0){
                return false;
            }else{
                    hm.put( 2 * val, hm.get(2 * val) - 1);
                    hm.put( val, hm.get(val) - 1);
            }
        }
        
        return true;
    }
}