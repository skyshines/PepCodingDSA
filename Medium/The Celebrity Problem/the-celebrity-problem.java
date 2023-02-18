//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java


class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	int pc = 0;
        //eliminating;
        for(int i = 1; i < n; i++){
            if(M[i][pc] == 0){
                pc = i;
            }
        }

        for(int i = 0; i < n; i++){
            if(i != pc){
                if(M[i][pc] == 0){
                    return -1;
                }

                if(M[pc][i] == 1){
                    return -1;
                }
            }
        }

        return pc;
    }
}