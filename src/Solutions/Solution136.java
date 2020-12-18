package Solutions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by wxn
 * 2019/6/26 16:08
 *
 * 136. 只出现一次的数字
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */


public class Solution136 {

	//解法1  用集合
	public int singleNumber(int[] nums) {

		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i])){
				set.remove(nums[i]);
			}else {
				set.add(nums[i]);
			}
		}
		return set.iterator().next();
	}

	//解法2 对数组排序
	public int singleNumber2(int[] nums){
		Arrays.sort(nums);
		for (int i = 0; i < nums.length-1; ) {
			if (nums[i]!=nums[i+1]){
				return nums[i];
			}
			i+=2;
		}
		return nums[nums.length-1];
	}

	//解法3 异或操作
	public int singleNumber3(int[] nums) {
		int ret = nums[0];
		if (nums.length>1){
			for (int i = 1; i < nums.length; i++) {
				ret = ret^nums[i];
			}
		}
		return ret;
	}


	public static void main(String[] args) {
		int[] nums = {4,1,2,1,2};
		System.out.println(new Solution136().singleNumber3(nums));
	}

}
