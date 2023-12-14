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
    public boolean isEvenOddTree(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        int level = 0;
        
        while(queue.size() > 0){
            int size = queue.size();
            
            if((level & 1) == 0){
                int max = Integer.MIN_VALUE;
                
                while(size-- > 0){
                    TreeNode rem = queue.removeFirst();
                    
                    if(rem.val > max && rem.val % 2 == 1){
                        max = rem.val;
                    }else{
                        return false;
                    }
                    
                    if(rem.left != null) queue.addLast(rem.left);
                    if(rem.right != null) queue.addLast(rem.right);
                    
                }
            }else{
                int min = Integer.MAX_VALUE;
                
                while(size-- > 0){
                    TreeNode rem = queue.removeFirst();
                    
                    if(rem.val < min && rem.val % 2 == 0){
                        min = rem.val;
                    }else{
                        return false;
                    }
                    
                    if(rem.left != null) queue.addLast(rem.left);
                    if(rem.right != null) queue.addLast(rem.right);
                    
                }
            }
            
            level++;
            
        }
        
        return true;
        
    }
}