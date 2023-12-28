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
    int idx;
    
    public TreeNode bstFromPreorder(int[] preorder,int lr,int rr){
        if(idx >= preorder.length){
            return null;
        }
        
        if(preorder[idx] > lr && preorder[idx] < rr){
            TreeNode node = new TreeNode(preorder[idx]);
            
            idx++;
            node.left = bstFromPreorder(preorder,lr, node.val);
            node.right = bstFromPreorder(preorder,node.val,rr);
            
            return node;
        }else{
            return null;
        }
    }
    
    public TreeNode bstFromPreorder(int[] preorder) {
        idx = 0;
        int leftRange = -(int)1e9 - 1;
        int rightRange = (int)1e9 + 1;
        return bstFromPreorder(preorder,leftRange, rightRange);
    }
}