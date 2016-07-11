public static int SumOfBitDifference (int[] arr) {
		int len = arr.length;
		int sum = 0;
		for (int i = 0; i < 32; i++) {
			int count = 0;
			for (int j = 0; j < len; j++) {
				int bit = arr[j] & (1 << i);
				if (bit == 0) {
					count++;
				}
			}
			sum += (count * (len - count) * 2);
		}
		return sum;
	}