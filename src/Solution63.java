/**
 * Created by wxn
 * 2019/7/15 10:53
 * <p>
 * 63. 不同路径 II
 * <p>
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * <p>
 * <p>
 * <p>
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * <p>
 * 说明：m 和 n 的值均不超过 100。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 */


public class Solution63 {

	//解法1 记忆搜索法
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {

		int row = obstacleGrid.length;
		if (row == 0) {
			return 0;
		}
		int col = obstacleGrid[0].length;
		Integer[][] mem = new Integer[row][col];

		return uniquePathsWithObstacles(obstacleGrid, 0, 0, mem);
	}

	//返回以(x,y)为起点的路径条数
	private int uniquePathsWithObstacles(int[][] obstacleGrid, int x, int y, Integer[][] mem) {
		if (mem[x][y] == null) {
			if (obstacleGrid[x][y] == 1) {
				mem[x][y] = 0;
			} else if (x == obstacleGrid.length - 1 && y == obstacleGrid[0].length - 1) {
				mem[x][y] = obstacleGrid[x][y] == 1 ? 0 : 1;
			} else if (x == obstacleGrid.length - 1) {
				mem[x][y] = uniquePathsWithObstacles(obstacleGrid, x, y + 1, mem);
			} else if (y == obstacleGrid[0].length - 1) {
				mem[x][y] = uniquePathsWithObstacles(obstacleGrid, x + 1, y, mem);
			} else {
				mem[x][y] = uniquePathsWithObstacles(obstacleGrid, x, y + 1, mem)
						+ uniquePathsWithObstacles(obstacleGrid, x + 1, y, mem);
			}
		}
		return mem[x][y];
	}

	//解法2 动态规划
	public int uniquePathsWithObstacles2(int[][] obstacleGrid) {

		int row = obstacleGrid.length;
		if (row == 0) {
			return 0;
		}
		int col = obstacleGrid[0].length;
		Integer[][] mem = new Integer[row][col];
		mem[row - 1][col - 1] = obstacleGrid[row - 1][col - 1] == 1 ? 0 : 1;
		for (int i = row - 1; i >= 0; i--) {
			for (int j = col-1 ; j>=0 ; j--){
				if (i == row - 1 && j == col - 1) {
					continue;
				}
				if (obstacleGrid[i][j]==1) {
					mem[i][j] = 0;
					continue;
				}
				if (i==row-1){
					mem[i][j] = mem[i][j+1];
				}else if (j==col-1){
					mem[i][j] = mem[i+1][j];
				}else {
					mem[i][j] = mem[i][j+1]+mem[i+1][j];
				}
			}
		}
		return mem[0][0];
	}

	public static void main(String[] args) {
		int[][] grid = {
				{0, 0, 0},
				{0, 1, 0},
				{0, 0, 0}
		};
		System.out.println(new Solution63().uniquePathsWithObstacles2(grid));
	}

}
