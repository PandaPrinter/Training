public class Snake {

	int cols;
	int rows;
	int[][] food;
	int score;
	Set<Integer> set;
	Deque<Integer> body;
	int foodIndex;

	public Snake(int width, int height, int[][] food) {
		this.cols = width;
		this.rows = height;
		this.food = food;
		set = new HashSet<>();
		set.add(0);
		body = new LinkedList<>();
		body.offerLast(0);
	}

	public int move(String direction) {
		if (score == -1) {
			return -1;
		}

		int row = body.peekFirst() / cols;
		int col = body.peekFirst() % cols;

		switch(direction) {
			case "U" : row--;
					   break;
			case "D" : row++;
					   break;
			case "L" : col--;
					   break;
			default :  col++;
		}

		int head = row * cols + col;

		set.remove(body.peekLast());
		if (row < 0 || row == rows || col < 0 || col == cols || set.contains(head)) {
			score = -1;
			return score;
		}

		set.add(head);
		body.offerFirst(head);

		if (foodIndex < food.length && row == food[foodIndex][0] && col == food[foodIndex][1]) {
			set.add(body.peekLast());
			foodIndex++;
			score++;
			return score;
		}

		body.pollLast();
		return score;
	}
}
