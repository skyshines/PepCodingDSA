//{ Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
        	    Solution g = new Solution();
			
			    ArrayList <Integer> res = g.verticalSum(root);
			    for (Integer num : res) System.out.print (num + " ");
			    System.out.println();
                t--;
            
        }
    }
  
}


// } Driver Code Ends


/*Complete the function below
Node is as follows:
class Node{
int data;
Node left, right;
Node(int item)
{
    data = item;
    left = right = null
}
}
*/
class Solution{
    public void getWidth(Node node,int hl,int[] minmax){
        if(node == null) return;
        
        if(minmax[0] > hl) minmax[0] = hl;
        if(minmax[1] < hl) minmax[1] = hl;
        
        getWidth(node.left, hl - 1, minmax);
        getWidth(node.right, hl + 1, minmax);
    }
    
    public class Pair{
        Node node;
        int hl;
        
        Pair(Node node, int hl){
            this.node = node;
            this.hl = hl;
        }
    }
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> verticalSum(Node root)
    {
        int[] minmax = new int[2];
        getWidth(root, 0, minmax);
        int len = minmax[1] - minmax[0] + 1;
        
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < len; i++) ans.add(0);
        
        LinkedList<Pair> queue = new LinkedList<>();
        
        queue.addLast(new Pair(root, -minmax[0]));
        
        while(queue.size() > 0){
            int size = queue.size();
            
            while(size-- > 0){
                Pair rem = queue.removeFirst();
                
                ans.set(rem.hl, ans.get(rem.hl) + rem.node.data);
                
                if(rem.node.left != null) queue.add(new Pair(rem.node.left, rem.hl - 1));
                if(rem.node.right != null) queue.add(new Pair(rem.node.right, rem.hl + 1));
            }
        }
        
        return ans;
    }
}
