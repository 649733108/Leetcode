import java.util.ArrayList;
import java.util.List;

/**
 * Created by wxn
 * 2019/7/12 9:34
 *
 * 52. N皇后 II
 *
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 *
 *
 * 上图为 8 皇后问题的一种解法。
 *
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 *
 * 示例:
 *
 * 输入: 4
 * 输出: 2
 * 解释: 4 皇后问题存在如下两个不同的解法。
 * [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 *
 */


public class Solution52 {

	private int res;
	//col[n]表示第n列是否有棋子
	private boolean[] col;
	//dia1[n]表示第n个从右上到左下的对角线是否有棋子
	private boolean[] dia1;
	//dia2[n]表示第n个从左上到右下的对角线是否有棋子
	private boolean[] dia2;

	public int totalNQueens(int n) {

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
			res++;
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

}
