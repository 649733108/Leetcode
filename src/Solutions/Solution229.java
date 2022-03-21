package Solutions;

import java.util.*;

/**
 * Created by wxn
 * 2021/10/22 10:23
 * <p>
 * 229. 求众数 II
 * 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3,2,3]
 * 输出：[3]
 * 示例 2：
 * <p>
 * 输入：nums = [1]
 * 输出：[1]
 * 示例 3：
 * <p>
 * 输入：[1,1,1,3,3,2,2,2]
 * 输出：[1,2]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 5 * 104
 * -109 <= nums[i] <= 109
 * <p>
 * <p>
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。
 */


public class Solution229 {

	public List<Integer> majorityElement(int[] nums) {

		Set<Integer> set = new HashSet<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
			if (map.get(num) > nums.length / 3) {
				set.add(num);
			}
		}
		return new ArrayList<>(set);
	}

	//摩尔投票法
	public List<Integer> majorityElement2(int[] nums) {

		int element1 = 0;
		int element2 = 0;
		int vote1 = 0;
		int vote2 = 0;

		for (int num : nums) {
			if (vote1 > 0 && num == element1) {
				vote1++;
			} else if (vote2 > 0 && num == element2) {
				vote2++;
			} else if (vote1 == 0) {
				element1 = num;
				vote1 = 1;
			} else if (vote2 == 0) {
				element2 = num;
				vote2 = 1;
			} else {
				vote1--;
				vote2--;
			}
		}
		int cnt1 = 0;
		int cnt2 = 0;
		for (int num : nums) {
			if (vote1 > 0 && num == element1) {
				cnt1++;
			} else if (vote2 > 0 && num == element2) {
				cnt2++;
			}
		}
		List<Integer> ret = new ArrayList<>();
		if (cnt1 > nums.length / 3) {
			ret.add(element1);
		}
		if (cnt2 > nums.length / 3) {
			ret.add(element2);
		}
		return ret;
	}
}
