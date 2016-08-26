/**
Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
For example,
MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3
**/

public class MovingAverage {
	
	Queue<Integer> queue;
	int sum;
	int n;

	public MovingAverage(int size) {
		queue = new LinkedList<>(size);
		sum = 0;
		n = size;
	}

	public double next(int val) {
		sum += val;
		queue.offer(val);
		if (queue.size() > n) {
			int head = queue.poll();
			sum -= head;
			return (double) sum / n; 
		}
		else {
			return (double) sum / queue.size();
		}
	}
}
