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
    public ListNode sortList(ListNode head) {
        List<Integer>res=new ArrayList<>();
        ListNode curr=head;
        if(head==null) return null;
        while(curr!=null){
            res.add(curr.val);
            curr=curr.next;
        }
        Collections.sort(res);
        ListNode dummy=new ListNode(0);
        ListNode newHead=dummy;
        for(int i=0;i<res.size();i++){
            newHead.next=new ListNode(res.get(i) );
            newHead=newHead.next;
        }
        return dummy.next;

       
        
    }
}