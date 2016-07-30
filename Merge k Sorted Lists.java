/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    
    // divide and conquer
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode head = new ListNode(0);
        head.next = mergeSort(0, lists.length - 1, lists);
        return head.next;
    }
    public ListNode mergeSort(int lo, int hi, ListNode[] lists) {
        if (lo == hi) return lists[lo];
        int mi = lo + (hi - lo) / 2;
        ListNode left = mergeSort(lo, mi, lists);
        ListNode right = mergeSort(mi + 1, hi, lists);
        return merge(left, right);
    }
    public ListNode merge(ListNode left, ListNode right) {
        ListNode temp = new ListNode(0);
        ListNode index = temp;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                index.next = new ListNode(left.val);
                index = index.next;
                left = left.next;
            }
            else {
                index.next = new ListNode(right.val);
                index = index.next;
                right = right.next;
            }
        }
        while (left != null) {
            index.next = new ListNode(left.val);
            index = index.next;
            left = left.next;
        }
        while (right != null) {
            index.next = new ListNode(right.val);
            index = index.next;
            right = right.next;
        }
        return temp.next;
    }
    
    
    // heap
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode index = head;
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            public int compare(ListNode n1, ListNode n2) {
                return n1.val - n2.val;
            }
        });
        for (int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];
            if (node != null) heap.add(node);
        }
        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            if (node != null) {
                index.next = new ListNode(node.val);
                index = index.next;
                node = node.next;
                if (node != null) heap.add(node);
            }
        }
        return head.next;
    }
    
}
