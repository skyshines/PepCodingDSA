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
    public TreeNode helper(int[] postorder,int psi,int pei, int[] inorder, int isi, int iei){
        if(isi > iei) return null;
        
        int idx = isi;
        while(inorder[idx] != postorder[pei]) idx++;
        
        int countOfLeftSubTreeElements = idx - isi;
        
        TreeNode node = new TreeNode(postorder[pei]);
        
        node.left = helper(postorder,psi, psi + countOfLeftSubTreeElements - 1,inorder,isi,idx - 1);
        node.right = helper(postorder,psi + countOfLeftSubTreeElements, pei - 1,inorder,idx +1 , iei);
        
        return node;
    }

    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(postorder,0,postorder.length - 1,inorder,0,inorder.length - 1);
    }
}