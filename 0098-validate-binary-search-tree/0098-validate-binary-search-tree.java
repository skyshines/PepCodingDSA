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
    public TreeNode getRightMostNode(TreeNode leftNode, TreeNode curr){
        
        while(leftNode.right != null && leftNode.right != curr){
            leftNode = leftNode.right;
        }
        
        return leftNode;
    }
    public boolean isValidBST(TreeNode root) {
        TreeNode curr = root;
        TreeNode prev = null;
        
        while(curr != null){
            TreeNode leftNode = curr.left;
            
            if(leftNode == null){
                if(prev !=  null && prev.val >= curr.val) return false;
                prev = curr;
                curr = curr.right;
            }else{
                TreeNode rightMostNode = getRightMostNode(leftNode, curr);
                
                if(rightMostNode.right == null){
                    rightMostNode.right = curr;
                    curr = curr.left;
                }else{
                    rightMostNode.right = null;
                    if(prev !=  null && prev.val >= curr.val) return false;
                    prev = curr;
                    curr = curr.right;
                }
            }
        }
        
        return true;
    }
}