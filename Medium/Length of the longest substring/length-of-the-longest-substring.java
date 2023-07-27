//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String s = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubsttr(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution{
    int longestUniqueSubsttr(String s){
        //acquire and release strategy;
        
        int i = -1;
        int j = -1;
        int ans = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        
        while(true){
            boolean flag1 = false;
            boolean flag2 = false;
            
            while(i < s.length() - 1){
                flag1 = true;
                
                i++;
                char ch = s.charAt(i);
                
                hm.put(ch, hm.getOrDefault(ch, 0) + 1);
                
                if(hm.get(ch) == 2){
                    break;
                }else{
                    int len = i - j;
                    if(ans < len) ans = len;
                }
            }
            
            while(j < i){
                flag2 = true;
                
                j++;
                char ch = s.charAt(j);
                
                hm.put(ch, hm.get(ch) - 1);
                
                if(hm.get(ch) == 0){
                    hm.remove(ch);
                }else if(hm.get(ch) == 1){
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