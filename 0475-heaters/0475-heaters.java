class Solution {
    class Pair{
        int jl = -1;
        int js = -1;
    }
    
    public Pair binarySearch(int[] arr,int target){
        int lo = 0;
        int hi = arr.length - 1;
        Pair p = new Pair();
        
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            
            if(arr[mid] == target){
                p.jl = p.js = target;
                return p;
            }else if(arr[mid] > target){
                p.jl = arr[mid];
                hi = mid - 1;
            }else{
                p.js = arr[mid];
                lo = mid + 1;
            }
        }
        
        return p;
    }
    
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        
        int ans = 0;
        
        for(int house : houses){
            Pair p = binarySearch(heaters,house);
            
            int dl = (p.js == -1) ? Integer.MAX_VALUE : house - p.js;
            int dr = (p.jl == -1) ? Integer.MAX_VALUE : p.jl - house;
            
            ans = (int)Math.max((int)Math.min(dl,dr),ans);
        }
        
        return ans;
    }
}