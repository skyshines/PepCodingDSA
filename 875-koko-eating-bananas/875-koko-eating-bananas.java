class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < piles.length; i++){
            max = (int)Math.max(max,piles[i]);
        }
        
        if(h == piles.length){
            return max;
        }
        
        int lo = 0; int hi = max; int speed = 0;
        
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2; //since idhar array k index nhi balki unki value  concerned hai overflow ho sakta, so to avoid that we write like this
            
            if(hours(piles,mid) <= h){ //yadi hours required c kam hai
//speed ko update kiya because we need minimum speed
                speed = mid;
                hi = mid - 1; // to check kahi aur koi minimum speed to exist nhi karti we continued our binary search
            }else{
                lo = mid + 1; // hours jada nikle speed badhane padegi
            }
            
        }
        
        return speed;
    }
    
    public int hours(int[] arr,int speed){
        int hour = 0;
        
        for(int i = 0; i < arr.length; i++){
            //hour += (arr[i] + speed - 1) / speed;
            
            hour += (int)Math.ceil(arr[i]*1.0 / speed);
            //hour += arr[i] * 1.0 % speed == 0 ? arr[i] * 1.0 / speed : (arr[i] * 1.0/ speed) + 1; time taking
        }
        
        return hour;
    }
    
    /*
    total += (p+m-1) / m equal to total += Math.ceil( p/m)
    for new test cases nhi chal rha ye formulae since lo = 1 se start karna chahiye par wo bhi test case par fail ho rha
    
    so ideally use ceil function
    
    */
}