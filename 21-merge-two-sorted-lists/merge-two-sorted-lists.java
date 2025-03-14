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
// class Solution {
//     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//         //base cases
//         if (list1==null){
//             return list2;
//         };
//         if (list2==null){
//             return list1;
//         };
//         if(list1.val<list2.val){
//             list1.next=mergeTwoLists(list1.next,list2);
//             return list1;
//         } else {
//             // list2's current node is smaller or equal, it should be in the merged list
//             list2.next = mergeTwoLists(list1, list2.next);
//             return list2;
//         }        
//     }
// }
// class Solution {
//     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//         PriorityQueue<ListNode>pq=new PriorityQueue<>();
//          if (list1==null){
//             return list2;
//         };
//         if (list2==null){
//             return list1;
//         };
//         pq.add(list1);
//         pq.add(list2);
//         while(list1.next!=null){
//             pq.add(list1.next);
//         }
//          while(list2.next!=null){
//             pq.add(list2.next);
//         }
//         ListNode dummy=new ListNode(0);
//         ListNode curr=dummy;
//         while(!pq.isEmpty()){
//             curr.next=pq.poll();
//         }
//         return dummy.next;
//     }
// }
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;
        //base cases
        if (list1==null){
            return list2;
        };
        if (list2==null){
            return list1;
        };
        ListNode head1=list1;
        ListNode head2=list2;
        while(head1!=null && head2!=null){
            if(head1.val<head2.val){
                curr.next=head1;
                head1=head1.next;
            }
            else{
                curr.next=head2;
                head2=head2.next;
            }
            curr=curr.next;
        }
      if(head1!=null) curr.next=head1;
        if(head2!=null) curr.next=head2;
        return dummy.next;
    }
}