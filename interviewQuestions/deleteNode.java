package interviewQuestions;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class deleteNode {
    //[4,1,5,9]
    //node.val = 4
    //node.next.val = 1
    //node.next.next.val = 5
    //we don't have access to head, so we simply assign node's val to its neighbour's val, and its next property to its neighbour's next property
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
