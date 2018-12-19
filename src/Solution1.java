
/*
 * Created by wxn
 * 2018/8/10 5:17
 */

import java.util.HashMap;

/**
 * 1. 两数之和
 *
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 *
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class Solution1 {

	public int[] twoSum(int[] nums, int target) {
//		int i = 0 , j = 1;
//		int[]res = new int[2];
//
//		for ( ; i<nums.length-1 ; i++){
//			for (j = i+1 ; j<nums.length ; j++){
//				if (nums[i] + nums[j] ==target){
//					res[0] = i;
//					res[1] = j;
//					break;
//				}
//			}
//		}
//		return res;

		HashMap<Integer,Integer> map = new HashMap<>();
		int[]res = new int[2];
		for (int i = 0 ; i<nums.length; i++){
			if (map.containsKey(target-nums[i]) && map.get(target-nums[i])!=i){
				res = new int[]{i,map.get(target-nums[i])};
				break;
			}
			map.put(nums[i], i);
		}

		return res;
	}


	public static void main(String args[]) {
		int[] nums = {3,3};
		int[]res = (new Solution1()).twoSum(nums,6);

		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}

}
