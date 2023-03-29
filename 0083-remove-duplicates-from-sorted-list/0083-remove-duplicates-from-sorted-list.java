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
    //
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyNode = new ListNode(101);//out of range value;
        ListNode itr = dummyNode;
        ListNode curr = head;
        
        while(curr != null){
            while(curr != null && itr.val == curr.val){
                curr = curr.next;
            }
            
            itr.next = curr;
            itr = curr;
            if(curr != null) curr = curr.next;
        }
        
        
        return dummyNode.next;
    }
}