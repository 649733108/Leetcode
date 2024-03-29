package Solutions;

/**
 * Created by wxn
 * 2022/2/14 14:16
 *
 * 540. 有序数组中的单一元素
 * 给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。
 *
 * 请你找出并返回只出现一次的那个数。
 *
 * 你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums =  [3,3,7,7,10,11,11]
 * 输出: 10
 *
 *
 * 提示:
 *
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 105
 */


public class Solution540 {

	public int singleNonDuplicate(int[] nums) {

		int l = 0;
		int r = nums.length-1;
		while (l<r){
			int mid = l + (r-l)/2;
			if (mid%2!=0){
				mid-=1;
			}
			if (nums[mid]==nums[mid+1]){
				l = mid+2;
			}else {
				r = mid;
			}
		}
		return nums[l];
	}

	public int singleNonDuplicate2(int[] nums) {

		int l = 0;
		int r = nums.length-1;
		while (l<r){
			int mid = l + (r-l)/2;
			if (nums[mid]==nums[mid^1]){
				l = mid+1;
			}else {
				r = mid;
			}
		}
		return nums[l];
	}

	public static void main(String[] args) {
		Solution540 s = new Solution540();
		System.out.println(s.singleNonDuplicate2(new int[]{3,3,7,7,10,11,11}));
	}

}
