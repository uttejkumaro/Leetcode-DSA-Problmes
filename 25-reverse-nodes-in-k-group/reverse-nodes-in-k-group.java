class Solution {

    private int findLength(ListNode head) {
        int result = 0;
        ListNode currNode = head;
        while (currNode != null) {
            result++;
            ListNode nextNodeAdress = currNode.next;
            currNode = nextNodeAdress;
        }
        return result;
    }


    public ListNode reverseKGroup(ListNode head, int k) {
        int length = findLength(head);
        ListNode newHead = null;
        ListNode tail = null;
        ListNode currNode = head;
        // 10 --> 20 --> 30 --> 40 --> 50 --> 60 --> 70 --> null
        // 30 --> 20 --> 10 --> 60 --> 50 --> 40
        while (length >= k) {
            // reverse the k blocks 
            ListNode previousNode = null;
            ListNode startingNode = currNode;
            for (int index = 0; index < k; index++) {
                ListNode nextNodeAdress = currNode.next;
                currNode.next = previousNode;
                previousNode = currNode;
                currNode = nextNodeAdress;
            }
            if (newHead == null) {
                newHead = previousNode;
            } else {
                tail.next = previousNode;
            }
            tail = startingNode;
            length -= k;
        }
        if (tail != null) {
            tail.next = currNode;
        }
        
        return newHead;
    }
}