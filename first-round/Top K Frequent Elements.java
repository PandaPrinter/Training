public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        
        /*
         //method 1:
         Map<Integer, Integer> map = new HashMap<>();
         for (int num : nums) {
         int count = map.getOrDefault(num, 0);
         map.put(num, ++count);
         }
         PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
         for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
         pq.offer(entry);
         if (pq.size() > k) {
         pq.poll();
         }
         }
         List<Integer> list = new LinkedList<>();
         while (!pq.isEmpty()) {
         list.add(pq.poll().getKey());
         }
         return list;
         */
        
        //method 2:
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int count = map.getOrDefault(num, 0);
            map.put(num, ++count);
        }
        List<Integer>[] arr = new List[nums.length+1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (arr[entry.getValue()] == null) {
                arr[entry.getValue()] = new ArrayList<>();
            }
            arr[entry.getValue()].add(entry.getKey());
        }
        List<Integer> res = new ArrayList<>();
        for (int i = nums.length; i >= 0; i--) {
            if (res.size() == k) break;
            if (arr[i] != null) {
                res.addAll(arr[i]);
            }
        }
        return res;
    }
    
}