//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int[] arr = new int[n];
            
            for (int i = 0; i < n; ++i)
                arr[i] = sc.nextInt ();

    		System.out.println (new Sol().search (arr, n));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Sol
{
    public static int search(int arr[], int N)
    {
        int lo = 0;
        int hi = arr.length - 1;
        
        while(lo <= hi){
            if(lo == hi){
                return arr[lo];
            }else{
                int mid = lo + (hi - lo) / 2;
                
                if(arr[mid] == arr[mid + 1]){
                    int rightCount = hi - mid + 1;
                    
                    if(rightCount % 2 == 1){
                        lo = mid;
                    }else{
                        hi = mid - 1;
                    }
                }else if(arr[mid - 1] == arr[mid]){
                    int leftCount = mid - lo + 1;
                    
                    if(leftCount % 2 == 1){
                        hi = mid;
                    }else{
                        lo = mid + 1;
                    }
                }else if(arr[mid] != arr[mid + 1] && arr[mid - 1] != arr[mid]){
                    return arr[mid];
                }
            }
        }
        
        return 0;
    }
}