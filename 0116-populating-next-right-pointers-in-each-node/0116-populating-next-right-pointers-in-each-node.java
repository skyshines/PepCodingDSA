/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while(queue.size() > 0){
            int size = queue.size();
            
            while(size-- > 0){
                Node rem = queue.removeFirst();
                
                if(size >= 1){
                    rem.next = queue.getFirst();
                }
                
                if(rem.left != null)queue.addLast(rem.left);
                if(rem.right != null)queue.addLast(rem.right);
            }
        }
        
        return root;
    }
}