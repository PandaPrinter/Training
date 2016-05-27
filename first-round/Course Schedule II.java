public class Solution {
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        int[] res = new int[numCourses];
        List<Integer>[] nextSet = new List[numCourses];
        int[] ready = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            nextSet[i] = new ArrayList<>();
        }
        for (int[] row : prerequisites) {
            nextSet[row[1]].add(row[0]);
            ready[row[0]]++;
        }
        
        Queue<Integer> pre = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (ready[i] == 0) pre.add(i);
        }
        
        for (int j = 0; j < numCourses; j++) {
            if (pre.isEmpty()) return new int[0];
            int course = pre.poll();
            res[j] = course;
            for (int i : nextSet[course]) {
                ready[i]--;
                if (ready[i] == 0) {
                    pre.add(i);
                }
            }
        }
        return res;
    }
    
}