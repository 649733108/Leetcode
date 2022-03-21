package Solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by wxn
 * 2021/10/26 10:42
 *
 * 496. 下一个更大元素 I
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
 *
 * 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
 *
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 *     对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
 *     对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
 *     对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 * 示例 2:
 *
 * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出: [3,-1]
 * 解释:
 *     对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
 *     对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 *
 *
 * 提示：
 *
 * 1 <= nums1.length <= nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 104
 * nums1和nums2中所有整数 互不相同
 * nums1 中的所有整数同样出现在 nums2 中
 */


public class Solution496 {

	//暴力
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {

		int[] ret = new int[nums1.length];
		for (int i = 0; i<nums1.length;i++) {
			int n1 = nums1[i];
			boolean hasFindN1 = false;
			for (int n2 : nums2) {
				if (!hasFindN1 && n2==n1) {
					hasFindN1=true;
				}else if (hasFindN1 && n2>n1){
					ret[i] = n2;
					break;
				}
			}
			if (ret[i] <= n1) {
				ret[i] = -1;
			}
		}
		return ret;
	}

	//单调栈
	public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
		int[] ret = new int[nums1.length];
		Stack<Integer> s = new Stack<>();
		Map<Integer,Integer> map = new HashMap<>();
		for (int i = nums2.length - 1; i >= 0; i--) {
			while (!s.isEmpty() && s.peek() < nums2[i]) {
				s.pop();
			}
			map.put(nums2[i],s.isEmpty()?-1:s.peek());
			s.push(nums2[i]);
		}
		for (int i = 0; i < nums1.length; i++) {
			ret[i] = map.getOrDefault(nums1[i],-1);
		}
		return ret;
	}
}
