import java.util.ArrayList;
import java.util.List;

/**
 * Created by wxn
 * 2019/7/9 14:49
 *
 * 77. 组合.
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 */


public class Solution77 {

	public List<List<Integer>> combine(int n, int k) {

		List<List<Integer>> res = new ArrayList<>();
		if (n <= 0 || k <= 0) {
			return res;
		}
		generateCombine(n, k, 1, new ArrayList<>(), res);
		return res;
	}

	//求C(n,k) , 从start开始 , list中存放已经找到的元素
	private void generateCombine(int n, int k, int start, List<Integer> list, List<List<Integer>> res) {
		if (list.size() == k) {
			res.add(new ArrayList<>(list));
			return;
		}
		for (int i = start; i <= n-(k-list.size())+1; i++) {
			list.add(i);
			generateCombine(n, k, i + 1, list, res);
			list.remove(list.size()-1);
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> combine = new Solution77().combine(1, 1);
		System.out.println(combine);
	}

}
