/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode start = head;
        ListNode end = head;
        while (end != null && end.next != null) {
            start = start.next;
            end = end.next.next;
            if (end == start) return true;
        }
        return false;
    }
    
}