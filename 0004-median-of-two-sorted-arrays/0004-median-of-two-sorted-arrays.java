class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
        if(a.length > b.length){
            int[] temp = a;
            a = b;
            b = temp;
        }
        
        int lo = 0;
        int hi = a.length; //because left side elements jyada rahe and odd te par left subordinate ka max banda
        int te = a.length + b.length; //tottal number of elements
        
        
        while(lo <= hi){
            int aleft = lo + (hi - lo) / 2;
            int bleft = (te + 1)/2 - aleft;
            
            int alm1 = (aleft == 0) ? Integer.MIN_VALUE : a[aleft - 1];
            int al = (aleft == a.length) ? Integer.MAX_VALUE : a[aleft];
            int bl = (bleft == b.length) ? Integer.MAX_VALUE : b[bleft];
            int blm1 = (bleft == 0) ? Integer.MIN_VALUE : b[bleft - 1];
            
            if(alm1 <= bl && blm1 <= al){
                if(te % 2 == 0){
                    int lmax = Math.max(alm1, blm1);
                    int rmax = Math.min(al, bl);
                    
                    return (lmax + rmax) / 2.0;
                }else{
                    return Math.max(alm1, blm1);
                }
                
            }else if(alm1 > bl){
                hi = aleft - 1;            
            }else if(blm1 > al){
                lo = aleft + 1;
            }
            
        }
        
        return -1;
        
        
    }
}