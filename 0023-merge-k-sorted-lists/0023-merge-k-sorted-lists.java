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
    public ListNode mergeTwoLists(ListNode list1,ListNode list2){
        if(list1 == null || list2 == null) return list1 != null ? list1 : list2;
        
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        ListNode c1 = list1;
        ListNode c2 = list2;
        
        while(c1 != null && c2 != null){
            if(c1.val < c2.val){
                prev.next = c1;
                c1 = c1.next;
            }else{
                prev.next = c2;
                c2 = c2.next;
            }
            
            prev = prev.next;
            
        }
        
        prev.next = c1 != null ? c1 : c2;
        
        return dummy.next;
    }
    
    public ListNode mergeKLists(ListNode[] lists,int si,int ei){
        if(si == ei){
            return lists[si];
        }
        int mid = si + (ei - si) / 2;
        
        ListNode l1 = mergeKLists(lists,si,mid);
        ListNode l2 = mergeKLists(lists,mid + 1,ei);
        
        return mergeTwoLists(l1,l2);
    }
    
    public ListNode mergeKLists1(ListNode[] lists) {
      if(lists.length == 0)return null;
       
       return mergeKLists(lists,0,lists.length - 1); 
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
      if(lists.length == 0) return null;
       
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->{
            return a.val - b.val; // a = this, b = other, this lambda functions
//tell priority queue to do this - other for default behavior which is min PQ
        });
        
        for(ListNode node : lists){
            if(node != null) pq.add(node);
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        
        while(pq.size() > 0){
            ListNode node = pq.remove();
            
            prev.next = node;
            prev = prev.next;
            
            if(node.next != null) pq.add(node.next); 
        }
            
        return dummy.next;    
    }
}