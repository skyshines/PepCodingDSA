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
    static ListNode th; // temp head
    static ListNode tt; // temp tail
    public void addFirstNode(ListNode node){
        if(th == null){
            th = tt = node;
        }else{
            node.next = th;
            th = node;
        }
    }
    public int length(ListNode head){
        int l = 0;
        ListNode temp = head;
        while(temp != null){
            l++; temp = temp.next;
        }
        
        return l;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k < 2) return head; // k = 0 mai kya h reverse karoge, k = 1 mai 1-1 k group mai reverse karne mai koi sense nhi
         int size = length(head);
        ListNode curr = head;
        ListNode fwd = null;
        ListNode oh = null;
        ListNode ot = null;
        while(size >= k){
                th = tt = null;
                int tk = k;
                
                while(tk-- > 0){
                    fwd = curr.next;
                    curr.next = null;
                    addFirstNode(curr);
                    curr = fwd;
                    
                }
                size = size - k;
                
                if(oh == null || ot == null){
                    oh = th;
                    ot = tt;
                }else{
                    ot.next = th;
                    ot = tt;
                }
                
            }
         
        ot.next = curr;
        
         return oh;
    
        }
    
    
        
       
        
    }
