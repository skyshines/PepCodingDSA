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
    public TreeNode helper(int[] preorder,int psi,int pei, int[] inorder, int isi, int iei){
        if(isi > iei) return null;
        
        int idx = isi;
        while(inorder[idx] != preorder[psi]) idx++;
        
        int countOfLeftSubTreeElements = idx - isi;
        
        TreeNode node = new TreeNode(preorder[psi]);
        
        node.left = helper(preorder,psi + 1, psi + countOfLeftSubTreeElements,inorder,isi,idx - 1);
        node.right = helper(preorder,psi + countOfLeftSubTreeElements + 1, pei,inorder,idx +1 , iei);
        
        return node;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder,0,preorder.length - 1,inorder,0,inorder.length - 1);
    }
}