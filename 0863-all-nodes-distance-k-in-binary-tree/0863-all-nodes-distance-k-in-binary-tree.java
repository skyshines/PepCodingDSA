/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void Kdown(TreeNode node,int k,TreeNode block,List<Integer> ans){
        if(node == null || k < 0 ||block == node){
            return;
        }
        
        if(k == 0){
            ans.add(node.val);
            return;
        } 
        
        Kdown(node.left,k - 1, block, ans);
        Kdown(node.right,k - 1, block, ans);
    }
    
    public int distanceK(TreeNode node,int data,int k,List<Integer> ans){
        if(node == null) return -1;
        
        if(node.val == data){
            Kdown(node,k - 0,null,ans);
            return 1; // return values depicts the distance in terms of how much eedges, is a child away from its parent
        }
        
        int left = distanceK(node.left,data,k,ans);
        
        if(left > 0){
            Kdown(node,k - left,node.left,ans);
            return left + 1;
        }
        
        int right = distanceK(node.right,data,k,ans);
        
        if(right > 0){
            Kdown(node, k - right,node.right,ans);
            return right + 1;
        }
        
        return -1;
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        distanceK(root,target.val,k,ans);
        return ans;
    }
}