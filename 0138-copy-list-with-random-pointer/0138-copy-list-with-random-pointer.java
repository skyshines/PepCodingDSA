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
    public void copyList(Node head){
        Node curr = head;
        Node fwd = null;
        
        while(curr != null){
            fwd = curr.next; //backup
            
            Node node = new Node(curr.val);
            node.next = fwd;
            curr.next = node;
            curr = fwd;
        }
    }
    
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        
        //inserting new List in between the old given list
        copyList(head);
        
        Node curr = head;
        
        while(curr != null){
            Node node = curr.next; // copy list node
            
            Node random = curr.random; // original node ka random
            
            node.random = (random != null) ? random.next : null; // random ka next will have random of copy list, because every node of original list has thier copy node just nexrt to them;
            
            curr = curr.next.next;
        }
        
        Node dummynode = new Node(-1);
        Node prev = dummynode;
        curr = head;
        
        while(curr != null){
            prev.next = curr.next;
            curr.next = curr.next.next;
            
            curr = curr.next;
            prev = prev.next;
        }
        return dummynode.next;
    }
}
/*
//using hashmap linear time linear space
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

*/