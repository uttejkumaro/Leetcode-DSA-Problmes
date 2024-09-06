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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer>toRemove=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            toRemove.add(nums[i]);
        }
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode prev=dummy;
        ListNode curr=head;
        while(curr!=null){
            if(toRemove.contains(curr.val)){
                prev.next=curr.next;//skip the curr elemant;
            }
            else{
                prev=curr;
            }
            curr=curr.next;
        }
        return dummy.next;
    

        
    }
}