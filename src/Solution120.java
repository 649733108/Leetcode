import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wxn
 * 2019/7/13 22:25
 *
 * 120. 三角形最小路径和
 *
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 说明：
 *
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 *
 */


public class Solution120 {

	//解法1 递归法 (超时)
	public int minimumTotal(List<List<Integer>> triangle) {


		return minimumTotal(triangle,0,0);
	}

	//起点为三角的第x行, 第y列
	private int minimumTotal(List<List<Integer>> triangle, int x, int y) {
		if (x==triangle.size()-1){
			return triangle.get(x).get(y);
		}else {
			return triangle.get(x).get(y) + Math.min(minimumTotal(triangle, x + 1, y), minimumTotal(triangle, x + 1, y + 1));
		}
	}

	//解法2 记忆搜索法
	public int minimumTotal2(List<List<Integer>> triangle){
		int height = triangle.size();
		Integer[][] mem = new Integer[height][triangle.get(height - 1).size()];
		for (int i = 0; i < triangle.get(height - 1).size(); i++) {
			mem[height-1][i] = triangle.get(height-1).get(i);
		}
		return minimumTotal2(triangle,mem,0,0);
	}

	private int minimumTotal2(List<List<Integer>> triangle, Integer[][] mem, int x, int y) {

		if (mem[x][y] == null) {
			mem[x][y] = triangle.get(x).get(y) + Math.min(minimumTotal2(triangle, mem, x + 1, y), minimumTotal2(triangle, mem, x + 1, y + 1));
		}
		return mem[x][y];
	}

	//解法3 动态规划
	public int minimumTotal3(List<List<Integer>> triangle){
		int height = triangle.size();
		Integer[][] mem = new Integer[height][triangle.get(height - 1).size()];
		for (int i = 0; i < triangle.get(height - 1).size(); i++) {
			mem[height-1][i] = triangle.get(height-1).get(i);
		}
		for (int i = height - 2; i >= 0; i--) {
			List<Integer> list = triangle.get(i);
			for (int j = 0; j < list.size(); j++) {
				mem[i][j] = list.get(j) + Math.min(mem[i+1][j],mem[i+1][j+1] );
			}
		}
		return mem[0][0];
	}

	public static void main(String args[]) {
		List<List<Integer>> triangle = new ArrayList<>();
		triangle.add(Arrays.asList(2));
		triangle.add(Arrays.asList(3, 4));
		triangle.add(Arrays.asList(6,5,9));
		triangle.add(Arrays.asList(4,4,8,0));
		new Solution120().minimumTotal2(triangle);
	}

}
