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
        if(node == null || block == node){
            return;
        }
        
        if(k == 0){
            ans.add(node.val);
            return;
        } 
        
        Kdown(node.left,k - 1, block, ans);
        Kdown(node.right,k - 1, block, ans);
    }
    
    public ArrayList<TreeNode> nodeToRootPath(TreeNode node,int data){
        if(node == null) return null;
        
        if(node.val == data){
            ArrayList<TreeNode> list = new ArrayList<>();
            list.add(node);
            return list;
        }
        
        ArrayList<TreeNode> left = nodeToRootPath(node.left, data);
        if(left != null){
            left.add(node);
            return left;
        }
        
        ArrayList<TreeNode> right = nodeToRootPath(node.right, data);
        if(right != null){
            right.add(node);
            return right;
        }
        
        return null;
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ArrayList<TreeNode> ntr = nodeToRootPath(root, target.val);
        
        List<Integer> ans = new ArrayList<>();
        
        for(int i = 0; i < ntr.size() && k >= 0; i++){
            Kdown(ntr.get(i),k--,i == 0 ? null : ntr.get(i - 1), ans);
        }
        
        return ans;
    }
}