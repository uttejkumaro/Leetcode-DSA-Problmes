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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0) return head;
        int len=1;
        ListNode curr=head;
        while(curr.next!=null){
            len++;
            curr=curr.next;

        }
        curr.next=head;
        k=k%len;
        if(k==0){
            curr.next=null;
            return head;
        }
        int lenNewTail=len-k-1;
        curr=head;
        for(int i=0;i<lenNewTail;i++){
            curr=curr.next;
        }
        ListNode newHead=curr.next;
        curr.next=null;
        return newHead;       

        
    }
}