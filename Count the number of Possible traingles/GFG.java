//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total count of testcases
        int t = sc.nextInt();
        
        while(t > 0)
        {
            //taking elements count
            int n = sc.nextInt();
            
            //creating an array of length n
            int arr[] = new int[n];
            
            //adding elements to the array
            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            
            //creating an object of class Solutions
            Solution ob = new Solution();
            
            //calling the method findNumberOfTriangles()
            //of class Solutions and printing the results
            System.out.println(ob.findNumberOfTriangles(arr,n));
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to count the number of possible triangles.
    static int findNumberOfTriangles(int arr[], int n)
    {
        Arrays.sort(arr);
        
        int count = 0;
        for(int i = n - 1; i >= 2; i--){
            int target = arr[i];
            
            int lo = 0;
            int hi = i - 1;
            
            while(lo < hi){
                if(arr[lo] + arr[hi] > target){
                    count += hi - lo; 
                    // lo  and hi donon ka sum target c bada
                    // lo and hi k beech wale sare elements lo c bade
                    //so they can become another lo too
                    //so we added them into count
                    //after this we decreased our hi since effectively
                    //decreasing our sum
                    //but we need to find another pair too
                    //n
                    hi--;
                }else{
                    // lo and hi ka sum chota ya barabar ho gya
                    //we need to increase sum\
                    //so we increase our lo
                    lo++;
                }
            }
        }
        
        
        return count;
        
    }
}
