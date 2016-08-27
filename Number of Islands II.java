public List<Integer> numIslands2(int m, int n, int[][] positions) {
	List<Integer> res = new ArrayList<>();
	int[] island = new int[m * n];
	Arrays.fill(island, -1);
	int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	int counter = 0;
	for (int[] pos : positions) {
		counter++;
		int x = pos[0];
		int y = pos[1];
		int index = x * n + y;
		island[index] = index;
		for (int[] dir : dirs) {
			int a = x + dir[0];
			int b = y + dir[1];
			int ind = a * n + b;
			if (a < 0 || a >= m || b < 0 || b >= n || island[ind] == -1) continue;
			int newIndex = union(ind, island);
			if (newIndex != index) {
				island[newIndex] = index;
				counter--;
			}
		}
		res.add(counter);
	}
	return res;
}
private void union(int index, int island) {
	while (index != island(index)) {
		island[index] = island[island[index]];
		index = island[index];
	}
	return index;
}
