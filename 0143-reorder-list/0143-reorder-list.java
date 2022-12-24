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
     public ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        
        ListNode curr = head;
        ListNode prev = null;
        ListNode frwd = null;
        
        while(curr != null){
            frwd = curr.next; // backup
            
            curr.next = prev; // changing pointers
            
            prev = curr; // moving pointers to next stage
            curr = frwd;
        }
        
        return prev;
    }
    
    public ListNode middle(ListNode head){ // returns middle node of linked list
        if(head == null || head.next == null) return head;
        
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //for even, first node 
        return slow;
    }
    
    public ListNode reorderLinkList(ListNode head) {
        ListNode mid = middle(head);
        ListNode head2 = mid.next;
        mid.next = null;
        head2 = reverse(head2);
        
        ListNode c1 = head;
        ListNode c2 = head2;
        ListNode f1 = null;
        ListNode f2 = null;
        
        while(c2 != null){
           f1 = c1.next;
           f2 = c2.next; // backup;
            
           c1.next = c2; // changing pointers
           c2.next = f1;
            
           c1 = f1;
           c2 = f2; 
        }
        
        return head;
    }
    
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            
        }else{
            reorderLinkList(head);
        }
    }    
}