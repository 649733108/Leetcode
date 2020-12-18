package Solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wxn
 * 2019/7/9 16:45
 *
 * 90. 子集 II
 *
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 *
 */


public class Solution90 {

	boolean[] isVisited;

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		Arrays.sort(nums);
		isVisited = new boolean[nums.length];
		subsetsWithDup(nums,0,new ArrayList<>(),res);
		return res;
	}

	private void subsetsWithDup(int[] nums, int index, ArrayList<Integer> list, List<List<Integer>> res) {
		res.add(new ArrayList<>(list));
		for (int i = index; i < nums.length; i++) {
			if (!isVisited[i]){
				if (i>0 && nums[i]==nums[i-1]&&!isVisited[i-1]){
					continue;
				}else {
					list.add(nums[i]);
					isVisited[i] = true;
					subsetsWithDup(nums, i + 1, list, res);
					list.remove(list.size() - 1);
					isVisited[i] = false;
				}
			}
		}

	}

	public static void main(String[] args) {
		List<List<Integer>> lists = new Solution90().subsetsWithDup(new int[]{1,1, 2, 2});
		System.out.println(lists);
	}

}
