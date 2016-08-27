public int depthSum(List<NestedInteger> nestedList) {
	return dfs(nestedList, 0);
}
private int dfs(List<NestedInteger> list, int prev) {
	int sum = prev;
	List<NestedInteger> levelBreak = new ArrayList<>();
	for (NestedInteger i : list) {
		if (i.isInteger()) {
			sum += i.getInteger();
		}
		else {
			levelBreak.addAll(i.getList());
		}
	}
	int listSum = levelBreak.isEmpty() ? 0 : dfs(levelBreak, sum);
	return listSum + sum;
}


public int depthSum(List<NestedInteger> nestedList) {
	int sum = 0, weighted = 0;
	while (!nestedList.isEmpty()) {
		List<NestedInteger> tmp = new ArrayList<>();
		for (NestedInteger i : nestedList) {
			if (i.isInteger()) {
				weighted += i.getInteger();
			}
			else {
				tmp.addAll(i.getList());
			}
		}
		sum += weighted;
		nestedList = tmp;
	}
	return sum;
}


public int depthSum(List<NestedInteger> nestedList) {
	Queue<NestedInteger> queue = new LinkedList<>();
	for (NestedInteger i : nestedList) {
		queue.offer(i);
	}
	int sum = 0, weighted = 0;
	while (!queue.isEmpty()) {
		int size = queue.size();
		for (int i = 0; i < size; i++) {
			NestedInteger num = queue.poll();
			if (num.isInteger()) {
				weighted += num;
			}
			else {
				for (NestedInteger j : num.getList()) {
					queue.add(j);
				}
			}
		}
		sum += weighted;
	}
	return sum;
}
