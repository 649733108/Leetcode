/**
 * Created by wxn
 * 2019/7/10 14:56
 * <p>
 * 79. 单词搜索
 * <p>
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 示例:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 */


public class Solution79 {

	//行数
	private int m;
	//列数
	private int n;
	//格子是否已经使用过
	private boolean[][] visited;
	//偏移量
	private int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

	public boolean exist(char[][] board, String word) {

		m = board.length;
		n = board[0].length;
		visited = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				visited[i][j] = true;
				if (searchWord(board, word, 0, i, j)) {
					return true;
				}
				visited[i][j] = false;
			}
		}
		return false;
	}

	//在(x,y)位置开始搜索word的index位置开始到最后
	private boolean searchWord(char[][] board, String word, int index, int x, int y) {
		if (word.charAt(index) == board[x][y] && index == word.length() - 1) {
			return true;
		}
		if (word.charAt(index) != board[x][y]) {
			visited[x][y] = false;
			return false;
		}
		for (int i = 0; i < 4; i++) {
			int newX = x + d[i][0];
			int newY = y + d[i][1];
			if (inArea(newX, newY) && !visited[newX][newY]) {
				visited[newX][newY] = true;
				if (!searchWord(board, word, index + 1, newX, newY)) {
					visited[newX][newY] = false;
				} else {
					return true;
				}
			}
		}
		return false;
	}

	private boolean inArea(int newX, int newY) {
		return newX >= 0 && newX < m && newY >= 0 && newY < n;
	}

	public static void main(String[] args) {
//		char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
		char[][] board = {{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};
		System.out.println(new Solution79().exist(board, "AAB"));
	}

}
