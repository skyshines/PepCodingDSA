//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    int arr[] = new int[n];
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    int k = Integer.parseInt(br.readLine().trim());
		    
		    Solution ob= new Solution();
		    System.out.println(ob.countKdivPairs(arr, n, k));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static long countKdivPairs(int arr[], int n, int k)
    {
        if(k == 1){
            return n * (n - 1) / 2;
        }
        
        int[] freq = new int[k];
        
        for(int val : arr){
            freq[val % k]++;
        }
        
        long count = 0;
        
        for(int i = 0; i <= k / 2; i++){
            if(i == 0 || (i == k - i)){
                count += freq[i] *  (freq[i] - 1) / 2;
            }else{
                count += freq[i] * freq[k - i];
            }
        }
        
        return count;
    }
}