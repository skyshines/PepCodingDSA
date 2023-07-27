//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code her
        int i = -1;
        int j = -1;
        int ans = -1;
        
        HashMap<Character, Integer> hm = new HashMap<>();
        
        while(true){
            boolean flag1 = false;
            boolean flag2 = false;
            
            while(i < s.length() - 1){
                flag1 = true;
                
                i++;
                char ch = s.charAt(i);
                hm.put(ch, hm.getOrDefault(ch, 0) + 1);
                
                if(hm.size() < k){
                    continue;
                }else if(hm.size() == k){
                    int len = i - j;
                    if(ans < len) ans = len;
                }else{
                    break;
                }
            }
            
            while(j < i){
                flag2 = true;
                
                j++;
                char ch = s.charAt(j);
                
                if(hm.get(ch) == 1){
                    hm.remove(ch);
                }else{
                    hm.put(ch, hm.get(ch) - 1);
                }
                
                if(hm.size() > k){
                    continue;
                }else{
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