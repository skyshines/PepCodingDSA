//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int phy[] = new int[n];
    		int chem[] = new int[n];
    		int math[] = new int[n];
            
            for (int i = 0; i < n; ++i)
                {
                    phy[i]=sc.nextInt();
                    chem[i]=sc.nextInt();
                    math[i]=sc.nextInt();
                }
		    
		    Solution ob = new Solution();
		    
		    ob.customSort (phy, chem, math, n);
    		for (int i = 0; i < n; ++i)
    			System.out.println(phy[i]+" " + chem[i] + " " + math[i]);

        }
        
    }
}
// } Driver Code Ends


//User function Template for Java



//User function Template for Java

class Solution
{
    
    class Mark implements Comparable<Mark>{
        int phymark;
        int chemmark;
        int mathmark;
        
        Mark(int phymark,int chemmark,int mathmark){
            this.phymark = phymark;
            this.chemmark = chemmark;
            this.mathmark = mathmark;
        }
        
        public int compareTo(Mark o){
            if(this.phymark != o.phymark){
                return this.phymark - o.phymark;
            }else if(this.chemmark != o.chemmark){
                return o.chemmark - this.chemmark;
            }else{
                return this.mathmark - o.mathmark;
            }
            }
        }
    
    
    
    public void customSort (int phy[], int chem[], int math[], int N)
    {
        Mark[] student = new Mark[phy.length];
        // your code here
        for(int i = 0; i < phy.length; i++){
            student[i] = new Mark(phy[i],chem[i],math[i]);
        }
        
        Arrays.sort(student);
        
        for(int i = 0; i < phy.length; i++){
            phy[i] = student[i].phymark;
            chem[i] = student[i].chemmark;
            math[i] = student[i].mathmark;
        }
    }
}
