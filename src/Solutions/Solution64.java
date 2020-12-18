package Solutions;

/**
 * Created by wxn
 * 2019/7/13 23:07
 *
 * 64. 最小路径和
 *
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 */


public class Solution64 {

	//解法1 递归法(超时)
	public int minPathSum(int[][] grid) {

		return minPathSum(grid,0,0);
	}

	//返回以(x,y)为起点的最短路径
	private int minPathSum(int[][] grid, int x, int y) {

		if (x == grid.length - 1 && y == grid[0].length - 1) {
			return grid[x][y];
		}
		if (x == grid.length - 1) {
			return grid[x][y] + minPathSum(grid,x,y+1);
		}
		if (y == grid[0].length - 1) {
			return grid[x][y] + minPathSum(grid, x + 1, y);
		}
		return grid[x][y]+Math.min(minPathSum(grid, x, y+1), minPathSum(grid, x + 1, y));
	}

	//解法2 记忆搜索法
	public int minPathSum2(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		Integer[][] mem = new Integer[row][col];
		mem[row -1][col -1] = grid[row-1][col-1];

		return minPathSum2(grid,mem,0,0);
	}

	private int minPathSum2(int[][] grid, Integer[][] mem, int x, int y) {
		if (mem[x][y] == null) {
			if (x==grid.length-1){
				mem[x][y] = grid[x][y] + minPathSum2(grid,mem,x,y+1);
			}else if (y==grid[0].length-1){
				mem[x][y] = grid[x][y] + minPathSum2(grid, mem, x + 1, y);
			}else {
				mem[x][y] = grid[x][y] + Math.min(minPathSum2(grid,mem,x,y+1), minPathSum2(grid, mem, x + 1, y));
			}
		}
		return mem[x][y];
	}

	//解法3 动态规划
	public int minPathSum3(int[][] grid){
		int row = grid.length;
		int col = grid[0].length;
		Integer[][] mem = new Integer[row][col];
		mem[row -1][col -1] = grid[row-1][col-1];
		//初始化右边界和下边界
		for (int i = col - 2; i >= 0; i--) {
			mem[row-1][i] = grid[row-1][i] +mem[row-1][i+1];
		}
		for (int i = row - 2; i >= 0; i--) {
			mem[i][col-1] = grid[i][col-1] + mem[i+1][col-1];
		}

		for (int i = row - 2; i >= 0; i--) {
			for (int j = col - 2; j >= 0; j--) {
				mem[i][j] = grid[i][j] + Math.min(mem[i + 1][j], mem[i][j + 1]);
			}
		}
		return mem[0][0];
	}

	public static void main(String args[]) {
		int[][] grid = {{1, 2, 5}, {3, 2, 1}};
		new Solution64().minPathSum3(grid);
	}

}
