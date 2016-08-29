/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null; // 记得判断length = 0.
        ListNode head = mergeSort(0, lists.length - 1, lists); // mergeSort function 的格式，需要返回node, 而且有高低index.
        return head;
    }
    private ListNode mergeSort(int lo, int hi, ListNode[] lists) {
        ListNode head = lists[lo];
        if (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            ListNode left = mergeSort(lo, mid, lists);
            ListNode right = mergeSort(mid + 1, hi, lists);
            head = merge(left, right);
        }
        return head;
    }
    private ListNode merge(ListNode left, ListNode right) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                cur.next = left;
                left = left.next;
            }
            else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = left == null ? right : left;
        return head.next;
    }    
}
