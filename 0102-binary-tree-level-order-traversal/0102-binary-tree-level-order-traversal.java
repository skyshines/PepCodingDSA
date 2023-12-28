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
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList();
        
        if(root == null) return ans;
        
        queue.addLast(root);
        
        while(queue.size() > 0){
            int size = queue.size();
            List<Integer> lev = new ArrayList<>();
            
            while(size-- > 0){
                TreeNode node = queue.removeFirst();
                lev.add(node.val);
                
                if(node.left != null) queue.addLast(node.left);
                if(node.right != null) queue.addLast(node.right);
            }
            ans.add(lev);
        }
        
        return ans;
    }
}