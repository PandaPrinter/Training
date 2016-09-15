/**
You are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647. 
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

For example, given the 2D grid:

INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF 

After running your function, the 2D grid should be:

  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4
**/

public class Solution {
    public void wallsAndGates(int[][] rooms) {
    	int m = rooms.length, n = rooms[0].length;
    	for (int i = 0; i < m; i++) {
    		for (int j = 0; j < n; j++) {
    			if (rooms[i][j] == 0) dfs(rooms, i, j, 0);
    		}
    	}
    }
    private void dfs(int[][] rooms, int i, int j, int d) {
    	if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || rooms[i][j] < d) return;
    	rooms[i][j] = d;
    	dfs(rooms, i-1, j, d+1);
    	dfs(rooms, i, j-1, d+1);
    	dfs(rooms, i+1, j, d+1);
    	dfs(rooms, i, j+1, d+1);
    }
}



public class Solution {
    public void wallsAndGates(int[][] rooms) {
    	int m = rooms.length, n = rooms[0].length;
    	Queue<int[]> queue = new LinkedList<>();
    	for (int i = 0; i < m; i++) {
    		for (int j = 0; j < n; j++) {
    			if (rooms[i][j] == 0) queue.offer(new int[]{i, j}); 
    		}
    	}
    	while (!queue.isEmpty()) {
    		int[] p = queue.poll();
    		int x = p[0], y = p[1];
    		if (x > 0 && rooms[x-1][y] == Integer.MAX_VALUE) {
    			rooms[x-1][y] = rooms[x][y] + 1;
    			queue.offer(new int[]{x-1, y});
    		}
    		if (x < m-1 && rooms[x+1][y] == Integer.MAX_VALUE) {
    			rooms[x+1][y] = rooms[x][y] + 1;
    			queue.offer(new int[]{x+1, y});
    		}
    		if (y > 0 && rooms[x][y-1] == Integer.MAX_VALUE) {
    			rooms[x][y-1] = rooms[x][y] + 1;
    			queue.offer(new int[]{x, y-1});
    		}
    		if (y < n-1 && rooms[x][y+1] == Integer.MAX_VALUE) {
    			rooms[x][y+1] = rooms[x][y] + 1;
    			queue.offer(new int[]{x, y+1});
    		}
    	}
    }
}
