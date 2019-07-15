/**
 * Created by wxn
 * 2019/7/15 10:28
 *
 * 62. 不同路径
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 *
 *
 *
 * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
 *
 * 说明：m 和 n 的值均不超过 100。
 *
 * 示例 1:
 *
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * 示例 2:
 *
 * 输入: m = 7, n = 3
 * 输出: 28
 *
 */


public class Solution62 {

	//解法1 递归法 (超时)
	public int uniquePaths(int m, int n) {

		if (m == 1 || n == 1) {
			return 1;
		}
		return uniquePaths(m-1, n)+uniquePaths(m, n-1);
	}

	//解法2 记忆搜索法
	public int uniquePaths2(int m, int n){
		int[][] mem = new int[n+1][m+1];
		return uniquePaths2(m, n,1,1,mem);
	}

	//从第x列, 第y行为起点的路径数量 (1 <= x <=m, 1 <= y <=n)
	private int uniquePaths2(int m, int n, int x, int y, int[][] mem) {
		if (mem[y][x] == 0) {
			if (y == n || x == m) {
				mem[y][x] = 1;
			}else {
				mem[y][x] = uniquePaths2(m, n, x + 1, y, mem) + uniquePaths2(m, n, x, y + 1, mem);
			}
		}
		return mem[y][x];
	}

	//解法3 动态规划
	public int uniquePaths3(int m, int n){
		int[][] mem = new int[n+1][m+1];
		for (int i = 1; i <= m; i++) {
			mem[n][i] =1;
		}
		for (int i = 1; i <= n; i++) {
			mem[i][m] = 1;
		}
		for (int i = n - 1; i >= 1; i--) {
			for (int j = m - 1; j >= 1; j--) {
				mem[i][j] = mem[i+1][j] + mem[i][j+1];
			}
		}
		return mem[1][1];
	}

	public static void main(String[] args) {
		int i = new Solution62().uniquePaths3(51, 9);
		System.out.println(i);
	}

}
