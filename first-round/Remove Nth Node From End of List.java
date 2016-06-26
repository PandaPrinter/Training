/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = head;
        int m = 0;
        while (dummyHead != null) {
            dummyHead = dummyHead.next;
            m++;
        }
        int s = m - n - 1;
        dummyHead = head;
        for (int i = 0; i < s; i++) {
            dummyHead = dummyHead.next;
        }
        if (s < 0) {
            return head.next;
        }
        dummyHead.next = dummyHead.next.next;
        return head;
    }
    
}