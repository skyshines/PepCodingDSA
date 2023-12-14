/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode findNode(TreeNode node1, TreeNode node2,TreeNode target){
        if(node1 == null) return null;
        
        if(node1 == target){
            return node2;
        }
        
        TreeNode leftFind = findNode(node1.left,node2.left ,target);
        
        if(leftFind != null){
            return leftFind;
        }
        
        return findNode(node1.right, node2.right,target);
    }
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return findNode(original,cloned,target);
    }
}