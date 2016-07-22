/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode dummyA = headA, dummyB = headB;
        int countA = 0, countB = 0;
        while (true) {
            if (countA == 2 || countB == 2) break;
            if (dummyA == dummyB) return dummyA;
            dummyA = dummyA.next;
            dummyB = dummyB.next;
            if (dummyA == null) {
                dummyA = headB;
                countA++;
            }
            if (dummyB == null) {
                dummyB = headA;
                countB++;
            }
        }
        return null;
    }
}