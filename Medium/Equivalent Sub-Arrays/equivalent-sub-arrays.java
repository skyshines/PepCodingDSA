//{ Driver Code Starts
//Initial Template for Java


//Initial Template for Java


import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


 
class Solution
{ 
    // Method to calculate distinct sub-array 
    static int countDistinctSubarray(int arr[], int n)
    { 
        int k = 0;
        HashSet<Integer> hs = new HashSet<>();
        
        for(int v : arr) hs.add(v);
        
        k = hs.size();
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        int i = -1;
        int j = -1;
        int ans = 0;
        
        while(true){
            boolean flag1 = false;
            boolean flag2 = false;
            
            //acquire
            while(i < n - 1){
                flag1 = true;
                
                i++;
                hm.put(arr[i], hm.getOrDefault(arr[i] , 0) + 1);
                
                if(hm.size() == k){
                    break;
                }
            }
            
            //release
            
            while(j < i){
                flag2 = true;
                
                if(hm.size() == k){
                    ans += n - i;
                }
                
                j++;
                hm.put(arr[j], hm.get(arr[j]) - 1);
                
                if(hm.get(arr[j]) == 0) hm.remove(arr[j]);
                
                if(hm.size() < k){
                    break;
                }
            }
            
            if(flag1 == false && flag2 == false){
                break;
            }
        }
        
        return ans;
    }
}


//{ Driver Code Starts.

// Driver class
class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		// looping through all testcases
		while(testcases-- > 0){
		    int n=Integer.parseInt(br.readLine());
		    String line1 = br.readLine();
		    String[] a1 = line1.trim().split("\\s+");
		    int a[]=new int[n];
		    for(int i=0;i<n;i++)
		    {
		        a[i]=Integer.parseInt(a1[i]);
		    }
		    Solution ob=new Solution();
		    int ans=ob.countDistinctSubarray(a,n);
		    System.out.println(ans);
		    
		}
	}
}

// } Driver Code Ends