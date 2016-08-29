public class Solution {
    public ListNode reverseList(ListNode head) {
        return helper(head, null);
    }
    private ListNode helper(ListNode node, ListNode prev) {
        if (node == null) {
            return prev;
        }
        ListNode n = node.next;
        node.next = prev;
        return helper(n, node);
    }
}



public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode dummy = head;
        ListNode prev = null;
        while (dummy != null) {
            ListNode node = dummy.next;
            dummy.next = prev;
            prev = dummy;
            dummy = node;
        }
        return prev;
    }
}
