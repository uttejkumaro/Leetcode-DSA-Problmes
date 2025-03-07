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
//     public ListNode mergeKLists(ListNode[] lists) {
//         if(lists==null) return null;
//         PriorityQueue<ListNode>pq=new PriorityQueue<>((a,b)->(a.val-b.val));
//         for(ListNode list:lists){
//             if(list!=null){
//                 pq.add(list);
//             }
//         }

//         ListNode dummy=new ListNode();
//         ListNode curr=dummy;
//             while(!pq.isEmpty()){
//                ListNode smallest =pq.poll();
//                curr.next=smallest;
//                curr=curr.next;
//               if(smallest.next!=null){
//                 pq.add(smallest.next);
//               }


//             }
//             return dummy.next;       
        
//     }
// }
class Solution {
    ListNode merge(ListNode list1,ListNode list2){
        if(list1==null) return list2;
        if(list2==null) return list1;
        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;
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
        if(head1!=null){
           curr.next=head1;
        }
        if(head2!=null){
           curr.next=head2;
        }
        return dummy.next;

    }
    public ListNode mergeKLists(ListNode[] lists) {
     ListNode res=null;
     for(int i=0;i<lists.length;i++){
        res=merge(res,lists[i]);
     }
     return res;
        
    }
}