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
    public ListNode removeNodes(ListNode head) {
        List<Integer> vals = new ArrayList<>();
        while (head != null) {
            vals.add(head.val);
            head = head.next;
        }

        int maxSoFar = 0;
        ListNode prev = null;
        for (int i = vals.size() - 1; i >= 0; -- i) {
            if (vals.get(i) >= maxSoFar) {
                maxSoFar = vals.get(i);
                prev = new ListNode(vals.get(i), prev);
            }
        }

        return prev;
    }
}