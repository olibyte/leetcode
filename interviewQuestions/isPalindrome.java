package interviewQuestions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

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
public class isPalindrome {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        //find the midpoint, slow.
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //reverse second half
        ListNode prev = null;
        while (slow != null) {
            ListNode tmp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = tmp;
        }
        //check for palindrome
        ListNode left = head;
        ListNode right = prev;
        while (right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
        /*
        //O(n) solution - throw values into an array - use left and right pointers to check for equivalence until the meet in the middle
        if (head == null || head.next == null)
            return true;
        ArrayList<Integer> visited = new ArrayList<>();
        while (head != null) {
            visited.add(head.val);
            head = head.next;
        }
        int left = 0;
        int right = visited.size() - 1;
        while (left <= right)  {
            if (visited.get(left) != visited.get(right)) {
                    return false;
            }
            left++;
            right--;
        }
        return true;
        **/
    }
}
