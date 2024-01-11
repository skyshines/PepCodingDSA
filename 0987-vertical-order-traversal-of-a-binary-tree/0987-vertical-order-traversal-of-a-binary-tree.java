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
    
    public class Pair implements Comparable<Pair>{
        TreeNode node;
        int hl; // horizontal level
        
        Pair(TreeNode node, int hl){
            this.node = node;
            this.hl = hl;
        }
        
        public int compareTo(Pair o){
            if(this.hl != o.hl){
                return this.hl - o.hl;
            }else{
                return this.node.val - o.node.val;
            }
        }
    }
    
    public void maxwidth(TreeNode node,int hl,int[] ans){
        if(node == null) return;
        
        if(hl < ans[0]) ans[0] = hl;
        if(hl > ans[1]) ans[1] = hl;
        
        if(node.left != null) maxwidth(node.left,hl - 1, ans);
        if(node.right != null) maxwidth(node.right,hl + 1, ans);
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        int[] arr = new int[2];
        maxwidth(root,0,arr);
        
        List<List<Integer>> ans = new ArrayList();
        int len = arr[1] - arr[0] + 1;
        
        for(int i = 0; i < len; i++){
            ans.add(new ArrayList<>());
        }
        
        
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        
        queue.add(new Pair(root, -arr[0]));
        
        while(queue.size() > 0){
            int size = queue.size();
            PriorityQueue<Pair> childqueue = new PriorityQueue<>();
            
            while(size-- > 0){
                Pair remove  = queue.remove();
                
                ans.get(remove.hl).add(remove.node.val);
                
                if(remove.node.left != null) childqueue.add(new Pair(remove.node.left, remove.hl - 1));
                if(remove.node.right != null) childqueue.add(new Pair(remove.node.right, remove.hl + 1));
            }
            
            queue = childqueue;
        }
        
        
        return ans;
    }
}