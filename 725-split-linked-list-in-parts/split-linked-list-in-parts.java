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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode temp=head;
        int len=0;
        while(temp!=null){
            len++;
            temp=temp.next;

        }
        int size=len/k;//each split size
        int rem=len%k;
        ListNode res[]=new ListNode[k];
        ListNode curr=head;
        for(int i=0;i<k;i++){
            ListNode partHead=curr;
            int partSize=size+(i<rem?1:0);
            for(int j=0;j<partSize-1 && curr!=null;j++){
                curr=curr.next;
            }
            if(curr!=null){
                ListNode next=curr.next;
                curr.next=null;//break the link
                curr=next;
            }
            res[i]=partHead;
        }
        return res;

        
    }
}