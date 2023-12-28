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
    public TreeNode helper(int[] preorder,int presi,int preei, int[] postorder, int posi, int poei){
        if(presi > preei) return null;
        
        TreeNode node = new TreeNode(preorder[presi]);
        
        if(presi == preei) return node;
        
        int idx = posi;
        while(postorder[idx] != preorder[presi + 1]) idx++;
        
        int countOfLeftSubTreeElements = idx - posi + 1;
        
        
        
        node.left = helper(preorder,presi + 1, presi + countOfLeftSubTreeElements,postorder,posi , idx);
        node.right = helper(preorder,presi + countOfLeftSubTreeElements + 1, preei,postorder,idx +1 , poei - 1);
        
        return node;
    }
    
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return helper(preorder, 0, preorder.length - 1, postorder,0, postorder.length - 1);
    }
}