//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String findOrder(String [] dict, int N, int K)
    {
        
        //Making graph
        HashMap<Character, HashSet<Character>> graph = new HashMap<>();
        //indegree array
        HashMap<Character, Integer> indegree = new HashMap<>();
        
        //initialise indegree array for every character
        
        for(String str : dict){
            for(char ch : str.toCharArray()){
                indegree.put(ch, 0);
            }
        }
        
        int countOfCharacters = indegree.size();
        
        for(int i = 0; i < dict.length - 1; i++){
            String curr = dict[i];
            String next = dict[i + 1];
            boolean mismatchFound = false;
            
            int len = Math.min(curr.length(), next.length());
            
            for(int j = 0; j < len; j++){
                char ch1 = curr.charAt(j);
                char ch2 = next.charAt(j);
                
                if(ch1 != ch2){
                    if(graph.containsKey(ch1) == true){
                        if(graph.get(ch1).contains(ch2) == false){
                            graph.get(ch1).add(ch2);
                            indegree.put(ch2, indegree.get(ch2) + 1);
                        }
                    }else{
                        HashSet<Character> hs = new HashSet<>();
                        hs.add(ch2);
                        indegree.put(ch2, indegree.get(ch2) + 1);
                        graph.put(ch1, hs);
                    }
                    mismatchFound = true;
                    break;
                }
                
                
            }
            
            if(mismatchFound == false && curr.length() > next.length()){
                    return "";
            }
        }
        
        LinkedList<Character> queue = new LinkedList<>();
        
        for(char key : indegree.keySet()){
            if(indegree.get(key) == 0){
                queue.addLast(key);
            }
        }
        
        int countOfRemovedElements = 0;
        StringBuilder sb = new StringBuilder();
        
        while(queue.size() > 0){
            char rem = queue.removeFirst();
            sb.append(rem);
            
            countOfRemovedElements++;
            
            if(graph.containsKey(rem) == false){
                continue;
            }
            
            for(char nbr : graph.get(rem)){
                indegree.put(nbr, indegree.get(nbr) - 1);
                
                if(indegree.get(nbr) == 0){
                    queue.addLast(nbr);
                }
            }
        }
        
        if(countOfCharacters == countOfRemovedElements){
            return sb.toString();
        }else{
            return "";
        }
        
    }
}