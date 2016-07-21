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
        ListNode fast = head, slow = head;
        while (fast != null && slow != null) {
            if (fast.next == null) break;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == null || slow == null) break;
            if (fast.val == slow.val) return true;
        }
        return false;
    }
    
}