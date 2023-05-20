/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public int getSize(ListNode head){
        int size = 0;
        
        while(head != null){
            size++;
            head = head.next;
        }
        
        return size;
    }
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int delta = (getSize(headA) - getSize(headB));
        
        if(delta >= 0){
            for(int i = 0; i < delta; i++){
                headA = headA.next;
            }
        }else{
            for(int i = 0; i < -delta; i++){
                headB = headB.next;
            }
        }
        
        
        while(headA != null && headB != null){
            if(headA == headB) return headA;
            
            headA = headA.next;
            headB = headB.next;
        }
        
        return null;
    }
}