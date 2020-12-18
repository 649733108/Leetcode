package Solutions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by wxn
 * 2019/7/12 10:01
 *
 * 37. 解数独
 *
 * 编写一个程序，通过已填充的空格来解决数独问题。
 *
 * 一个数独的解法需遵循如下规则：
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 *
 *
 *
 * 一个数独。
 *
 *
 *
 * 答案被标成红色。
 *
 * Note:
 *
 * 给定的数独序列只包含数字 1-9 和字符 '.' 。
 * 你可以假设给定的数独只有唯一解。
 * 给定数独永远是 9x9 形式的。
 *
 */


public class Solution37 {

	private Set<Character>[] rowSet;
	private Set<Character>[] colSet;
	private Set<Character>[] boxSet;
	private boolean finish;

	public void solveSudoku(char[][] board) {

		rowSet = new HashSet[9];
		colSet = new HashSet[9];
		boxSet = new HashSet[9];
		for (int i = 0; i < 9; i++) {
			rowSet[i] = new HashSet<>();
			colSet[i] = new HashSet<>();
			boxSet[i] = new HashSet<>();
		}
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				char num = board[i][j];
				if (num != '.') {
					rowSet[i].add(num);
					colSet[j].add(num);
					boxSet[getIndexOfBox(i, j)].add(num);
				}
			}
		}

		putNum(board,0);
	}

	//往第index个放置数字 (0<=index<81)
	private void putNum(char[][] board, int index) {
		if (index==81){
			finish = true;
			return;
		}
		int x = index/9;
		int y = index%9;
		if (board[x][y]=='.'){
			for (int i = 1 ; i<=9 ; i++){
				char c = (char) ('0' + i);
				if (!rowSet[x].contains(c)
						&& !colSet[y].contains(c)
						&& !boxSet[getIndexOfBox(x, y)].contains(c)){
					board[x][y] = c;
					rowSet[x].add(c);
					colSet[y].add(c);
					boxSet[getIndexOfBox(x, y)].add(c);
					putNum(board, index+1);
					if (!finish){
						board[x][y] = '.';
						rowSet[x].remove(c);
						colSet[y].remove(c);
						boxSet[getIndexOfBox(x, y)].remove(c);
					}
				}
			}
		}else {
			putNum(board, index+1);
		}
	}

	//得到坐标为(i,j)的点是第几个格子
	private int getIndexOfBox(int i, int j) {
		return i/3*3+(j/3);
	}

	public static void main(String[] args) {
		char[][] board = {
				{'5','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}
		};

		Solution37 solution37 = new Solution37();
		solution37.solveSudoku(board);

		for (char[] chars : board) {
			System.out.println(Arrays.toString(chars));
		}
	}



}
