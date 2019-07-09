import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wxn
 * 2019/7/9 15:59
 *
 * 40. 组合总和 II
 *
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 */


public class Solution40 {

	boolean[] isVisited;

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if (candidates == null || candidates.length == 0) {
			return res;
		}
		Arrays.sort(candidates);
		isVisited = new boolean[candidates.length];
		combinationSum2(candidates, target,0,new ArrayList<>(),res);
		return res;
	}

	private void combinationSum2(int[] candidates, int target, int index, ArrayList<Integer> list, List<List<Integer>> res) {
		if (target < 0) {
			return;
		} else if (target == 0) {
			res.add(new ArrayList<>(list));
			return;
		}else {
			for (int i = index; i < candidates.length; i++) {
				if (!isVisited[i]) {
					if (i>0 &&candidates[i]==candidates[i-1] && !isVisited[i-1]){
						continue;
					}else {
						list.add(candidates[i]);
						isVisited[i] = true;
						combinationSum2(candidates, target-candidates[i],i+1,list,res);
						list.remove(list.size() - 1);
						isVisited[i] = false;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> lists = new Solution40().combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
		System.out.println(lists);
	}

}
