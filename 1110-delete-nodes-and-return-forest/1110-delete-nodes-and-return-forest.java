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
    List<TreeNode> ans;
    HashSet<Integer> hs;
    
    public TreeNode helper(TreeNode node){
        if(node == null) return null;
        
        node.left = helper(node.left);
        node.right = helper(node.right);
        
        if(hs.contains(node.val)){
            if(node.left != null) ans.add(node.left);
            if(node.right != null) ans.add(node.right);
            
            return null;
        }else{
            return node;
        }
    }
    
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        ans = new ArrayList<>();
        
        hs = new HashSet<>();
        
        for(int val : to_delete){
            hs.add(val);
        }
        
        
        TreeNode node = helper(root);
        if(node != null) ans.add(node);
        
        return ans;
    }
}