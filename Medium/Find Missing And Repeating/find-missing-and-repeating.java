//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int nums[], int n) {
        int xxory = 0;
        int i = 1; 
        for(int val : nums){
            xxory = (xxory ^ val) ^ (i++);
        }
        
        int rsbm = xxory & (-xxory);
        
        int a = 0;
        int b = 0;
        
        i = 1;
        
        for(int val : nums){
            if((val & rsbm) == 0){
                a = a ^ val;
            }else{
                b = b ^ val;
            }
            
            if((i & rsbm) == 0){
                a = a ^ i;
            }else{
                b = b ^ i;
            }
            
            i++;
        }
        
        int[] ans = new int[2];
        
        for(int val : nums){
            if(val == a){
                ans[0] = a;
                ans[1] = b;
                break;
            }else if(val == b){
                ans[0] = b;
                ans[1] = a;
                break;
            }
        }
        
        return ans;
    }
}