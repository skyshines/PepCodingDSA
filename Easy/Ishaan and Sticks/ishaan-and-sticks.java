//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    int arr [] = new int[sizeOfArray];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Complete obj = new Complete();
		    ArrayList<Integer> ans;
		    ans = obj.square(arr, sizeOfArray);
		    for(int i: ans)
		        System.out.print(i + " ");
		    System.out.println();
		}
	}
}


// } Driver Code Ends


//User function Template for Java

class Complete{
    
   
    // Function for finding maximum and value pair
    public static ArrayList<Integer> square (int arr[], int N) {
        //Complete the function
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int val : arr) hm.put(val, hm.getOrDefault(val, 0) + 1);
        
        int marea = 0;
        int n = 0;
        
        for(int key : hm.keySet()){
            int freq = hm.get(key);
            int side = key;
            
            if(freq >= 4 && side * side > marea){
                marea = side * side;
                n = freq / 4;
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        if(marea == 0){
            list.add(-1);
        }else{
            list.add(marea);
            list.add(n);
        }
        
        return list;
    }
    
    
}


