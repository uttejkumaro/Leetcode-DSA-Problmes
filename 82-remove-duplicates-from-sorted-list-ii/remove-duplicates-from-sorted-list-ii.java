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
//     public ListNode deleteDuplicates(ListNode head) {
    //    ListNode curr=head;
    //    while(curr!=null && curr.next!=null){
    //         if(curr.val==curr.next.val){
    //             curr.next=curr.next.next;
    //         }
    //         else{
    //             curr=curr.next;
    //         }
    //    }
    //    return head;
    // }
//     }
// }
    class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        
        while (curr != null) {           
            while (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
            }            
            // If prev.next == curr, no duplicates detected
            if (prev.next == curr) {
                prev = prev.next;
            } else {
                // Duplicates detected, skip all duplicates
                prev.next = curr.next;
            }
            
            curr = curr.next;
        }
        
        return dummy.next;
    }
}


