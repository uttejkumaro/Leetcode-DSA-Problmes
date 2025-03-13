class Solution {

    private int findLength(ListNode head) {
        int result = 0;
        ListNode currNode = head;
        while (currNode != null) {
            result++;
            currNode=currNode.next;
          
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
            ListNode previousNode=null;
            ListNode startingNode = currNode;
            for (int index = 0; index < k; index++) {//reverse ll
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
        
            tail.next = currNode;
       
        
        return newHead;
    }
}
// //class Solution {

//     private int findLength(ListNode head) {
//         ListNode curr = head;
//         int length = 0;

//         while (curr != null) {
//             curr = curr.next;
//             length++;
//         }
//         return length;
//     }

//     public ListNode reverseKGroup(ListNode head, int k) {
        

//         int length = findLength(head);
//         if (length < k) {
//             return head;
//         }

//         ListNode dummy = new ListNode(-1);
//         ListNode tail = dummy;

//         ListNode curr = head;
//         while (length >= k) {
//             ListNode firstNode = curr;
//             ListNode prev = null, next;
//             for (int index = 1; index <= k; index++) {
//                 next = curr.next;
//                 curr.next = prev;
//                 prev = curr;
//                 curr = next;
//             }
//             tail.next = prev;
//             tail = firstNode;
//             length -= k;
//         }
//         tail.next = curr;
//         return dummy.next;

//     }
// }
