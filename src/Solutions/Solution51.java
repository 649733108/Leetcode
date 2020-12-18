package Solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wxn
 * 2019/7/12 8:24
 *
 * 51. N皇后
 *
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 *
 *
 * 上图为 8 皇后问题的一种解法。
 *
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 *
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 示例:
 *
 * 输入: 4
 * 输出: [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 *
 */


public class Solution51 {

	private List<List<String>> res;
	//col[n]表示第n列是否有棋子
	private boolean[] col;
	//dia1[n]表示第n个从右上到左下的对角线是否有棋子
	private boolean[] dia1;
	//dia2[n]表示第n个从左上到右下的对角线是否有棋子
	private boolean[] dia2;

	public List<List<String>> solveNQueens(int n) {

		res = new ArrayList<>();
		col = new boolean[n];
		dia1 = new boolean[n*2-1];
		dia2 = new boolean[n*2-1];

		if (n==0){
			return res;
		}
		putQueen(n,0,new ArrayList<>());
		
		return res;
	}

	//往第index行放置棋子,row[i]表示第i行棋子所在的列
	private void putQueen(int n, int index, ArrayList<Integer> row) {
		if (index==n){
			res.add(generateBoard(row));
			return;
		}
		for (int i = 0 ; i<n ; i++){
			if (!col[i] && !dia1[index+i] && !dia2[index-i+n-1]){
				row.add(i);
				col[i] = true;
				dia1[index+i] = true;
				dia2[index-i+n-1] = true;
				putQueen(n, index+1, row);
				row.remove(row.size()-1);
				col[i] = false;
				dia1[index+i] = false;
				dia2[index-i+n-1] = false;
			}
		}
	}

	private List<String> generateBoard(ArrayList<Integer> row) {

		List<String> res = new ArrayList<>();
		int n = row.size();
		for (Integer col : row) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < n; j++) {
				if (j == col) {
					sb.append("Q");
				} else {
					sb.append(".");
				}
			}
			res.add(sb.toString());
		}
		return res;
	}

	public static void main(String[] args) {
		List<List<String>> lists = new Solution51().solveNQueens(5);
		System.out.println(lists);
	}


}
