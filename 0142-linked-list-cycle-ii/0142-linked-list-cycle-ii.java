/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    
    public ListNode getMeetingPoint(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast) return fast;
        }
        
        return null;
    }
    
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        
        ListNode meetingPoint = getMeetingPoint(head);
        
        if(meetingPoint == null) return null;
        
        ListNode fast = meetingPoint;
        ListNode slow = head;
        
        while(fast != slow){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}