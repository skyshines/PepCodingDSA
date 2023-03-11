//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG
{
	static int n;
	static int k;
	
	// Driver Code
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine()); //Inputting the testcases
		
		while(t>0) //While testcases exist
		{
			
			n = Integer.parseInt(br.readLine()); //Input N
			
			Solution obj = new Solution();
			
			System.out.println(obj.reverseBits(n));
            
            t--;
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int reverseBits(int n)
    {
        boolean flag = false;
        int j = 0;
        int rev = 0;
        
        for(int i = 31; i >= 0; i--){
            int mask = (1 << i);
            if(flag == false){
                if((n & mask) == 0){
                    
                }else{
                    flag = true;
                    rev = (rev | (1 << j));
                    j++;
                }
            }else{
                if((n & mask) == 0){
                    
                }else{
                    rev = (rev | (1 << j));
                }
                
                j++;
            }
        }
        
        return rev;
    }
}