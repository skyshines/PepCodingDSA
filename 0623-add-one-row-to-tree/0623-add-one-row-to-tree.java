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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode ans = new TreeNode(val);
            ans.left = root;
            return ans;
        }
        
        int d = depth - 2;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        
        while(d-- > 0){
            int size = queue.size();
            
            while(size-- > 0){
                TreeNode rem = queue.remove();
                if(rem.left != null) queue.add(rem.left);
                if(rem.right != null) queue.add(rem.right);
            }
        }
        
        while(queue.size() > 0){
            TreeNode rem = queue.remove();
            
            
                TreeNode l = new TreeNode(val);
                l.left = rem.left;
                rem.left = l;
            
            
            
                TreeNode r = new TreeNode(val);
                r.right = rem.right;
                rem.right = r;
            
        }
        
        return root;
    }
}