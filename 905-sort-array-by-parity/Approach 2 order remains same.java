//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().segregateEvenOdd(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java


//here the order of elements is preserved

class Solution {
    void segregateEvenOdd(int arr[], int n) {
        int i = 0; int j = 0;
        //i is first unsolved
        //j is first odd
        
        //array is divided into three parts
        //0 to j - 1 --> even part
        //j to i - 1 --> odd part
        //i to end --> unsolved part
        
        while(i < arr.length){
            if(arr[i] % 2 == 0){
                //swap i , j and increment i and j
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;//shifting odd segment forward
                j++;//incrementing size of even by 1
            }else{
                i++;//incrementing odd segment by 1 and decreasing unsolved segment by 1;
            }
        }
        
    //for dry run if dono initially even ko bhi point kar rahe the(i,j)
    //swap honge (ek elemnt khud c he)and dono increment honge
       
    }
}
