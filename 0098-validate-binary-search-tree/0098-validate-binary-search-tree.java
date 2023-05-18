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
    static TreeNode prev;
    
    public boolean rec(TreeNode node){
        if(node == null){
            return true;
        }
        
        if(rec(node.left) == false) return false;
        
        if(prev != null && prev.val >= node.val){
            return false;
        }
        
        prev = node;
        
        if(rec(node.right) == false) return false;
        
        return true;
    }
    public boolean isValidBST(TreeNode root) {
        prev = null;
        return rec(root);
    }
}