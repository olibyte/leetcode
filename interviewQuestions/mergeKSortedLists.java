package interviewQuestions;

import java.util.PriorityQueue;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
public class mergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {

        // Initiate a minheap based on the val of the node
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);

        // put the first node of every list into queue
        for (ListNode node : lists) {
            if (node == null)
                continue;
            queue.add(node);
        }

        // dummy head to carry the result
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;

        // link the root of minheap to he dummyHead, add the root.next to the minheap,
        // repeate this process untill minheap runs out of nodes
        while (!queue.isEmpty()) {
            curr.next = queue.poll();
            curr = curr.next;
            if (curr.next != null)
                queue.add(curr.next);
        }

        return dummyHead.next;

    }
}
