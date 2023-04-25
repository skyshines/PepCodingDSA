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
            String inline[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(inline[0]);
            int m = Integer.parseInt(inline[1]);
            String inline1[] = in.readLine().trim().split("\\s+");
            int M[][] = new int[n][m];
            for(int i = 0;i < n*m;i++){
                M[i/m][i%m] = Integer.parseInt(inline1[i]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.maxGold(n, m, M));
        }
    }
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxGold(int n, int m, int grid[][])
    {
        int sum = 0;
        for(int val : grid[0]){
            sum += val;
        }
        
        if(n == 1) return sum;
        int ans = 0;
        
        for(int j = grid[0].length - 1; j >= 0; j--){
            for(int i = 0; i < grid.length; i++){
                if(j == grid[0].length - 1){
                    
                }else if(i == 0){
                    grid[i][j] += grid[i][j + 1] > grid[i + 1][j + 1] ? grid[i][j + 1] : grid[i + 1][j + 1];
                }else if(i == grid.length - 1){
                    grid[i][j] += grid[i][j + 1] > grid[i - 1][j + 1] ? grid[i][j + 1] : grid[i - 1][j + 1];
                }else{
                    int max = grid[i][j + 1] > grid[i + 1][j + 1] ? grid[i][j + 1] : grid[i + 1][j + 1];
                    if(max < grid[i - 1][j + 1]) max = grid[i - 1][j + 1];
                    
                    grid[i][j] += max;
                }
                
                if(j == 0){
                    if(grid[i][j] > ans) ans = grid[i][j];
                }
            }
            
            
        }
        
        return ans;
    }
}