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
            frwd = curr.next;
            
            curr.next = prev;
            
            prev = curr;
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
    
    public boolean solution(ListNode head){
        ListNode mid = middle(head);
        ListNode head1 = head;
        ListNode head2 = mid.next;
        
        mid.next = null;
        
        head2 = reverse(head2);
        
        boolean flag = true;
        ListNode c2 = head2;
        ListNode c1 = head1;
        while(c2 != null){
            if(c2.val != c1.val){
                flag = false;
                break;
            }
            
            c1 = c1.next;
            c2 = c2.next;
        }
        
        head2 = reverse(head2);
        mid.next = head2;
        return flag;
    }
    
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        return solution(head);
    }
}