import java.util.ArrayList;
import java.util.List;

/**
 * Created by wxn
 * 2019/7/9 16:39
 *
 * 78. 子集
 *
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 */


public class Solution78 {

	public List<List<Integer>> subsets(int[] nums) {

		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		subsets(nums,0,new ArrayList<>(),res);
		return res;
	}

	private void subsets(int[] nums, int index, ArrayList<Integer> list, List<List<Integer>> res) {
		res.add(new ArrayList<>(list));
		for (int i = index; i < nums.length; i++) {
			list.add(nums[i]);
			subsets(nums,i+1,list,res);
			list.remove(list.size()-1);
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> subsets = new Solution78().subsets(new int[]{1, 2, 3});
		System.out.println(subsets);
	}

}
