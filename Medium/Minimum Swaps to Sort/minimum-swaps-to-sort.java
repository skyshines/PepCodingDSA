//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends




class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        int n = nums.length;
        Pair[] arr = new Pair[n];
        
        for(int i = 0; i < n; i++){
            arr[i] = new Pair(nums[i], i);
        }
        
        Arrays.sort(arr);
        
        boolean[] visited = new boolean[n];
        int ans = 0;
        
        for(int i = 0; i < n; i++){
            if(visited[i] == true || arr[i].idx == i){
                continue;
            }
            
            int cycleLength = 0;
            int j = i;
            
            while(visited[j] == false){
                visited[j] = true;
                cycleLength++;
                j = arr[j].idx;
            }
            
            ans += cycleLength - 1;
        }
        
        return ans;
    }
    
    public class Pair implements Comparable<Pair>{
        int val;
        int idx;
        
        Pair(int val,int idx){
            this.val = val;
            this.idx = idx;
        }
        
        public int compareTo(Pair o){
            return this.val - o.val;
        }
    }
}