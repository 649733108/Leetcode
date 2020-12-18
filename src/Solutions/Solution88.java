package Solutions;
/*
 * Created by wxn
 * 2018/12/24 23:52
 */

/**
 * 88. 合并两个有序数组
 * <p>
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 */
public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

	if (n == 0) {
	    return;
	}
	if (m == 0) {
	    System.arraycopy(nums2, 0, nums1, 0, n);
	    return;
	}
	if (nums2[0] >= nums1[m - 1]) {        //nums2全部大于nums1
	    for (int i = 0; i < n; i++) {
		nums1[m + i] = nums2[i];
	    }
	} else if (nums2[n - 1] < nums1[0]) {        //nums2全部小于nums1
	    for (int i = 0; i < m; i++) {
		nums1[i + m] = nums1[i];
	    }
	    for (int i = 0; i < n; i++) {
		nums1[i] = nums2[i];
	    }
	} else {
	    int[] nums = new int[m + n];
	    int i = 0;
	    int j = 0;
	    for (int k = 0; k < nums.length; k++) {
		if (i >= m) {
		    nums[k] = nums2[j];
		    j++;
		} else if (j >= n) {
		    nums[k] = nums1[i];
		    i++;
		} else if (nums1[i] <= nums2[j]) {
		    nums[k] = nums1[i];
		    i++;
		} else {
		    nums[k] = nums2[j];
		    j++;
		}
	    }
	    System.arraycopy(nums, 0, nums1, 0, nums.length);
	}
    }

    //解法2 把nums1的元素全部放到数组的最后面,就不需要额外的空间
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
	for (int i = n + m - 1; i >= n; i--)
	    nums1[i] = nums1[i - n];

	int i = n;  // pointer for nums1 [n, n+m)
	int j = 0;  // pointer for nums2 [0, n)
	int k = 0;  // pointer merged nums1 [0, n+m)
	while (k < n + m) {
	    if (i >= n + m)
		nums1[k++] = nums2[j++];
	    else if (j >= n)
		nums1[k++] = nums1[i++];
	    else if (nums1[i] < nums2[j])
		nums1[k++] = nums1[i++];
	    else
		nums1[k++] = nums2[j++];
	}
    }

    public static void main(String args[]) {
	int[] nums1 = {1, 2, 3, 0, 0, 0};
	int[] nums2 = {2, 5, 6};
	new Solution88().merge2(nums1,3,nums2,3);
    }

}
