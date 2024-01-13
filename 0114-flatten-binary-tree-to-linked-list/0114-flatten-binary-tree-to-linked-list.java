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
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        
        while(curr != null){
            TreeNode leftNode = curr.left;
            
            if(leftNode == null){
                curr = curr.right;
            }else{
                TreeNode rightMostNode = curr.left;
                
                while(rightMostNode.right != null) rightMostNode = rightMostNode.right;
                
                rightMostNode.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
                curr = curr.right;
            }
        }
    }
}