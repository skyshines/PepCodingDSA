/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int lo = 1; 
        int hi = n;
        //int first_bad = 0;
        
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            
            if(isBadVersion(mid) == true){
               hi = mid;
            }else{
                lo = mid + 1;
            }
        }
        
        return hi;
    }
}