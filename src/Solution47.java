import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wxn
 * 2019/7/8 15:03
 *
 * 47. 全排列 II
 *
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 */


public class Solution47 {

	private List<List<Integer>> res;
	private boolean[] visited;

	//解法1 按照没有重复数字的方式进行全排序,最后给res去重
	public List<List<Integer>> permuteUnique(int[] nums) {

		if (nums == null || nums.length == 0) {
			return res;
		}
		res = new ArrayList<>();
		visited = new boolean[nums.length];
		generatePermute(nums, 0, new ArrayList<>());
		return res;

	}

	//p中含有index个数字
	private void generatePermute(int[] nums, int index, List<Integer> p) {

		if (index == nums.length) {
			if (!res.contains(p))
				res.add(new ArrayList<>(p));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (!visited[i]){
				p.add(nums[i]);
				visited[i] = true;
				generatePermute(nums, index+1, p);
				p.remove(p.size()-1);
				visited[i] = false;
			}
		}
	}

	/**
	 * 这道题是之前那道 Permutations 的延伸，由于输入数组有可能出现重复数字，
	 * 如果按照之前的算法运算，会有重复排列产生，我们要避免重复的产生，在递归
	 * 函数中要判断前面一个数和当前的数是否相等，如果相等，且其对应的visited
	 * 中的值为true，当前的数字才能使用，否则需要跳过，这样就不会产生重复排列了
	 */
	public List<List<Integer>> permuteUnique2(int[] nums) {

		if (nums == null || nums.length == 0) {
			return res;
		}
		res = new ArrayList<>();
		visited = new boolean[nums.length];
		Arrays.sort(nums);
		generatePermute2(nums, 0, new ArrayList<>());
		return res;

	}

	//p中含有index个数字
	private void generatePermute2(int[] nums, int index, List<Integer> p) {

		if (index == nums.length) {
			if (!res.contains(p))
				res.add(new ArrayList<>(p));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (!visited[i]){
				if (i>0 && nums[i]==nums[i-1] && !visited[i - 1]){
					continue;
				}
				p.add(nums[i]);
				visited[i] = true;
				generatePermute2(nums, index+1, p);
				p.remove(p.size()-1);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = new int[]{1,1,3};
		List<List<Integer>> permute = new Solution47().permuteUnique2(nums);
		System.out.println(permute);
	}
}
