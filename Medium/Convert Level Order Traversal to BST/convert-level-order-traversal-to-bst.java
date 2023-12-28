//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
        left = right = null;
    }
}

public class Main {
    
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            GFG obj = new GFG();
            Node tree = obj.constructBST(arr);
            preorder(tree);
            System.out.println();
        }
	}
	
	 public static void preorder(Node root){
        if(root == null){
            return;
        }
        
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
}


// } Driver Code Ends


//User function Template for Java


class GFG 
{
    //Function to construct the BST from its given level order traversal.
    
    class Pair{
        Node parent;
        int leftRange;
        int rightRange;
        
        Pair(Node parent,int leftRange,int rightRange){
            this.parent = parent;
            this.leftRange = leftRange;
            this.rightRange = rightRange;
        }
    }
    
    public Node constructBST(int[] arr)
    {
        //Write your code here
        LinkedList<Pair> queue = new LinkedList<>();
        
        //dummy node
        Pair p = new Pair(null, -(int)1e9 - 1, (int)1e9 + 1);
        
        int idx = 0;
        
        queue.addLast(p);
        Node root = null;
        
        while(queue.size() > 0 && idx < arr.length){
            Pair rem = queue.removeFirst();
            
            if(arr[idx] > rem.leftRange && arr[idx] < rem.rightRange){
                
                Node child = new Node(arr[idx]);
                
                if(root == null){
                    root = child;
                    
                    queue.addLast(new Pair(child,rem.leftRange,arr[idx])); //left shell
                    queue.addLast(new Pair(child,arr[idx],rem.rightRange)); //right shell
                    
                    idx++;
                    continue;
                } 
                
                if(arr[idx] > rem.parent.data){
                    rem.parent.right = child;
                    
                    queue.addLast(new Pair(child,rem.parent.data,arr[idx])); //left shell
                    queue.addLast(new Pair(child,arr[idx],rem.rightRange)); //right shell
                }else{
                    rem.parent.left = child;
                    
                    queue.addLast(new Pair(child,rem.leftRange,arr[idx])); //left shell
                    queue.addLast(new Pair(child,arr[idx],rem.parent.data)); //right shell
                }
                
                idx++;
            }
        }
        
        return root;
    }
}