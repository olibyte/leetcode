package interviewQuestions;

// Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

// point 1 to tail, point 5 to head
// point
// [1,2,3,4,5]
// [5,4,3,2,1]
// curr = 1,
// head.val = 5
// tail.val =
public class reverseLinkedList {
    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode next = null;

        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        head = prev;
        return head;
    }
}