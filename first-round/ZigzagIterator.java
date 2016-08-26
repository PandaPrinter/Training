public class ZigzagIterator {
	Iterator<Integer> it1;
	Iterator<Integer> it2;
	int turns;

	public ZigzagIterator (List<Integer> v1, List<Integer> v2) {
		this.it1 = v1.iterator();
		this.it2 = v2.iterator();
		turns = 0;
	}

	public int next() {
		if (!hasNext()) {
			return 0;
		}

		turns++;
		if (turns % 2 == 1 && it1.hasNext() || !it2.hasNext()) {
			return it1.next();
		} 
		else if (turns % 2 == 0 && it2.hasNext() || !it1.hasNext()) {
			return it2.next();
		}
		return 0;
	}

	public boolean hasNext() {
		return it1.hasNext() || it2.hasNext();
	}
}


public class ZigzagIterator implements Iterator<Integer> {
	List<Iterator<Integer>> itList;
	int turns;

	public ZigzagIterator(List<Iterator<Integer>> list) {
		this.itList = new LinkedList<Iterator<Integer>>();
		for (Iterator<Integer> it : list) {
			if (it.hasNext()) {
				itList.add(it);
			}
		}
		turns = 0;
	}

	public Integer next() {
		if (!hasNext()) {
			return 0;
		}
		Integer res = 0;
		int pos = turns % itList.size();
		Iterator<Integer> cur = itList.get(pos);
		res = cur.next();
		if (!cur.hasNext()) {
			itList.remove(pos);
			turns = pos - 1;
		}
		turns++;
		return res;
	}

	public boolean hasNext() {
		return itList.size() > 0;
	}
}
