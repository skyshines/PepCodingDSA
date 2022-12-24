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
    static ListNode ptr;
    public boolean solution(ListNode itr){
        if(itr == null){
            return true;
        }
        
        boolean flag = solution(itr.next);
        
        if(flag == true){
            boolean ans = itr.val == ptr.val;
            ptr = ptr.next;
            return ans;
        }else{
            return false;
        }
    }
    public boolean isPalindrome(ListNode head) {
        if(head.next == null) return true;
        ptr = head;
        return solution(head);
    }
}