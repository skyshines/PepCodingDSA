//{ Driver Code Starts
import java.util.*;

class Count
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int m = sc.nextInt();
            int n = sc.nextInt();
            
            int arr1[] = new int[m];
            int arr2[] = new int[n];
            
            for(int i = 0; i < m; i++)
              arr1[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              arr2[i] = sc.nextInt();
              
            Solution gfg = new Solution();
            ArrayList<Integer> res = gfg.countEleLessThanOrEqual(arr1, arr2, m, n);
            for (int i = 0; i < res.size(); i++)
                System.out.print (res.get (i) + " ");
            System.out.println();
        }
        
    }
}
// } Driver Code Ends


// Complete the function given below
class Solution
{
    public static ArrayList<Integer> countEleLessThanOrEqual(int arr1[], int arr2[], int m, int n)
    {
       /*
       
       where we get this idea?
       because since everything is concerned about count
       and getting count in O(1) time instead of binary seach
       
       in this approach we create freq array of arr2
       and will do prefix sum array of it (ith banda will have 
       kitne bande hai uske barabar ya usse chote)
       
       and uske help c 
       hum arr1 ko iterate karte hue
       accordingly list mai bas add karte rahenge directlty accesing the values via index
       */
       //farr = frequency array
       
       /*
       optmising farr
       1.setting size of max of arr1 because at the end
       even if arr2 k andar max zyada ho
       bande hume arr1 k hisab c chahiye
       2.farr tabhi update k while iterating arr2 jab wo limit mai ho
       arr2 ka bande andar aa rahe ho farr k
       
       */
       
       
       int max = Integer.MIN_VALUE;
       
       for(int i = 0; i < arr1.length; i++){
           max = (int)Math.max(max,arr1[i]);
       }
       
       int[] farr = new int[max + 1]; //0 based index
       
       for(int i = 0; i < arr2.length; i++){
           if(arr2[i] <= max){
               farr[arr2[i]]++;
           }
       }
       
       for(int i = 1; i <= max; i++){
           farr[i] += farr[i - 1];
       }
       
       ArrayList<Integer> list = new ArrayList<>();
       
       for(int i = 0; i < arr1.length; i++){
          list.add(farr[arr1[i]]);
       }
       
       return list;
    }
}
