public class Solution {
    public boolean validTree(int n, int[][] edges) {
    	int[] record = new int[n];
    	int component = n;
    	for (int i = 0; i < n; i++) {
    		record[i] = i;
    	} 
    	for (int[] edge : edges) {
    		if (union(edge, record)) {
    			component--;
    		}
    		else {
    			return false;
    		}
    	}
    	return component == 1;
    }

    private boolean union(int[] edge, int[] record) {
    	int p1 = edge[0];
    	int p2 = edge[1];
    	if (record[p1] == record[p2]) {
    		return false;
    	}
    	int g1 = record[p1];
    	for (int i = 0; i < record.length; i++) {
    		if (record[i] == g1) {
    			record[i] = record[p2];
    		}
    	}
    	return true;
    }
}
