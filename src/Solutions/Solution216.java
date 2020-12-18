package Solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wxn
 * 2019/7/9 16:23
 * <p>
 * 216. 组合总和 III
 * <p>
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * <p>
 * 说明：
 * <p>
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 * <p>
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */


public class Solution216 {

	public List<List<Integer>> combinationSum3(int k, int n) {

		List<List<Integer>> res = new ArrayList<>();
		if (k <= 0 || n <= 0) {
			return res;
		}
		combinationSum3(k, n, 1, new ArrayList<>(), res);
		return res;
	}

	private void combinationSum3(int k, int n, int start, ArrayList<Integer> list, List<List<Integer>> res) {
		if (n == 0) {
			if (list.size() == k) {
				res.add(new ArrayList<>(list));
			}
		} else if (n < 0 || list.size() >= k) {
		}
		else {
			for (int i = start; i <= 9; i++) {
				list.add(i);
				combinationSum3(k, n - i, i + 1, list, res);
				list.remove(list.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> lists = new Solution216().combinationSum3(3, 7);
		System.out.println(lists);
	}

}
