public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> res = new ArrayList<>();
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (String[] row : tickets) {
            String depature = row[0];
            String arrival = row[1];
            PriorityQueue<String> pq = new PriorityQueue<>();
            if (map.containsKey(depature)) {
                pq = map.get(depature);
            }
            pq.offer(arrival);
            map.put(depature, pq);
        }
        dfs(res, map, "JFK");
        return res;
    }
    
    private void dfs(List<String> res, Map<String, PriorityQueue<String>> map, String depature) {
        PriorityQueue<String> pq = map.get(depature);
        while (pq != null && !pq.isEmpty()) {
            dfs(res, map, pq.poll());
        }
        res.add(0, depature);
    }
}
