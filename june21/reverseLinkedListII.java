public class reverseLinkedListII {
    public class ListNode {
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         }
    public ListNode reverseBetween(ListNode head, int left, int right) {

        // In case of empty list return null
        if (head == null) {
            return null;
        }

        int count = 1;

        // Move curr and prev until they reach proper starting point in the list
        ListNode curr = head;

        ListNode prev = null;

        while (curr != null && count < left) {
            prev = curr;
            curr = curr.next;
            count++;
        }

        // A node before the subList's node
        ListNode beforeNode = prev;

        // Sublist's first node
        ListNode subHead = curr;

        ListNode next;

        // Reverse the sublist
        while (curr != null && count <= right) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        // Fix the connections
        if (beforeNode != null) {
            beforeNode.next = prev;
        } else {
            head = prev;
        }

        subHead.next = curr;

        return head;
    }
}
