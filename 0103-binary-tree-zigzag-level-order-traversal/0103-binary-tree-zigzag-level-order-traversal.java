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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ls = new ArrayList<List<Integer>>();
        
        if(root == null) return ls;
        
        Stack<TreeNode> ps = new Stack<>();
        Stack<TreeNode> cs = new Stack<>();
        
        ps.push(root);
        
        int lev = 0;
        
        while(ps.size() > 0){
            List<Integer> ans = new ArrayList<>();
            
            while(ps.size() > 0){
                TreeNode temp = ps.pop();
                ans.add(temp.val);
                
                if(lev % 2 == 0){
                    if(temp.left != null) cs.push(temp.left);
                    if(temp.right != null) cs.push(temp.right);
                }else{
                    if(temp.right != null) cs.push(temp.right);
                    if(temp.left != null) cs.push(temp.left);
                }
            }
            lev++;
            ps = cs;
            cs = new Stack<>();
            
            ls.add(ans);
        }
        
        return ls;
    }
}