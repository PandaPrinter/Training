public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> leaves = new ArrayList<>();
        if (n <= 1) {
            leaves.add(n-1);
            return leaves;
        }
        
        List<Set<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n-1; i++) {
            list.add(new HashSet<>());
        }
        
        for (int[] edge : edges) {
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        
        
        for (int i = 0; i < n; i++) {
            if (list.get(i).size() == 1) {
                leaves.add(i);
            }
        }
        
        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int i : leaves) {
                int j = list.get(i).iterator().next();
                list.get(j).remove(i);
                if (list.get(j).size() == 1) newLeaves.add(j);
            }
            leaves = newLeaves;
        }
        
        return leaves;
    }
    
}