/**
Implement an iterator to flatten a 2d vector.

For example, Given 2d vector =

[
  [1,2],
  [3],
  [4,5,6]
] 
By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].
**/


// method 1: 
public class Vector2D {

	List<Iterator> list = new ArrayList<>();
	int cur = 0;
	public Vector2D(List<List<Integer>> vec2d) {
		for (List<Integer> l : vec2d) {
			if (l.size() > 0) {
				list.add(l.iterator());
			}
		}
	}

	public int next() {
		Integer i = list.get(cur).next();
		if (!list.get(cur).hasNext()) {
			cur++;
		}
		return i;
	}

	public boolean hasNext() {
		return cur < list.size() && list.get(cur).hasNext();
	}
}


// method 2: 
public class Vector2D {

	Iterator<List<Integer>> it;
	Iterator<Integer> cur;

	public Vector2D(List<List<Integer>> vec2d) {
		it = vec2d.iterator();	
	}

	public int next() {
		hasNext();
		return cur.next();
	}

	public boolean hasNext() {
		while ((cur == null || !cur.hasNext()) && it.hasNext()) {
			cur = it.next().iterator();
		}
		return cur != null && cur.hasNext();
	}
}
