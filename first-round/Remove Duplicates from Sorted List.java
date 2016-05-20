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
        if (head == null) {
            return null;
        }
        ListNode prev = head;
        ListNode curr = head.next;
        while (curr != null) {
            if (prev.val == curr.val) {
                curr = curr.next;
                prev.next = curr;
                continue;
            }
            prev = curr;
            curr = curr.next;
        }
        return head;
    }
    
}