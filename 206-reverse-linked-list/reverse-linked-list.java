/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 
class Solution {
    public ListNode reverseList(ListNode head) {
        //iteratevly
        ListNode curr=head;
        ListNode prev=null;
        ListNode nxt=null;
        while(curr!=null){
            nxt=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nxt;
        }
        head=prev;
        return head;
        
    }
}
*/
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head==null || head.next==null){
            return head;
        }
         ListNode reversedList = reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return  reversedList;

    }
}
