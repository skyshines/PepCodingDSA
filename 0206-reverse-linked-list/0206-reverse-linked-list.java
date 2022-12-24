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