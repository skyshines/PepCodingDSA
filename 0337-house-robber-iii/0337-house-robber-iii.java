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
    class housePair{
        int withRobbery = 0;
        int withoutRobbery = 0;
    }
    public housePair rob_(TreeNode node) {
        if(node == null) return new housePair();
        
        housePair left = rob_(node.left);
        housePair right = rob_(node.right);
        
        housePair ans = new housePair();
        
        ans.withRobbery = node.val + left.withoutRobbery + right.withoutRobbery;
        ans.withoutRobbery = Math.max(left.withoutRobbery, left.withRobbery) +                                              Math.max(right.withoutRobbery, right.withRobbery);
        
        return ans;
        
    }
    
    public int rob(TreeNode root) {
        housePair res = rob_(root);
        return Math.max(res.withRobbery, res.withoutRobbery);
    }
}