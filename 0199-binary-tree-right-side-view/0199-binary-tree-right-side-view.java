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
    public List<Integer> rightSideView(TreeNode root) {
      if(root == null) return new ArrayList<>();
      List<Integer> ans = new ArrayList<>();
      LinkedList<TreeNode> queue = new LinkedList<>();
      
      queue.addLast(root);
      
      while(queue.size() != 0){
          int size = queue.size();
          ans.add(queue.getFirst().val);
          
          while(size-- > 0){
              TreeNode node = queue.removeFirst();
              
              if(node.right != null) queue.addLast(node.right);
              if(node.left != null) queue.addLast(node.left);
          }
      }
      
      return ans;
    }
}