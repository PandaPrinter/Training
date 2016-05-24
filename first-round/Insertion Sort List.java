/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        
        ListNode start = new ListNode(0);
        start.next = head;
        
        ListNode dummy = start;
        ListNode prev = head;
        ListNode curr = head.next;
        while (curr != null) {
            if (curr.val < prev.val) {
                while (curr.val > dummy.next.val) {
                    dummy = dummy.next;
                }
                prev.next = curr.next;
                curr.next = dummy.next;
                dummy.next = curr;
                curr = prev.next;
                dummy = start;
            }
            else {
                prev = curr;
                curr = curr.next;
            }
        }
        return dummy.next;
    }
    
}