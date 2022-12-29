/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        
        Node c1 = head;
        Node dummynode = new Node(-1);
        Node prev = dummynode;
        
        HashMap<Node,Node> map = new HashMap<>();
        
        while(c1 != null){
            Node node = new Node(c1.val);
            prev.next = node;
            
            map.put(c1,node);
            
            c1 = c1.next;
            prev = prev.next;
        }
        
        Node head2 = dummynode.next;
        c1 = head;
        Node c2 = head2;
        
        while(c1 != null){
            c2.random = c1.random != null ? map.get(c1.random) : null;
            
            c1 = c1.next;
            c2 = c2.next;
        }
        
        return head2;
    }
}