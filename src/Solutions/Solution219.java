package Solutions;
/*
 * Created by wxn
 * 2019/3/30 17:55
 */


import java.util.HashSet;
import java.util.Set;

/**
 * 219. 存在重复元素 II
 * <p>
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 */
public class Solution219 {

	//解法1 暴力法
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < i + k + 1 && j < nums.length; j++) {
				if (nums[i] == nums[j])
					return true;
			}
		}
		return false;
	}

	//解法2 滑动窗口+查找表
	public boolean containsNearbyDuplicate2(int[] nums, int k) {
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < nums.length && i < k + 1; i++) {
			if (set.contains(nums[i])) {
				return true;
			} else {
				set.add(nums[i]);
			}
		}

		int left = 0 ;
		int right = k+1;
		while (right<nums.length){
			set.remove(nums[left++]);
			if (set.contains(nums[right]))
				return true;
			set.add(nums[right++]);
		}
		return false;
	}

	//解法3 解法2的优化
	public boolean containsNearbyDuplicate3(int[] nums, int k){
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i])) {
				return true;
			}
			set.add(nums[i]);
			if (set.size()==k+1){
				set.remove(nums[i-k]);
			}
		}
		return false;
	}

	public static void main(String args[]) {
		System.out.println(new Solution219().containsNearbyDuplicate3(new int[]{1, 2, 3, 1, 2, 3}, 2));
	}

}
