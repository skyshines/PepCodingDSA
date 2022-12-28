/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    static ListNode th;
    static ListNode tt;; //temp head and temp tail
    
    public void addFirst(ListNode node){
        if(th == null){
            th = tt = node;
        }else{
            node.next = th;
            th = node;
        }
    }
    
    
    
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        tt = th = null;
        ListNode curr = head;
        ListNode fwd = null;
        
        while(curr != null){
            fwd = curr.next;
            curr.next = null;
            addFirst(curr);
            curr = fwd;
        }
        
        return th;
    }
}

/*
class Solution {
    public ListNode iterativesolution(ListNode head){
        if(head == null || head.next == null) return head;
        
        ListNode currentNode = head;
        ListNode previousNode = null;
        ListNode forwardNode = null;
        
        while(currentNode != null){
            forwardNode = currentNode.next;
            
            currentNode.next = previousNode;
            
            
            previousNode = currentNode;
            currentNode = forwardNode;
        }
        
        head = previousNode;
        return previousNode;
    }
    
    public ListNode reverseList(ListNode head) {
        return iterativesolution(head);
    }
}


*/