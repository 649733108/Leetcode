import java.util.ArrayList;
import java.util.List;

/**
 * Created by wxn
 * 2019/7/8 14:13
 * <p>
 * 46. 全排列
 * <p>
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */


public class Solution46 {

	private List<List<Integer>> res;
	private boolean[] visited;

	public List<List<Integer>> permute(int[] nums) {

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

	public static void main(String[] args) {
		int[] nums = new int[]{1,2,3,4,5};
		List<List<Integer>> permute = new Solution46().permute(nums);
		System.out.println(permute);
	}

}
