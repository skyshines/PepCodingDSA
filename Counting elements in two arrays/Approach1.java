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
    public static int binarySearch(int[] arr,int target){
        if(target < arr[0]){
            return 0;
        }
        
        if(target >= arr[arr.length - 1]){
            return arr.length;
        }
        
        int lo = 0;
        int hi = arr.length - 1;
        
        int idx = 0;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            
            if(arr[mid] > target){
                hi = mid - 1;
                idx = mid;
            }else{
                lo = mid + 1;
            }
        }
        
        /*
        
        instead of searching for greater element in sorted arr2
        have a counter initialised to zero
        simple lo and hi rakho mid ko dekho
        if mid <= target
        lo c leakr mid tak bande chote ya barabar honge target k
        so add mid - lo + 1 to the count;
        and lo = mid + 1;
        otherwose
        hi = mid - 1
        
        by using this edge cases lik eabove written if conditions will be avoided
        */
        
        return idx;
    }
    public static ArrayList<Integer> countEleLessThanOrEqual(int arr1[], int arr2[], int m, int n)
    {
       Arrays.sort(arr2);
       ArrayList<Integer> list = new ArrayList<>();
       for(int i = 0; i < arr1.length; i++){
           list.add(binarySearch(arr2,arr1[i]));
       }
       
       return list;
    }
}
/*
time complexity O(mlog(m) sorting the second array + nlog(m) linear traversal in arr1 and binary search arr2) == o((m + n)log(m))

1.Dosre array ka order matter nhi karta
isliye arram c sort kar diya
2.using binaryb search i found k required target c bada banda kha par hai
jab tak bada banda milta rha maine search continue rakhi
bade bande k left idex c lekar zero tak sabhi bandi ya to target k
barabar ya chote honge
so we simply added idx of our element
3.we can also directly saved our result in arr1 hence no extra auxillary space will be used

*/
