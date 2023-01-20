//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.util.HashMap;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) 
                a[i] = sc.nextInt();
            Solution g = new Solution();
            
            ArrayList<Integer> ans = g.countDistinct(a, n, k);

            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
            t--;
        }
    }
}
// } Driver Code Ends


class Solution
{
    ArrayList<Integer> countDistinct(int nums[], int n, int k)
    {
        HashMap<Integer, Integer> hm = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++){
            if(i < k - 1){
                hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
            }else{
                //acquire
                
                hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
                
                //get size
                ans.add(hm.size());
                
                //remove
                
                int j = i - k + 1;
                
                if(hm.get(nums[j]) > 1){
                    hm.put(nums[j], hm.get(nums[j]) - 1);
                }else{
                    hm.remove(nums[j]);
                }
            }
        }
        
        return ans;
    }
}

