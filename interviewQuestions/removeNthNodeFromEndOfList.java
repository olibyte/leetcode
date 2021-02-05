package interviewQuestions;

// Definition for singly-linked list.
// https://leetcode.com/problems/remove-nth-node-from-end-of-list/solution/
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class removeNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        //use an auxiliary dummy node
        dummy.next = head;
        int length =  0;
        ListNode first = head;
        //first find the length of the list
        while (first != null) {
            length++;
            first = first.next;
        }
        //we want to remove the nth node - namely length - n.
        length = length - n;
        first = dummy;
        //traverse to the node to be removed
        while (length > 0) {
            length--;
            first = first.next;
        }
        //and remove it
        first.next = first.next.next;
        return dummy.next;
    }
    // The above algorithm could be optimized to one pass. Instead of one pointer, we could use two pointers. The first pointer advances the list by n+1n+1 steps from the beginning, while the second pointer starts from the beginning of the list. Now, both pointers are exactly separated by nn nodes apart. We maintain this constant gap by advancing both pointers together until the first pointer arrives past the last node. The second pointer will be pointing at the nnth node counting from the last. We relink the next pointer of the node referenced by the second pointer to point to the node's next next node.    
    /*
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
    */
}
