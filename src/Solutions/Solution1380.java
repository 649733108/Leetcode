package Solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wxn
 * 2022/2/15 11:02
 *
 * 1380. 矩阵中的幸运数
 * 给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。
 *
 * 幸运数是指矩阵中满足同时下列两个条件的元素：
 *
 * 在同一行的所有元素中最小
 * 在同一列的所有元素中最大
 *
 *
 * 示例 1：
 *
 * 输入：matrix = [[3,7,8],[9,11,13],[15,16,17]]
 * 输出：[15]
 * 解释：15 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
 * 示例 2：
 *
 * 输入：matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
 * 输出：[12]
 * 解释：12 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
 * 示例 3：
 *
 * 输入：matrix = [[7,8],[1,2]]
 * 输出：[7]
 *
 *
 * 提示：
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= n, m <= 50
 * 1 <= matrix[i][j] <= 10^5
 * 矩阵中的所有元素都是不同的
 */


public class Solution1380 {

	public List<Integer> luckyNumbers (int[][] matrix) {

		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				boolean isMinInLine = true;
				boolean isMaxInCol = true;
				for (int k = 0; k < matrix[0].length; k++) {
					if (matrix[i][j] > matrix[i][k]) {
						isMinInLine = false;
						break;
					}
				}
				for (int k = 0; k < matrix.length; k++) {
					if (matrix[i][j]<matrix[k][j]){
						isMaxInCol = false;
						break;
					}
				}
				if (isMaxInCol && isMinInLine) {
					res.add(matrix[i][j]);
				}
			}
		}
		return res;
	}


	public static void main(String[] args) {
		Solution1380 s = new Solution1380();
		int[][] matrix = new int[][]{
				{1,10,4,2},
				{9,3,8,7},
				{15,16,17,12}
		};
		System.out.println(s.luckyNumbers(matrix));
	}
}
