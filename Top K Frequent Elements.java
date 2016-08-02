public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        
        
        // minheap
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            public int compare(Integer n1, Integer n2) {
                return map.get(n1) - map.get(n2);
            }
        });
        for (int i : nums) {
            if (!map.containsKey(i)) map.put(i, 1);
            else map.put(i, map.get(i) + 1);
        }
        for (Integer i : map.keySet()) {
            pq.offer(i);
            if (pq.size() > k) pq.poll();
        }
        List<Integer> res = new ArrayList<Integer>(pq);
        return res;
        
        // method 2
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<Integer>();
        List<Integer>[] arr = new List[nums.length + 1];
        for (int i : nums) {
            if (!map.containsKey(i)) map.put(i, 1);
            else map.put(i, map.get(i) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (arr[entry.getValue()] == null) arr[entry.getValue()] = new ArrayList<>();
            arr[entry.getValue()].add(entry.getKey());
        }
        for (int i = nums.length; i >= 0; i--) {
            if (arr[i] != null) {
                for (int e : arr[i]) {
                    if (res.size() != k) res.add(e);
                    else break;
                }
            }
            if (res.size() == k) break;
        }
        return res;
    }
    
}