/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    TreeNode curr;

    public BSTIterator(TreeNode root) {
        curr = root;
        iterate();
    }
    
    public TreeNode getRightMost(TreeNode node,TreeNode curr){
        while(node.right != null && node.right != curr){
            node = node.right;
        }
        
        return node;
    }
    
    public void iterate(){
        while(curr != null){
            TreeNode leftNode = curr.left;
            
            if(leftNode == null){
                break;
            }else{
                
                TreeNode rightMost = getRightMost(curr.left, curr);
                
                if(rightMost.right == null){
                    //link create
                    rightMost.right = curr;
                    curr = curr.left;
                }else{
                    //link destroy
                    rightMost.right = null;
                    break;
                }
            }
        }
    }
    
    public int next() {
        TreeNode node = curr;
        curr = curr.right;
        iterate();
        return node.val;
    }
    
    public boolean hasNext() {
        return curr != null;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */