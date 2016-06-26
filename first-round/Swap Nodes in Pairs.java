/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode newHead = dummy;
        ListNode first = null, second = null;
        while (dummy.next != null && dummy.next.next != null) {
            first = dummy.next;
            second = dummy.next.next;
            first.next = second.next;
            second.next = first;
            dummy.next = second;
            dummy = first;
        }
        return newHead.next;
    }
    
}