//{ Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().distinctCount(arr, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java




class Solution {
    int distinctCount(int[] arr, int n) {
        // code here
        int i = 0;
        int j = arr.length - 1;
        int count = 0;
        
        while(i <= j){
            int abs1 = Math.abs(arr[i]);
            int abs2 = Math.abs(arr[j]);
            
            if(abs1 == abs2){
                i++;
                j--;
                
                while(i < arr.length && arr[i] == arr[i - 1]) i++;
                while(j >= 0 && arr[j] == arr[j + 1]) j--;
            }else if(abs1 > abs2){
                i++;
                
                while(i < arr.length && arr[i] == arr[i - 1]) i++;
            }else{
                j--;
                
                while(j >= 0 && arr[j] == arr[j + 1]) j--;
            }
            
            count++;
            
        }
        
        return count;
    }
}
