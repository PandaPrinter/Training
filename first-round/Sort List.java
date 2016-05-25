/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        // mergesort
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode nextHalf = sortList(slow.next);
        slow.next = null;
        return merge(sortList(head), nextHalf);
    }
    private ListNode merge(ListNode head, ListNode nextHalf) {
        ListNode dummy = new ListNode(0);
        ListNode cursor = dummy;
        while (head != null && nextHalf != null) {
            if (head.val < nextHalf.val) {
                cursor.next = head;
                head = head.next;
            }
            else {
                cursor.next = nextHalf;
                nextHalf = nextHalf.next;
            }
            cursor = cursor.next;
        }
        if (head != null) {
            cursor.next = head;
        }
        if (nextHalf != null) {
            cursor.next = nextHalf;
        }
        return dummy.next;
    }
    
}