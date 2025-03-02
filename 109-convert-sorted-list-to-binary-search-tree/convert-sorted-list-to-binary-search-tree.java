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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 //avl,red black tree-self height balance trees treemap also stores in red black trees
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        return construct(head,null);        
    }


    TreeNode construct(ListNode st,ListNode end){
        if(st==end) return null;
        ListNode mid=findMiddle(st,end);
        TreeNode root=new TreeNode(mid.val);
        root.left=construct(st,mid); 
        root.right=construct(mid.next,end);
        return root; 


    }

    ListNode findMiddle(ListNode head,ListNode end){
      ListNode slow=head;
      ListNode fast=head;
      while(fast != end && fast.next != end){
        slow=slow.next;
        fast=fast.next.next;
      }
      return slow;
        
    
    }

}