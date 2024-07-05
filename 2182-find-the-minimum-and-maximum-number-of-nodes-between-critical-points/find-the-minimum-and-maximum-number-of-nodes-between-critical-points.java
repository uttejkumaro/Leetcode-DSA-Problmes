/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return new int[] {-1, -1};
        }
        
        int firstCP = -1, lastCP = -1, minDist = Integer.MAX_VALUE;
        int index = 1;
        ListNode prev = head, curr = head.next, next = head.next.next;
        int[] result = new int[] {-1, -1};
        
        while (next != null) {
            if ((curr.val > prev.val && curr.val > next.val) || (curr.val < prev.val && curr.val < next.val)) {
                if (firstCP == -1) {
                    firstCP = index;
                } else {
                    minDist = Math.min(minDist, index - lastCP);
                    result[1] = index - firstCP; // maxDist
                }
                lastCP = index;
            }
            prev = curr;
            curr = next;
            next = next.next;
            index++;
        }
        
        if (firstCP == lastCP) {
            return new int[] {-1, -1};
        }
        
        result[0] = minDist;
        return result;
    }
}
