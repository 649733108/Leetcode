import java.util.ArrayList;
import java.util.List;

/**
 * Created by wxn
 * 2019/7/9 15:34
 * <p>
 * 39. 组合总和
 * <p>
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */


public class Solution39 {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {

		List<List<Integer>> res = new ArrayList<>();
		if (candidates == null || candidates.length == 0) {
			return res;
		}
		combinationSum(candidates, target, 0, new ArrayList<>(), res);
		return res;
	}

//	private void combinationSum(int[] candidates, int target, int index, ArrayList<Integer> list, List<List<Integer>> res) {
//		int sum = 0;
//		for (Integer integer : list) {
//			sum += integer;
//		}
//		if (sum == target) {
//			res.add(new ArrayList<>(list));
//			return;
//		} else if (sum > target) {
//			return;
//		} else {
//			for (int i = index; i < candidates.length; i++) {
//				list.add(candidates[i]);
//				combinationSum(candidates, target, i, list, res);
//				list.remove(list.size() - 1);
//			}
//		}
//	}

	//优化后不用求sum
	private void combinationSum(int[] candidates, int target, int index, ArrayList<Integer> list, List<List<Integer>> res) {
		if (target < 0) {
			return;
		} else if (target == 0) {
			res.add(new ArrayList<>(list));
			return;
		} else {
			for (int i = index; i < candidates.length; i++) {
				list.add(candidates[i]);
				combinationSum(candidates, target-candidates[i], i, list, res);
				list.remove(list.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> lists = new Solution39().combinationSum(new int[]{2, 3, 5}, 8);
		System.out.println(lists);
	}

}
