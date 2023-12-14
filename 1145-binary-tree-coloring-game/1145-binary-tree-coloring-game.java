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
    public TreeNode findNode(TreeNode node, int x){
        if(node == null) return null;
        
        if(node.val == x){
            return node;
        }
        
        TreeNode leftFind = findNode(node.left, x);
        
        if(leftFind != null){
            return leftFind;
        }
        
        return findNode(node.right, x);
    }
    
    public int countOfNodes(TreeNode node){
        if(node == null) return 0;
        
        return countOfNodes(node.left) + countOfNodes(node.right) + 1;
    }
    
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        TreeNode red = findNode(root, x);
        
        int clst = countOfNodes(red.left);
        int crst = countOfNodes(red.right);
        int cpst = n - clst - crst - 1;
        
        int max = clst;
        int tree = 0;
        
        if(max < crst){
            max = crst;
            tree = 1;
        }
        
        if(max < cpst){
            max = cpst;
            tree = 2;
        }
        
        if(tree == 0){
            return clst > cpst + crst;
        }else if(tree == 1){
            return crst > clst + cpst;
        }else{
            return cpst > clst + crst;
        }
    }
}