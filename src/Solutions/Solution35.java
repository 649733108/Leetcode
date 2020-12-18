package Solutions;

/**
 * Created by wxn
 * 2019/6/19 9:28
 *
 * 35. 搜索插入位置
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 */


public class Solution35 {

	public int searchInsert(int[] nums, int target) {

		return searchInsert(nums,target,0,nums.length-1);
	}

	private int searchInsert(int[] nums, int target, int left, int right) {

		if (left > right) {
			return left;
		}
		if (left == right) {
			if (nums[left]==target){
				return left;
			} else if (nums[left] < target) {
				return left+1;
			}else {//nums[left] > target
				return left;
			}
		}
		int mid = left+(right-left)/2;
		if (nums[mid] == target) {
			return mid;
		} else if (nums[mid] < target) {
			return searchInsert(nums, target, mid+1 , right);
		}else {//nums[mid] > target
			return searchInsert(nums, target, left, mid-1);
		}
	}

	public static void main(String[] args) {
		int[] nums = {1, 3};
		System.out.println(new Solution35().searchInsert(nums, 4));
	}

}
