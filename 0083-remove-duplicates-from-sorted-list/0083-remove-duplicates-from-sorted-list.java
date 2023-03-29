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
    //Approach 2, Using Add Last always use add last, add first so that less mistakes
    static ListNode tempHead;
    static ListNode tempTail;
    
    public void addLast(ListNode node){
        if(tempTail == null){
            tempTail = tempHead = node;
        }else{
            tempTail.next = node;
            tempTail = node;
        }
        
    }
    public ListNode deleteDuplicates2(ListNode head) {
        //Base Case, Handle this Always
        if(head == null || head.next == null) return head;
        
        tempHead = new ListNode();
        tempTail = new ListNode();
        
        ListNode itr = head;
        
        
        while(itr != null){
            ListNode fwd = itr.next;
            itr.next = null;
            
            if(tempTail == null || tempTail.val != itr.val){
                addLast(itr);
            }
            
            itr = fwd;
        }
        
        return tempHead;
    }
    
    //Approach one
    public ListNode deleteDuplicates(ListNode head) {
        //Base Case, Handle this Always
        if(head == null || head.next == null) return head;
        
        ListNode dummyNode = new ListNode(101);//out of range value;
        ListNode itr = dummyNode;
        ListNode curr = head;
        ListNode prev = new ListNode();// to remove unwanted nodes from linkedlist
        
        while(curr != null){
            while(curr != null && itr.val == curr.val){ 
                //possible that while loop made curr null, so have to break it
                prev = curr;
                curr = curr.next;
            }
            
            prev.next = null;
            
            //if last part had same elements, make sure to point itr to null
            itr.next = curr;
            itr = curr;
            if(curr != null) curr = curr.next;// only increment curr if it isnt null;
        }
        
        
        return dummyNode.next;
    }
}