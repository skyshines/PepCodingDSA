//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            int n = Integer.parseInt(read.readLine());
            String input[] = read.readLine().split(" ");
            
            int arr[] = new int[n];
            for(int i = 0;i<n;i++){
                arr[i] = Integer.parseInt(input[i]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.countTriplet(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int pairSumTarget(int[] arr,int hi,int target){
        int count = 0;
        int lo = 0;
        //lo == hi par kaam nhi karna since
        //pair chahiye single lement ka kya h karenge
        //since elements are distinct we can increment 
        //lo and hi because wo same lo hi aur exist nhi 
        //karenge to form another potential pair
        
        
        while(lo < hi){
          if(arr[lo] + arr[hi] < target){
              lo++;
          }else if(arr[lo] + arr[hi] > target){
              hi--;
          }else{
              count++;
              hi--;
              lo++;
          } 
        }
        
        return count;
    }
    
    int countTriplet(int arr[], int n) {
        // code here
        Arrays.sort(arr);
        int count = 0;
        for(int i = n - 1; i >= 2; i--){
           count += pairSumTarget(arr,i - 1,arr[i]); 
        }
        
        return count;
    }
}

/*
we are looking for a pair whose sum will be equal to target
why sorted?
comparsions less here we will limit the no of concerned pairs
li increment when target c chota since li k aaga wala bada
ri decrement when target c bada since ri c pichle banda chota
*/
