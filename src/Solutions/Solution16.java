package Solutions;
/*
 * Created by wxn
 * 2019/3/27 20:51
 */

import java.util.Arrays;

/**
 * 16.最接近的三数之和
 * <p>
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * <p>
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
public class Solution16 {

	//解法1 暴力法
	public int threeSumClosest(int[] nums, int target) {

		int sub = Integer.MAX_VALUE;//记录三数之和与target的差值的最小值
		int sum = 0;//记录三数之和
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					int temp = nums[i] + nums[j] + nums[k];
					if (Math.abs(temp - target) < sub) {
						sum = temp;
						sub = Math.abs(temp - target);
					}
				}

			}
		}
		return sum;
	}

	//解法2 对撞指针
	public int threeSumClosest2(int[] nums, int target) {

		Arrays.sort(nums);
		int sum = 0;
		int sub = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			int left = i+1 ;
			int right = nums.length-1;
			while (left<right){
				if (nums[i]+nums[left]+nums[right]==target){
					return target;
				}
				if (Math.abs(nums[i]+nums[left]+nums[right]-target)<sub){
					sum = nums[i]+nums[left]+nums[right];
					sub = Math.abs(sum-target);
				}
				if (nums[i]+nums[left]+nums[right]<target){
					left++;
				}else {
					right--;
				}
			}
		}
		return sum;
	}

	public static void main(String args[]) {
		System.out.println(new Solution16().threeSumClosest2(new int[]{-1, 2, 1, -4}, 1));
	}

}
