//{ Driver Code Starts
//Initial Template for Java

import java.util.Scanner;
import java.lang.Math;
import java.io.*;
class Node{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}
class GFG2
{
    public static void inorder(Node root)
    {
        if(root==null)
        return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int []post=new int[n];
            for(int i=0;i<n;i++)
            {
                int b=sc.nextInt();
                post[i]=b;
            }
            GFG obj=new GFG();
            Node root=obj.constructTree(post,n);
            inorder(root);
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java
/*class Node{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}*/

// Function should return the root of the bst formed using postorder traversal.
//opp
class GFG
{
    static int idx;
    public static Node bstFromPostorder(int[] postorder,int lr,int rr){
        if(idx < 0 || postorder[idx] < lr || postorder[idx] > rr){
            return null;
        }
        
        
        Node node = new Node(postorder[idx]);
        
        idx--;
        
        node.right = bstFromPostorder(postorder,node.data,rr);
        node.left = bstFromPostorder(postorder,lr, node.data);
        
        return node;
        
    }
    
    public static Node constructTree(int postorder[],int n)
    {
        //Add your code here.
        idx = postorder.length - 1;
        int leftRange = -(int)1e9 - 1;
        int rightRange = (int)1e9 + 1;
        return bstFromPostorder(postorder,leftRange, rightRange);
    }
}