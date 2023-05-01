//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		
		Scanner sc = new Scanner (System.in);
		int t = Integer.parseInt(sc.next());
		
		while(t>0)
		{
		    String s = sc.next();
		    
		    Solution T = new Solution();
		    System.out.println(T.fun(s));
		    
		    t--;
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int fun(String s)
    {
        long a = 0;
        long ab = 0;
        long abc = 0;
        long mod = (long)1e9 + 7;
        
        
        for(char ch : s.toCharArray()){
            if(ch == 'a'){
                a = (2 * a + 1) % mod;
                
            }else if(ch == 'b'){
                ab = (a + 2 * ab) % mod;
            }else if(ch == 'c'){
                abc = (ab + 2 * abc) % mod;
            }
        }
        
        
        return (int)abc;
    }
}