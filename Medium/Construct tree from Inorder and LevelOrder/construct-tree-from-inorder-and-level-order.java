//{ Driver Code Starts
import java.util.*;

class Node
{
    int data;
    Node left, right;
    
    Node(int item)
    {
        data = item;
        left = right = null;
    }    
        public void setLeft(Node left) 
    {
        this.left = left;
    }
  
    public void setRight(Node right) 
    {
        this.right = right;
    }
        
    
}


class ConstructBT
{
    Node root;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    
	    while(t-- > 0)
	    {
	        int n = sc.nextInt();
	        
	        int inord[] = new int[n];
	        int level[] = new int[n];
	        for(int i = 0; i < n; i++)
	            inord[i] = sc.nextInt();
	            
	        for(int i = 0; i < n; i++)
	             level[i] = sc.nextInt();
	             
	        GfG g = new GfG();
	        Node node =  g.buildTree(inord, level);
	        printPreOrder(node);
	        System.out.println();
	        
	        
	    }
    }
    
   static void printPreOrder(Node node)
   {
       if(node == null)
          return;
          
        System.out.print(node.data + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
   }
}

// } Driver Code Ends


/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/*Complete the function below*/
class GfG
{
    
    
    Node helper(int[] inorder,int isi, int iei,int[] levelOrder){
        if(isi > iei) return null;
        
        Node node = new Node(levelOrder[0]);
        if(levelOrder.length == 1) return node;
        
        int idx = isi;
        
        while(inorder[idx] != levelOrder[0]) idx++;
        
        HashSet<Integer> lste = new HashSet<>();//left subtree elements hasSet
        for(int i = isi; i < idx; i++){
            lste.add(inorder[i]);
        }
        
        int[] levelOrderLeftSubTree = new int[idx - isi];
        int[] levelOrderRightSubTree = new int[iei - idx];
        int ls = 0, rs = 0;
        
        for(int i = 1; i < levelOrder.length; i++){
            if(lste.size() != 0 && lste.contains(levelOrder[i])){
                levelOrderLeftSubTree[ls++] = levelOrder[i];
            }else{
                levelOrderRightSubTree[rs++] = levelOrder[i];
            }
        }
        
        node.left = helper(inorder,isi,idx - 1,levelOrderLeftSubTree);
        node.right = helper(inorder,idx + 1,iei,levelOrderRightSubTree);
        
        return node;
        
    }
    
    
    Node buildTree(int inord[], int level[])
    {
        return helper(inord,0,inord.length - 1,level);
    }
    
   
}


