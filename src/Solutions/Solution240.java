package Solutions;

import java.util.Arrays;

/**
 * Created by wxn
 * 2021/10/25 10:57
 * <p>
 * 240. 搜索二维矩阵 II
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= n, m <= 300
 * -109 <= matrix[i][j] <= 109
 * 每行的所有元素从左到右升序排列
 * 每列的所有元素从上到下升序排列
 * -109 <= target <= 109
 */


public class Solution240 {

	//暴力法
	public boolean searchMatrix(int[][] matrix, int target) {

		for (int[] ints : matrix) {
			for (int anInt : ints) {
				if (anInt == target) {
					return true;
				}
			}
		}
		return false;
	}

	//二分查找
	public boolean searchMatrix2(int[][] matrix, int target) {

		return binarySearchMatrix(matrix, target, 0, matrix.length - 1);
	}

	//二分查找矩阵，start/end代表行号
	private boolean binarySearchMatrix(int[][] matrix, int target, int start, int end) {
		if (start > end) {
			return false;
		}
		int colNum = matrix[start].length;
		if (target > matrix[end][colNum - 1]) {
			return false;
		} else if (target < matrix[start][0]) {
			return false;
		}
		int midRowNum = start + ((end - start) >> 1);
		if (target > matrix[midRowNum][colNum - 1]) {
			return binarySearchMatrix(matrix, target, midRowNum + 1, end);
		}
		if (target < matrix[midRowNum][0]) {
			return binarySearchMatrix(matrix, target, start, midRowNum - 1);
		}
		return binarySearch(matrix[midRowNum], target) || binarySearchMatrix(matrix, target, midRowNum + 1, end) ||
		binarySearchMatrix(matrix, target, start, midRowNum - 1);
	}

	public boolean binarySearch(int[] nums, int target) {
		return binarySearch(nums, target, 0, nums.length - 1);
	}

	public boolean binarySearch(int[] nums, int target, int start, int end) {
		if (start > end) {
			return false;
		}
		int mid = start + ((end - start) >> 1);
		if (nums[mid] == target) {
			return true;
		}
		if (target < nums[mid]) {
			return binarySearch(nums, target, start, mid - 1);
		}
		return binarySearch(nums, target, mid + 1, end);
	}

	//从右上角开始查找
	public boolean searchMatrix3(int[][] matrix, int target) {
		int m = matrix.length;
		int n = matrix[0].length;
		int x = 0;
		int y = n-1;
		while (x < m && y >= 0) {
			if (matrix[x][y] == target) {
				return true;
			} else if (matrix[x][y] > target) {
				y--;
			}else {
				x++;
			}
		}
		return false;
	}

	public static void main(String[] args) {

		Solution240 s = new Solution240();
		int[][] matrix = new int[][]{{1,1}};
		System.out.println(s.searchMatrix2(matrix, 0));
//		s.binarySearch(new int[]{3,6, 9, 16, 22},20,0,4);
	}
}
