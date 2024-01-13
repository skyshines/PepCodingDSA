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
    public void pathSum_(TreeNode node,int targetSum,List<List<Integer>> ans,List<Integer> sumSoFar){
        if(node == null) return;
        
        if(node.left == null && node.right == null && targetSum == node.val){
            sumSoFar.add(node.val);
            ans.add(new ArrayList<>(sumSoFar));
            sumSoFar.remove(sumSoFar.size() - 1);
            return;
        }
        
        sumSoFar.add(node.val);
        pathSum_(node.left, targetSum - node.val,ans,sumSoFar);
        pathSum_(node.right,targetSum - node.val,ans,sumSoFar);
        sumSoFar.remove(sumSoFar.size() - 1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList();
        List<Integer> sum = new ArrayList<>();
        
        pathSum_(root,targetSum,ans,sum);
        
        return ans;
    }
}