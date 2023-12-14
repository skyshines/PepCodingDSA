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
        if(root == null || root.left == null) return root;
        
        root.left.next = root.right;
        Node node = root.left;
        
        while(node != null && node.left != null){
            Node temp = node.left;
            
            while(node != null){
                node.left.next = node.right;
            
                if(node.next != null){
                    node.right.next = node.next.left;
                }else{
                    break;
                }
                
                node = node.next;
            }
            
            node = temp;
        }
        
        return root;
    }
}