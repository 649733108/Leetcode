
/*
 * Created by wxn
 * 2019/3/25 23:22
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 4sum
 * <p>
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：
 * <p>
 * 答案中不可以包含重复的四元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * <p>
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 */
public class Solution18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {

	List<List<Integer>> ret = new ArrayList<>();
	Arrays.sort(nums);
	for (int i = 0; i < nums.length; i++) {
	    if (i == 0 || nums[i] != nums[i - 1]) {
		for (int j = i + 1; j < nums.length; j++) {
		    if (j == i + 1 || nums[j] != nums[j - 1]) {
			int left = j + 1;
			int right = nums.length - 1;
			int sum = target - nums[i] - nums[j];
			while (left < right) {
			    if (nums[left] + nums[right] == sum) {
				ret.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
				while (left < right && nums[left + 1] == nums[left]) {
				    left++;
				}
				while (left < right && nums[right - 1] == nums[right]) {
				    right--;
				}
				left++;
				right--;
			    } else if (nums[left] + nums[right] < sum) {
				left++;
			    } else {
				right--;
			    }
			}
		    }
		}
	    }

	}
	return ret;
    }
}
