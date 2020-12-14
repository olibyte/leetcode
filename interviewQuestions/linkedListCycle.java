package interviewQuestions;

import java.util.HashSet;
import java.util.Hashtable;

public class linkedListCycle {
    public boolean hasCycle(ListNode head) {
        // Hashtable<Integer,ListNode> visited = new Hashtable<>();
        HashSet<ListNode> visited = new HashSet<>();
        // int count = 0;
        while(head != null) {
            //if we've seen it before, break
            if (visited.contains(head)) {
                return true;
            }
            visited.add(head);
            head = head.next;
        }
        return false;
    }
    public boolean hasCycleOptimized(ListNode head) {
        //two pointers fast and slow. either fast pointer reaches null first (in which case there is no cycle), or fast 'laps' slow (in which case there's a cycle)
        if (head == null)
            return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
