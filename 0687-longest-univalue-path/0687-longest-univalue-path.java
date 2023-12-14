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
    public int[] helper(TreeNode node){
        if(node == null) return new int[]{0,0};
        
        int[] left = helper(node.left);
        int[] right= helper(node.right);
        
        int omax1 = 0;
        int nmax1 = 0;
        
        int omax2 = 0;
        int nmax2 = 0;
        
        int omax3 = 0;
        int nmax3 = 0;
        
        
            
        if(node.left != null){
            if(node.val == node.left.val){
                omax1 = Math.max(left[0], left[1] + 1);
                nmax1 = left[1] + 1;
            }else{
                omax1 = Math.max(left[0], left[1]);
            }
        }    
        if(node.right != null){
            if(node.val == node.right.val){
                omax2 = Math.max(right[0], right[1] + 1);
                nmax2 = right[1] + 1;
            }else{
                omax2 = Math.max(right[0], right[1]);
            }
        }
        
        int[] arr = new int[2];
        arr[0] = Math.max(omax1, omax2);
        arr[1] = Math.max(nmax1, nmax2);
            
        if(node.left != null && node.right != null && node.left.val == node.val && node.right.val == node.val){
            arr[0] = Math.max(arr[0], right[1] + left[1] + 2);
        }
                
        
        return arr;
        
    }
            
            
    public int longestUnivaluePath(TreeNode root) {
        int[] ans = helper(root);
        return Math.max(ans[0], ans[1]);
    }
}