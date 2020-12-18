package Solutions;

/**
 * Created by wxn
 * 2019/6/11 15:08
 * <p>
 * 4. 寻找两个有序数组的中位数
 * <p>
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 */


public class Solution4 {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;
		int left = (m + n + 1) / 2;
		int right = (m + n + 2) / 2;
		return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;
	}

	/**
	 * 在nums1数组和nums2数组中寻找第k个数
	 */
	private int findKth(int[] nums1, int i, int[] nums2, int j, int k) {
		if (i >= nums1.length)
			return nums2[j + k - 1];
		if (j >= nums2.length)
			return nums1[i + k - 1];
		if (k == 1)
			return Math.min(nums1[i], nums2[j]);
		int midVal1;
		int midVal2;

		if (i + k / 2 - 1 < nums1.length) {
			midVal1 = nums1[i + k / 2 - 1];
		} else {
			midVal1 = Integer.MAX_VALUE;
		}

		if (j + k / 2 - 1 < nums2.length) {
			midVal2 = nums2[j + k / 2 - 1];
		} else {
			midVal2 = Integer.MAX_VALUE;
		}


		if (midVal1 < midVal2) {
			return findKth(nums1, i + k / 2, nums2, j, k - k / 2);
		} else {
			return findKth(nums1, i, nums2, j + k / 2, k - k / 2);
		}
	}
}
