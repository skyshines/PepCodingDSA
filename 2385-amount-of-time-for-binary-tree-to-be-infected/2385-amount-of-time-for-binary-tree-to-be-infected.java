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
    int time;
    
    public void burnTree(TreeNode node,TreeNode blockNode,int t){
        if(node == null || node == blockNode) return;
        
        if(t > time) time = t;
        
        burnTree(node.left,blockNode,t + 1);
        burnTree(node.right,blockNode,t + 1);
    }
    
    public int burningTree(TreeNode node,int fireNode){
        if(node == null) return -1;
        
        if(node.val == fireNode){
            burnTree(node,null,0);
            return 1;
        }
        
        int leftDistance = burningTree(node.left,fireNode);
        
        if(leftDistance > 0){
            burnTree(node,node.left,leftDistance);
            return leftDistance + 1;
        }
        
        int rightDistance = burningTree(node.right,fireNode);
        
        if(rightDistance > 0){
            burnTree(node, node.right,rightDistance);
            return  rightDistance + 1;
        }
        
        return -1;
    }
    public int amountOfTime(TreeNode root, int start) {
        time = 0;
        burningTree(root,start);
        
        return time;
    }
}