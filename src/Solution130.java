import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wxn
 * 2019/7/11 10:40
 *
 * 130. 被围绕的区域
 *
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 *
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 * 示例:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 解释:
 *
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 *
 */


public class Solution130 {

	int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	int m;
	int n;
	boolean[][] visited;
	List<Pair<Integer,Integer>> change;

	public void solve(char[][] board) {

		m = board.length;
		if (m==0)
			return;
		n = board[0].length;
		visited = new boolean[m][n];


		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j] && board[i][j]=='O'){
					change = new ArrayList<>();
					if (bfs(board, change, i, j)){
						for (Pair<Integer, Integer> pair : change) {
							board[pair.getKey()][pair.getValue()] = 'X';
						}
					}
				}
			}

		}

	}

	private boolean bfs(char[][] board, List<Pair<Integer, Integer>> change, int x, int y) {
		visited[x][y] = true;
		change.add(new Pair<>(x, y));
		boolean ret = true;
		for (int i = 0; i < 4; i++) {
			int newX = x+d[i][0];
			int newY = y+d[i][1];
			if (!inArea(newX,newY)){
				ret = false;
				continue;
			}
			if (!visited[newX][newY]&&board[newX][newY] == 'O') {
				ret = ret&bfs(board, change, newX, newY);
			}
		}
		return ret;
	}

	private boolean inArea(int newX, int newY) {
		return newX >= 0 && newX < m && newY >= 0 && newY < n;
	}

	public static void main(String[] args) {
		char[][] board = {
				{'O','O','O','O','X','X'},
				{'O','O','O','O','O','O'},
				{'O','X','O','X','O','O'},
				{'O','X','O','O','X','O'},
				{'O','X','O','X','O','O'},
				{'O','X','O','O','O','O'}
		};
		for (char[] chars : board) {
			System.out.println(Arrays.toString(chars));
		}
		System.out.println();
		new Solution130().solve(board);
		for (char[] chars : board) {
			System.out.println(Arrays.toString(chars));
		}
	}

}
