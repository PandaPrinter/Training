public static int example (int[] arr, Map<Integer, Integer> pairs) {
		HashMap<Integer, Integer> index = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			index.put(arr[i], i);
		}
		return helper(arr, pairs, index, 0);
	}
	
	public static int helper(int[] arr, Map<Integer, Integer> pairs, Map<Integer, Integer> index, int current) {
		if (current == arr.length) {
			return 0;
		}
		int v1 = arr[current];
		int v2 = arr[current + 1];
		if (pairs.get(v1) == v2) {
			return helper(arr, pairs, index, current + 2);
		}
		
		int index1 = current + 1;
		int index2 = index.get(pairs.get(v1));
		swap(arr, index1, index2, index);
		int val1 = helper(arr, pairs, index, current + 2);
		swap(arr, index1, index2, index);
		
		int index3 = current;
		int index4 = index.get(pairs.get(v2));
		swap(arr, index3, index4, index);
		int val2 = helper(arr, pairs, index, current + 2);
		swap(arr, index3, index4, index);
		
		return 1 + Math.min(val1, val2);
	}
	
	public static void swap(int[] arr, int index1, int index2, Map<Integer, Integer> map) {
		map.put(arr[index1], index2);
		map.put(arr[index2], index1);
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {3, 1, 6, 2, 5, 4};
		Map<Integer, Integer> pair = new HashMap<>();
		pair.put(1, 3);
		pair.put(3, 1);
		pair.put(2, 6);
		pair.put(6, 2);
		pair.put(4, 5);
		pair.put(5, 4);
		System.out.println(example(input, pair));
	}