class Solution {
    public ListNode doubleIt(ListNode head) {
        if (head == null) {
            return null;
        }

        // Traverse to the last node
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }

        int carry = 0;
        // Traverse the list backward and double each value, managing the carry
        while (current != null) {
            int sum = current.val * 2 + carry;
            current.val = sum % 10;
            carry = sum / 10;
            // Move to the previous node
            ListNode prev = findPrevNode(head, current);
            current = prev;
        }

        // If there is a carry left after processing all nodes, add a new node for it at the beginning
        if (carry > 0) {
            ListNode newHead = new ListNode(carry);
            newHead.next = head;
            return newHead;
        }

        return head;
    }

    // Helper function to find the previous node of a given node in the linked list
    private ListNode findPrevNode(ListNode head, ListNode target) {
        ListNode current = head;
        while (current != null && current.next != target) {
            current = current.next;
        }
        return current;
    }
}
