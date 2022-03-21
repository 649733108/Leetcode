package jianzhioffer;

import static utils.TestUtil.*;

/**
 * Created by wxn
 * 2021/9/7 20:23
 *
 * 剑指 Offer 51. 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [7,5,6,4]
 * 输出: 5
 *
 *
 * 限制：
 *
 * 0 <= 数组长度 <= 50000
 */


public class Offer51 {

	//暴力解法
	public int reversePairs(int[] nums) {
		int res = 0;
		for (int i = 0; i < nums.length-1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] > nums[j]) {
					res++;
				}
			}
		}
		return res;
	}

	//归并排序改写
	public int reversePairs2(int[] nums) {
		int res = 0;
		res = reversePairs2(nums,0,nums.length-1);
		return res;
	}

	private int reversePairs2(int[] nums, int l, int r) {

		if (l >= r) {
			return 0;
		}
		int mid = l + ((r-l)>>1);
		return reversePairs2(nums,l,mid) + reversePairs2(nums,mid+1,r) + merge(nums,l,mid,r);
	}

	private int merge(int[] nums, int l, int mid, int r) {
		int p1 = l;
		int p2 = mid+1;
		int[] help = new int[r - l + 1];
		int res = 0;
		for (int i = 0; i < r - l + 1; i++) {
			if (p1 <= mid && p2 <= r) {
				if (nums[p1]>nums[p2]){
					res+=mid-p1+1;
					help[i] = nums[p2++];
				}else{
					help[i] = nums[p1++];
				}
			} else if (p1 > mid) {
				help[i] = nums[p2++];
			}else {
				help[i] = nums[p1++];
			}
		}
		for (int i = 0; i < r - l + 1; i++) {
			nums[l+i] = help[i];
		}

		return res;

	}

	public static void main(String[] args) {
		for (int i = 0; i < 500000; i++) {
			int[] arr = generateRandomArray(100, 100);
			int[] arr2 = copyArr(arr);
			Offer51 o = new Offer51();
			int res1 = o.reversePairs(arr);
			int res2 = o.reversePairs2(arr2);
			if (res1 != res2) {
				System.out.println("error!");
				printArr(arr);
				return;
			}
		}
		System.out.println("Success");

//		int[] arr = {1,0};
//		Offer51 o = new Offer51();
//		System.out.println(o.reversePairs2(arr));
	}


}
