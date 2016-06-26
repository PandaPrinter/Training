/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode dummyhead = head;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int val = 0;
            val = ((l1 == null) ? 0 : l1.val) + ((l2 == null) ? 0 : l2.val) + carry;
            carry = val / 10;
            head.next = new ListNode(val % 10);
            head = head.next;
            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }
        return dummyhead.next;
    }
    
}

public class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> queue = new LinkedList<>();
        if (digits.length() == 0 || digits == null) return queue;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        helper(mapping, queue, digits, "", 0);
        return queue;
    }
    public void helper(String[] mapping, LinkedList<String> queue, String digits, String str, int i) {
        if (str.length() == digits.length()) {
            queue.add(str);
            return;
        }
        String s = mapping[digits.charAt(i) - '0'];
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            str += c;
            helper(mapping, queue, digits, str, ++i);
            i--;
            str = str.substring(0, str.length() - 1);
        }
    }
}