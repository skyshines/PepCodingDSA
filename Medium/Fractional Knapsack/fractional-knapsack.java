//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class GfG {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Item(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            System.out.println(String.format("%.2f", new Solution().fractionalKnapsack(w, arr, n)));
        }
    }
}
// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        //array sorted decreasing order based on ratio
       Arrays.sort(arr, (a, b) -> {
           double ra = (a.value * 1.0)/ a.weight;
           double rb = (b.value * 1.0)/ b.weight;
           if(ra > rb){
               return -1;
           }else if(ra < rb){
               return 1;
           }else{
               return 0;
           }
       });
       
       
       
       double rbagc = W;
       double bagv = 0;
       
       int i = 0;
       
       while(rbagc > 0 && i < arr.length){
           if(arr[i].weight > rbagc){
               double ratio = (arr[i].value * 1.0 )/ arr[i].weight;
               bagv += ratio * rbagc;
               break;
           }else{
               bagv += arr[i].value;
               rbagc -= arr[i].weight;
           }
           
           i++;
       }
       
       return bagv;
        
    }
    
}