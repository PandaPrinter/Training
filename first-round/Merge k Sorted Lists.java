/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0 || lists == null) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            public int compare(ListNode n1, ListNode n2) {
                return (int) n1.val - n2.val;
            }
        });
        ListNode head = new ListNode(0);
        ListNode dummy = head;
        for (ListNode n : lists) {
            if (n != null) queue.add(n);
        }
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            dummy.next = node;
            dummy = dummy.next;
            if (node.next != null) {
                queue.add(node.next);
            }
        }
        return head.next;
    }
    
}