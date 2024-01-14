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
    TreeNode LCA;
    public boolean lowestCommonAncestor_(TreeNode node,TreeNode p,TreeNode q){
        if(node == null) return false;
        
        boolean self = false, left = false, right = false;
        
        if(node.val == p.val || node.val == q.val){
            self = true;
        }
        
        left = lowestCommonAncestor_(node.left,p,q);
        
        if(LCA != null) return true;
        
        right = lowestCommonAncestor_(node.right,p,q);
        
        if(LCA != null) return true;
        
        if(self && left || self && right || left && right){
            if(LCA == null) LCA = node;
        }
        
        return self || left || right;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LCA = null;
        lowestCommonAncestor_(root, p, q);
        return LCA;
    }
}