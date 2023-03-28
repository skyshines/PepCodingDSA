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
class Solution {
    static int count;
    
    public int helper(TreeNode node){
        if(node == null) return 1;
        
        int leftchild = helper(node.left);
        int rightchild = helper(node.right);
        
        if(leftchild == -1 || rightchild == -1){
            count++;
            return 0;
        }else if(leftchild == 1 && rightchild == 1){
            return -1;
        }else{
            return 1;
        }
    }
    
    public int minCameraCover(TreeNode root) {
        count = 0;
        if(helper(root) == -1) count++;
        
        return count;
    }
}