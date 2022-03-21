package Solutions;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by wxn
 * 2021/10/20 20:28
 *
 * 453. 最小操作次数使数组元素相等
 * 给你一个长度为 n 的整数数组，每次操作将会使 n - 1 个元素增加 1 。返回让数组所有元素相等的最小操作次数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：3
 * 解释：
 * 只需要3次操作（注意每次操作会增加两个元素的值）：
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 * 示例 2：
 *
 * 输入：nums = [1,1,1]
 * 输出：0
 *
 *
 * 提示：
 *
 * n == nums.length
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * 答案保证符合 32-bit 整数
 */


public class Solution453 {

	//暴力超时
	public int minMoves(int[] nums) {
		Arrays.sort(nums);
		int ret = 0;
		while (nums[0] != nums[nums.length - 1]) {
			ret++;
			for (int i = 0; i < nums.length-1; i++) {
				nums[i]++;
			}
			Arrays.sort(nums);
		}
		return ret;
	}

	//给n-1个数+1相当于给1个数-1
	public int minMoves2(int[] nums) {
		int min = Arrays.stream(nums).min().getAsInt();
		int ret = 0;
		for (int num : nums) {
			ret += num-min;
		}
		return ret;
	}


	public static void main(String[] args) {
		Solution453 s = new Solution453();
		System.out.println(s.minMoves2(new int[]{1, 2, 3}));
	}
}
