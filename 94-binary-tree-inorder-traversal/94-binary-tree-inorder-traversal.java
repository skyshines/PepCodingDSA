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
    public TreeNode getRightMost(TreeNode leftNode, TreeNode curr){
        
        while(leftNode.right != null && leftNode.right != curr) leftNode = leftNode.right;
        
        return leftNode;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        
        TreeNode curr = root;
        
        while(curr != null){
            TreeNode leftNode = curr.left;
            
            if(leftNode == null){
                ans.add(curr.val);
                curr = curr.right;
            }else{
                
                TreeNode rightMost = getRightMost(curr.left, curr);
                
                if(rightMost.right == null){
                    //link create
                    rightMost.right = curr;
                    curr = curr.left;
                }else{
                    //link destroy
                    rightMost.right = null;
                    ans.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        
        return ans;
    }
}