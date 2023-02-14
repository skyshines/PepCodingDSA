//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S1[] = read.readLine().split(" ");
            String S2[] = read.readLine().split(" ");
            
            int[] X = new int[N];
            int[] Y = new int[N];
            
            for(int i=0; i<N; i++)
            {
                X[i] = Integer.parseInt(S1[i]);
                Y[i] = Integer.parseInt(S2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.numOfPairs(X,Y,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int numOfPairs(int[] X, int[] Y, int N) {
        int count = 0;
        
        HashMap<Integer,Integer> xfreq = new HashMap<>();
        HashMap<Integer,Integer> yfreq = new HashMap<>();
        HashMap<String,Integer> xyfreq = new HashMap<>();
        
        for(int i = 0; i < N; i++){
            int x = X[i];
            int y = Y[i];
            String xy = "" + x + "." + y;
            
            count += xfreq.getOrDefault(x,0) + yfreq.getOrDefault(y,0) - 2 * (xyfreq.getOrDefault(xy,0));
            
            xfreq.put(x,xfreq.getOrDefault(x,0) + 1);
            yfreq.put(y,yfreq.getOrDefault(y,0) + 1);
            xyfreq.put(xy,xyfreq.getOrDefault(xy,0) + 1);
        }
        
        return count;
    }
}