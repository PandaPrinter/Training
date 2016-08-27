public int countComponent(int n, int[][] edges) {
	int[] record = new int[n];
	for (int i = 0; i < n; i++) {
		record[i] = i;
	}
	for (int[] edge : edges) {
		int root1 = find(record, edge[0]);
		int root2 = find(record, edge[1]);
		if (root1 != root2) {
			record[root1] = root2;
			n--;
		}
	}
	return n;
}
private int find(int[] record, int id) {
	while (record[id] != id) {
		record[id] = record[record[id]];
		id = record[id];
	}
	return id;
} 
