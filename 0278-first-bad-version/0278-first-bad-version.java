/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int lo = 1;
        int hi = n;
        int mid = 0;
        int fbv = 0;
        
        
        while(lo <= hi){
            mid = lo + (hi - lo) / 2;
            
            if(isBadVersion(mid)){
                fbv = mid;
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        
        return fbv;
            
    }
}