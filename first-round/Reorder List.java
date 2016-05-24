/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode dummy = slow;
        ListNode dummy1 = slow.next;
        while (dummy1.next != null) {
            ListNode n = dummy1.next;
            dummy1.next = n.next;
            n.next = dummy.next;
            dummy.next = n;
        }
        
        ListNode newHead = head;
        slow = slow.next;
        while (newHead != dummy) {
            dummy.next = slow.next;
            slow.next = newHead.next;
            newHead.next = slow;
            slow = dummy.next;
            newHead = newHead.next.next;
        }
    }
    
}