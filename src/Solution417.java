import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wxn
 * 2019/7/11 13:33
 *
 * 417. 太平洋大西洋水流问题
 *
 * 给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。
 *
 * 规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。
 *
 * 请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。
 *
 *  
 *
 * 提示：
 *
 * 输出坐标的顺序不重要
 * m 和 n 都小于150
 *  
 *
 * 示例：
 *
 *  
 *
 * 给定下面的 5x5 矩阵:
 *
 *   太平洋 ~   ~   ~   ~   ~
 *        ~  1   2   2   3  (5) *
 *        ~  3   2   3  (4) (4) *
 *        ~  2   4  (5)  3   1  *
 *        ~ (6) (7)  1   4   5  *
 *        ~ (5)  1   1   2   4  *
 *           *   *   *   *   * 大西洋
 *
 * 返回:
 *
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (上图中带括号的单元).
 *
 */


public class Solution417 {

	int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	int m;
	int n;
	//太平洋
	boolean[][] pacific;
	//大西洋
	boolean[][] atlantic;

	/**
	 * 从四个边界开始遍历 只能能遍历到下一个元素 说明下一个元素可以流到该河流中
	 */
	public List<List<Integer>> pacificAtlantic(int[][] matrix) {

		List<List<Integer>> res = new ArrayList<>();
		m = matrix.length;
		if (m==0)
			return res;
		n = matrix[0].length;
		pacific = new boolean[m][n];
		atlantic = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			dfs(matrix,pacific,i,0);
			dfs(matrix,atlantic,i,n-1);
		}
		for (int i = 0; i < n; i++) {
			dfs(matrix,pacific,0,i);
			dfs(matrix,atlantic,m-1,i);
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (pacific[i][j]&&atlantic[i][j]){
					res.add(Arrays.asList(i,j));
				}
			}
		}
		return res;

	}

	private void dfs(int[][] matrix, boolean[][] reachable, int x, int y) {
		reachable[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int newX = x+d[i][0];
			int newY = y+d[i][1];
			if (inArea(newX, newY) && !reachable[newX][newY] && matrix[newX][newY] >= matrix[x][y]) {
				dfs(matrix, reachable, newX, newY);
			}
		}
	}

	private boolean inArea(int newX, int newY) {
		return newX >= 0 && newX < m && newY >= 0 && newY < n;
	}

	public static void main(String[] args) {
		int[][]matrix = {
				{1,2,2,3,5},
				{3,2,3,4,4},
				{2,4,5,3,1},
				{6,7,1,4,5},
				{5,1,1,2,4}
		};
		List<List<Integer>> lists = new Solution417().pacificAtlantic(matrix);
		System.out.println(lists);
	}


}
