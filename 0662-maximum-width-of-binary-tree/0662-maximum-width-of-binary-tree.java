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
    class Pair{
        TreeNode node;
        int i;
        
        Pair(TreeNode node,int i){
            this.node = node;
            this.i = i;
        }
    }
    
    
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        int ans = 1;
        queue.add(new Pair(root, 0));
        
        while(queue.size() > 0){
            int size = queue.size();
            int mini = Integer.MAX_VALUE;
            int maxi = Integer.MIN_VALUE;
            
            while(size-- > 0){

                Pair rem = queue.remove();
                
                if(rem.i < mini) mini = rem.i;
                if(rem.i > maxi) maxi = rem.i;
                
                if(rem.node.left != null){
                    queue.add(new Pair(rem.node.left,2 * rem.i + 1));
                }
                
                if(rem.node.right != null){
                    queue.add(new Pair(rem.node.right, 2 * rem.i + 2));
                }
            }
            
            if(maxi - mini + 1 > ans) ans = maxi - mini + 1;
        }
        
        return ans;
    }
}