package interviewQuestions;

import java.util.List;

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
class oddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
    if (head == null) 
        return null;
    ListNode odd = head; //node 1
    ListNode even = head.next; //2
    ListNode evenHead = even; //2
    
    while (even != null &&  even.next != null) {
        odd.next = even.next; //3
        odd = odd.next; //3
        even.next = odd.next; //4
        even = even.next; //4
    }
    odd.next = evenHead; //2
    return head;
    }

}