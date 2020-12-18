package Solutions;
/*
 * Created by wxn
 * 2019/3/30 18:40
 */


import java.util.TreeSet;

/**
 * 220. 存在重复元素 III
 * <p>
 * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,1], k = 3, t = 0
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: nums = [1,0,1,1], k = 1, t = 2
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出: false
 */
public class Solution220 {

	//暴力法
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length && j < i + k + 1; j++) {
				if (Math.abs((long) nums[i] - (long) nums[j]) <= t)
					return true;
			}
		}
		return false;
	}

	public static void main(String args[]) {
		System.out.println(new Solution220().containsNearbyAlmostDuplicate2(new int[]{-1, 2147483647}, 1, 2147483647));
	}

	//滑动窗口
	public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {

		TreeSet<Long> set = new TreeSet<>();

		for (int i = 0; i < nums.length; i++) {

			if (set.ceiling((long)nums[i] - t) != null && set.ceiling((long)nums[i] - t) <= (long)nums[i] + t)
				return true;
				set.add((long)nums[i]);
			if (set.size() == k + 1) {
				set.remove((long)nums[i - k]);
			}

		}
		return false;
	}

}
