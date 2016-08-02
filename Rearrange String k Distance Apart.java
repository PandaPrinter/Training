/*
 
 Given a non-empty string str and an integer k, rearrange the string such that the same characters are at least distance k from each other.
 
 All input strings are given in lowercase letters. If it is not possible to rearrange the string, return an empty string "".
 
 Example 1:
 str = "aabbcc", k = 3
 
 Result: "abcabc"
 
 The same letters are at least distance 3 from each other.
 Example 2:
 str = "aaabc", k = 3
 
 Answer: ""
 
 It is not possible to rearrange the string.
 Example 3:
 str = "aaadbbcc", k = 2
 
 Answer: "abacabcd"
 
 Another possible answer is: "abcabcda"
 
 The same letters are at least distance 2 from each other.
 
 */

public class Solution {
    public String rearrangeString(String str, int k) {
        int length = str.length();
        int[] count = new int[26];
        int[] valid = new int[26];
        for (int i = 0; i < length; i++) {
            count[str.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int index = 0; index < length; index++) {
            int candidatePos = findValidMax(count, valid, index);
            if (candidatePos == -1) return "";
            count[candidatePos]--;
            valid[candidatePos] = index + k;
            sb.append((char)('a' + candidatePos));
        }
        return sb.toString();
    }
    
    private int findValidMax(int[] count, int[] valid, int index) {
        int max = Integer.MIN_VALUE;
        int candidatePos = -1;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0 && count[i] > max && index >= valid[i]) {
                max = count[i];
                candidatePos = i;
            }
        }
        return candidatePos;
    }
}

public class Solution {
    public String rearrangeString(String str, int k) {
        StringBuilder rearranged = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }
        Queue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
            public int compare(Map.Entry<Character, Integer> entry1, Map.Entry<Character, Integer> entry2) {
                return entry2.getValue() - entry1.getValue();
            }
        });
        Queue<Map.Entry<Character, Integer>> waitQueue = new LinkedList<>();
        maxHeap.addAll(map.entrySet());
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            rearranged.append(entry.getKey());
            entry.setValue(entry.getValue() - 1);
            waitQueue.offer(entry);
            if (waitQueue.size() >= k) {
                Map.Entry<Character, Integer> front = waitQueue.poll();
                if (front.getValue() > 0) {
                    maxHeap.offer(front);
                }
            }
        }
        return rearranged.length() == str.length() ? rearranged.toString() : "";
    }
}