//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0; i < N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.offerings(N, arr));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int offerings(int N, int arr[]){
       int[] loff = new int[arr.length]; // left to right;
       loff[0] = 1;
       int[] roff = new int[arr.length]; //right to left;
       roff[arr.length - 1] = 1;
       
       int off = 1;
       for(int i = 1; i < arr.length; i++){
           if(arr[i] > arr[i - 1]){
               off++;
           }else{
               off = 1;
           }
           
           loff[i] = off;
       }
       
       off = 1;
       
       for(int i = arr.length - 2; i >= 0; i--){
           if(arr[i] > arr[i + 1]){
               off++;
           }else{
               off = 1;
           }
           roff[i] = off;
       }
       
       int sum = 0;
       
       for(int i = 0; i < arr.length; i++){
          sum += (int)Math.max(loff[i],roff[i]); 
       }
       
       return sum;
    }
}