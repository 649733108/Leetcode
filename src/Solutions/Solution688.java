package Solutions;

/**
 * Created by wxn
 * 2022/2/17 10:58
 * <p>
 * 688. 骑士在棋盘上的概率
 * 在一个 n x n 的国际象棋棋盘上，一个骑士从单元格 (row, column) 开始，并尝试进行 k 次移动。行和列是 从 0 开始 的，所以左上单元格是 (0,0) ，右下单元格是 (n - 1, n - 1) 。
 * <p>
 * 象棋骑士有8种可能的走法，如下图所示。每次移动在基本方向上是两个单元格，然后在正交方向上是一个单元格。
 * <p>
 * <p>
 * <p>
 * 每次骑士要移动时，它都会随机从8种可能的移动中选择一种(即使棋子会离开棋盘)，然后移动到那里。
 * <p>
 * 骑士继续移动，直到它走了 k 步或离开了棋盘。
 * <p>
 * 返回 骑士在棋盘停止移动后仍留在棋盘上的概率 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: n = 3, k = 2, row = 0, column = 0
 * 输出: 0.0625
 * 解释: 有两步(到(1,2)，(2,1))可以让骑士留在棋盘上。
 * 在每一个位置上，也有两种移动可以让骑士留在棋盘上。
 * 骑士留在棋盘上的总概率是0.0625。
 * 示例 2：
 * <p>
 * 输入: n = 1, k = 0, row = 0, column = 0
 * 输出: 1.00000
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= n <= 25
 * 0 <= k <= 100
 * 0 <= row, column <= n
 */


public class Solution688 {

	int[][] d = {
			{-2, 1},
			{-2, -1},
			{2, 1},
			{2, -1},
			{1, 2},
			{1, -2},
			{-1, 2},
			{-1, -2}
	};

	public double knightProbability(int n, int k, int row, int column) {

		/*
		 * 定义dp[step][i][j]表示从(i,j)出发行走step步后仍然留在棋盘上的概率
		 * 若(i,j)不在棋盘上，则dp=0
		 * 若step=0.则dp=1
		 * dp[step][i][j] = 1/8 sum（dp[step-1][i+dx][j+dy]）,其中dx、dy为棋子运动的偏移量
		 */
		float dp[][][] = new float[k+1][n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				dp[0][i][j] = 1;
			}
		}
		for (int step = 1; step <= k; step++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					for (int[]dir: d) {
						int newRow = i+dir[0];
						int newCol = j+dir[1];
						if (newRow >= n || newRow < 0 || newCol >= n || newCol < 0) {
							continue;
						}else {
							dp[step][i][j] += dp[step-1][newRow][newCol]/8;
						}
					}
				}
			}
		}
		return dp[k][row][column];

	}
}
