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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0) return null;
        PriorityQueue<ListNode>pq=new PriorityQueue<>((a,b)->a.val-b.val);//min heap
        for(ListNode list:lists){
            if(list!=null){
            pq.add(list);
            }
        }
        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;
        while(!pq.isEmpty()){
            ListNode smallest=pq.poll();
            curr.next=smallest;
            curr=curr.next;
           if(smallest.next!=null){
                pq.add(smallest.next);
            }
        }
        return dummy.next;
     
        
        
    }
}