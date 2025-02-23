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
    public boolean isPalindrome(ListNode head) {
        StringBuilder sb=new StringBuilder();
        ListNode curr=head;
        if(head==null) return true;
        while(curr!=null){
            sb.append(curr.val);
            curr=curr.next;
        }
        String s=sb.toString();
        return sb.reverse().toString().equals(s);
        
    }
}