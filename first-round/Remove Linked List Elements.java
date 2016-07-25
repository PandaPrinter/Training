/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode index = head, pre = new ListNode(0), temp = pre;
        while (index != null) {
            if (index.val == val) {
                pre.next = index.next;
            }
            else {
                pre.next = index;
                pre = pre.next;
            }
            index = index.next;
        }
        return temp.next;
    }
    
}