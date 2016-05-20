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
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        
        ListNode prev = fakeHead;
        ListNode curr = head;
        int value = 0;
        if (curr.next == null) return head;
        
        while (curr != null) {
            if (curr.next != null && curr.val == curr.next.val) {
                value = curr.val;
                while (curr.val == value) {
                    curr = curr.next;
                    if (curr == null) break;
                }
                prev.next = curr;
            }
            else {
                prev = curr;
                curr = curr.next;
            }
        }
        return fakeHead.next;
    }
    
}