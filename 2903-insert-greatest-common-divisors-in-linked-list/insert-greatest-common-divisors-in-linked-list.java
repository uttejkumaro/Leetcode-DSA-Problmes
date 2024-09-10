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
    int Gcd(int a,int b){
        if(a==0)return b;
        return Gcd(b%a,a);
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode temp=head;
        while(temp!=null && temp.next!=null){
            int gcd=Gcd(temp.val,temp.next.val);
            ListNode add=new ListNode(gcd);
            add.next=temp.next;
            temp.next=add;
            temp=add.next;
        }
        return head;
        
    }
}