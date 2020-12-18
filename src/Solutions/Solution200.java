package Solutions;

/**
 * Created by wxn
 * 2019/7/11 10:22
 * <p>
 * 200. 岛屿数量
 * <p>
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * <p>
 * 输出: 3
 */


public class Solution200 {

	int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	int m;
	int n;
	boolean[][] visited;

	public int numIslands(char[][] grid) {

		m = grid.length;
		if (m == 0)
			return 0;
		n = grid[0].length;
		visited = new boolean[m][n];

		int res = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j] && grid[i][j] == '1') {
					res++;
					dfs(grid, i, j);
				}
			}
		}

		return res;

	}

	private void dfs(char[][] grid, int x, int y) {
		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int newX = x + d[i][0];
			int newY = y + d[i][1];
			if (inArea(newX, newY) && !visited[newX][newY] && grid[newX][newY] == '1') {
				dfs(grid, newX, newY);
			}
		}
	}

	private boolean inArea(int newX, int newY) {
		return newX >= 0 && newX < m && newY >= 0 && newY < n;
	}
}
