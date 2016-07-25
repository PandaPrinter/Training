/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode dummy = null;
        while (head != null) {
            ListNode temp = new ListNode(head.val);
            temp.next = dummy;
            head = head.next;
            dummy = temp;
        }
        return dummy;
    }
    
}