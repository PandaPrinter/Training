public class PhoneDirectory {
	
	Queue<Integer> available; 
	Set<Integer> used;
	int max;

	public PhoneDirectory(int size) {
		available = new LinkedList<>(); 
		for (int i = 0; i < size; i++) {
			available.offer(i);
		}
		set = new HasSet<>();
		max = size;
	}

	public int get() {
		Integer num = available.poll();
		if (num == null) return -1;
		used.add(num);
		return num;
	}

	public boolean check(int num) {
		if (num >= max || num < 0 || used.contains(num)) return false;
		return true;
	}

	public void release(int num) {
		if (set.remove(num)) available.offer(num);
	}
}
