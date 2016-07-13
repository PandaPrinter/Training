/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode node = new ListNode(head.val);
        ListNode dummy = node;
        ListNode next = head.next;
        while (next != null) {
            if (next.val != head.val) {
                dummy.next = new ListNode(next.val);
                dummy = dummy.next;
            }
            head = head.next;
            next = next.next;
        }
        return node;
    }
}