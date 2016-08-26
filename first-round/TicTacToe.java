public class TicTacToe {

	int[] rows;
	int[] cols;
	int diagonal;
	int antiDiagonal;

	public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        diagonal = 0;
        antiDiagonal = 0;   
    }

    public int move(int row, int col, int player) {
    	int move = player == 1 ? 1 : -1;
    	rows[row] += move;
    	cols[col] += move;
    	if (row == col) {
    		diagonal += move;
    	}
    	if (row == (cols.length - 1 - col)) {
    		antiDiagonal += move;
    	} 

    	int size = rows.length;
    	if (Math.abs(rows[row]) == size || Math.abs(cols[col]) == size) || Math.abs(diagonal) == size || Math.abs(antiDiagonal) == size) return player;
		return 0;
    }
}
