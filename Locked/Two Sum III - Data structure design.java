/**
Design and implement a TwoSum class. It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

For example:

add(1); 
add(3); 
add(5);
find(4) -> true
find(7) -> false
**/

// many add, less find
public class TwoSum {
	
	Map<Integer, Integer> map = new HashMap<>();

	public void add(int num) {
		if (map.containsKey(num)) {
			map.put(num, map.get(num) + 1);
		}
		else {
			map.put(num, 1);
		}
	}

	public boolean find(int target) {
		for (Integer i : map.keySet()) {
			if (map.containsKey(target - i)) {
				if (target - i != i) return true;
				else if (map.get(i) > 1) return true;
			}
		}
		return false;
	}
}

// many find, less add. But for space complexity, storing all possible sum may lead to O(n2) space.
public class TwoSum {
	
	Set<Integer> num;
	Set<Integer> sum;

	TwoSum() {
		num = new HashSet<>();
		sum = new HashSet<>();
	}

	public void add(int val) {
		for (int i : num) {
			sum.add(i + val);
		}
		num.add(val);
	}

	public boolean find(int target) {
		return sum.contains(target);
	}
}
