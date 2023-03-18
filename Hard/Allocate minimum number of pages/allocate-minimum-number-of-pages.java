//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    public static boolean isPossible(int[] arr, long target, int k){
        int students = 1;
        long sum = 0;
        
        for(int val : arr){
            if(sum + val > target){
                students++;
                sum = 1L * val;
            }else{
                sum += val;
            }
        }
        
        return students <= k;
    }
    //Function to find minimum number of pages.
    public static int findPages(int[]arr,int N,int M)
    {
        long sum = 0L;
        int max = 0;
        
        for(int val : arr){
            sum += val;
            if(val > max) max = val;
        }
        
        if(M == 1) return (int)sum;
        if(M == N) return max;
        if(M > N) return -1;
        
        long lo = 1L * max;
        long hi = sum;
        
        long ans = 0;
        
        while(lo <= hi){
            long mid = lo + (hi - lo) / 2;
            
            if(isPossible(arr,mid,M) == true){
                ans = mid;
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        
        return (int)ans;
    }
}