package Solutions;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wxn
 * 2022/3/16 17:06
 * <p>
 * 2044. 统计按位或能得到最大值的子集数目
 * 给你一个整数数组 nums ，请你找出 nums 子集 按位或 可能得到的 最大值 ，并返回按位或能得到最大值的 不同非空子集的数目 。
 * <p>
 * 如果数组 a 可以由数组 b 删除一些元素（或不删除）得到，则认为数组 a 是数组 b 的一个 子集 。如果选中的元素下标位置不一样，则认为两个子集 不同 。
 * <p>
 * 对数组 a 执行 按位或 ，结果等于 a[0] OR a[1] OR ... OR a[a.length - 1]（下标从 0 开始）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,1]
 * 输出：2
 * 解释：子集按位或能得到的最大值是 3 。有 2 个子集按位或可以得到 3 ：
 * - [3]
 * - [3,1]
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,2]
 * 输出：7
 * 解释：[2,2,2] 的所有非空子集的按位或都可以得到 2 。总共有 23 - 1 = 7 个子集。
 * 示例 3：
 * <p>
 * 输入：nums = [3,2,1,5]
 * 输出：6
 * 解释：子集按位或可能的最大值是 7 。有 6 个子集按位或可以得到 7 ：
 * - [3,5]
 * - [3,1,5]
 * - [3,2,5]
 * - [3,2,1,5]
 * - [2,5]
 * - [2,1,5]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 16
 * 1 <= nums[i] <= 105
 */


public class Solution2044 {

	int max = Integer.MIN_VALUE;
	int count = 0;
	List<Integer> list;
	int sum = 0;

	public int countMaxOrSubsets(int[] nums) {
		list = new ArrayList<>();
		dfs(nums,0);
		return count;
	}

	private void dfs(int[] nums, int index) {
		if (index == nums.length) {
			return;
		}
		int originSum = sum;
		//使用nums[index]这个数
		list.add(nums[index]);
		sum = sum | nums[index];
		if (sum == max) {
			count++;
		} else if (sum > max) {
			max = sum;
			count = 1;
		}
		dfs(nums,index+1);

		//不使用nums[index]
		list.remove(list.size()-1);
		sum = originSum;
		dfs(nums,index+1);
	}

	public int countMaxOrSubsets2(int[] nums) {
		int maxOr = 0, cnt = 0;
		for (int i = 0; i < 1 << nums.length; i++) {
			int orVal = 0;
			for (int j = 0; j < nums.length; j++) {
				if (((i >> j) & 1) == 1) {
					orVal |= nums[j];
				}
			}
			if (orVal > maxOr) {
				maxOr = orVal;
				cnt = 1;
			} else if (orVal == maxOr) {
				cnt++;
			}
		}
		return cnt;
	}

	public static void main(String[] args) {


		Solution2044 s = new Solution2044();
		s.countMaxOrSubsets2(new int[]{3,1});
	}
}