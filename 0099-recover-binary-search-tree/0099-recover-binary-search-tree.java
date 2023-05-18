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
    public void recoverTree(TreeNode root) {
        TreeNode curr = root;
        TreeNode a = null;
        TreeNode b = null;
        TreeNode prev = null;
        
        while(curr != null){
            TreeNode leftNode = curr.left;
            
            if(leftNode == null){
                if(prev != null && prev.val > curr.val){
                    if(a == null) a = prev;
                    b = curr;
                }
                prev = curr;
                curr = curr.right;
            }else{
                TreeNode rightMostNode = getRightMostNode(leftNode, curr);
                
                if(rightMostNode.right == null){
                    rightMostNode.right = curr;
                    curr = curr.left;
                }else{
                    rightMostNode.right = null;
                    
                    if(prev != null & prev.val > curr.val){
                        if(a == null) a = prev;
                        b = curr;
                    }
                    prev = curr;
                    curr = curr.right;
                }
            }
        }
        
        
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }
}