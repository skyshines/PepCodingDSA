//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution{
    public void cutStrategy(int[] dp,int[] newPrice){
        for(int i = 2; i < dp.length; i++){
            dp[i] = newPrice[i];
            
            for(int j = 1; j < i; j++){
                int potentialAns = newPrice[j] + dp[i - j];
                
                if(potentialAns > dp[i]){
                    dp[i] = potentialAns;
                }
            }
        }
    }
    
    public void leftRightStrategy(int[] dp,int[] newPrice){
        for(int i = 2; i < dp.length; i++){
            dp[i] = newPrice[i];
            
            int left = 1;
            int right = i - 1;
            
            while(left <= right){
                if(dp[left] + dp[right] > dp[i]){
                    dp[i] = dp[left] + dp[right];
                }
                
                left++;
                right--;
            }
        }
    }
    
    public int cutRod(int price[], int n) {
        //code here
        int[] newPrice = new int[price.length + 1];
        
        for(int i = 0; i < price.length; i++){
            newPrice[i + 1] = price[i];
        }
        
        int[] dp = new int[price.length + 1];
        
        dp[0] = 0;
        dp[1] = newPrice[1];
        
        leftRightStrategy(dp, newPrice);
        
        return dp[dp.length - 1];
    }
}