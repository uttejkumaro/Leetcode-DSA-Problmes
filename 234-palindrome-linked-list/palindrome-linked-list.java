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
/* 
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next; 
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode curr = slow;
        ListNode next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr= next;
        }

        ListNode right = prev;
        ListNode left= head;

        while(right != null){
            if(right.val != left.val){
                return false;
            }
            right = right.next;
            left = left.next;
        }
        return true;
    }
}*/