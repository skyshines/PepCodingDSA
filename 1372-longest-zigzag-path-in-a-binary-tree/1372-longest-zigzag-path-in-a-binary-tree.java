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
//OA code
class Solution {
    static int maxLen;
    
    //{forwardSlope, backwardSlope};
    public int[] longestZigZag_(TreeNode node) {
        if(node == null) return new int[]{-1, -1};
        
        int[] left  = longestZigZag_(node.left);
        int[] right = longestZigZag_(node.right);
        
        int[] ans = new int[2];
        
        maxLen = Math.max(maxLen, Math.max(right[0], left[1]) + 1);
        
        ans[0] = left[1] + 1;
        ans[1] = right[0] + 1;
        
        return ans;
    }
    
     public int longestZigZag(TreeNode root) {
         maxLen = 0;
         longestZigZag_(root);
         return maxLen;
    }
}
/*
interview code
more readable, better understandable
class Solution {
    public class Pair{
        int forwardSlope = -1;
        int backwardSlope = -1;
        int maxLen = 0;
    }
    
    public Pair longestZigZag_(TreeNode node) {
        if(node == null) return new Pair();
        
        Pair left  = longestZigZag_(node.left);
        Pair right = longestZigZag_(node.right);
        
        Pair ans = new Pair();
        
        ans.maxLen = Math.max(Math.max(left.maxLen, right.maxLen), Math.max(right.forwardSlope, left.backwardSlope) + 1);
        
        ans.forwardSlope = left.backwardSlope + 1;
        ans.backwardSlope = right.forwardSlope + 1;
        
        return ans;
    }
    
     public int longestZigZag(TreeNode root) {
        return longestZigZag_(root).maxLen;
    }
}


*/