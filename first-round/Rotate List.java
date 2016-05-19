/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        
        ListNode fast = head;
        int size = 1;
        while (fast.next != null) {
            fast = fast.next;
            size++;
        }
        
        int count = 1;
        ListNode slow = head;
        while (count < size - k % size) {
            slow = slow.next;
            count++;
        }
        
        fast.next = head;
        head = slow.next;
        slow.next = null;
        
        return head;
    }
    
}