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
class CBTInserter {
    TreeNode root;
    LinkedList<TreeNode> queue;
    
    public CBTInserter(TreeNode root) {
        this.root = root;
        queue = new LinkedList<>();
        queue.add(root);
        
        while(true){
            TreeNode node = queue.getFirst();
            
            if(node.left == null){
                break;
            }else if(node.right == null){
                queue.addLast(node.left);
                break;
            }else{
                queue.addLast(node.left);
                queue.addLast(node.right);
                queue.removeFirst();
            }
        }
    }
    
    public int insert(int val) {
        TreeNode rem = queue.getFirst();
        TreeNode node = new TreeNode(val);
        
        if(rem.left == null){
            rem.left = node;
        }else{
            rem.right = node;
            queue.removeFirst();
        }
        
        queue.addLast(node);
        return rem.val;
    }
    
    public TreeNode get_root() {
        return root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */