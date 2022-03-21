package jianzhioffer;

/**
 * Created by wxn
 * 2021/10/14 19:04
 * <p>
 * 剑指 Offer II 069. 山峰数组的顶部
 * 符合下列属性的数组 arr 称为 山峰数组（山脉数组） ：
 * <p>
 * arr.length >= 3
 * 存在 i（0 < i < arr.length - 1）使得：
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * 给定由整数组成的山峰数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i ，即山峰顶部。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [0,1,0]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：arr = [1,3,5,4,2]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：arr = [0,10,5,2]
 * 输出：1
 * 示例 4：
 * <p>
 * 输入：arr = [3,4,5,1]
 * 输出：2
 * 示例 5：
 * <p>
 * 输入：arr = [24,69,100,99,79,78,67,36,26,19]
 * 输出：2
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= arr.length <= 104
 * 0 <= arr[i] <= 106
 * 题目数据保证 arr 是一个山脉数组
 * <p>
 * <p>
 * 进阶：很容易想到时间复杂度 O(n) 的解决方案，你可以设计一个 O(log(n)) 的解决方案吗？
 */


public class Offer69 {

	// 二分法
	public int peakIndexInMountainArray(int[] arr) {
		return peakIndexInMountainArray(arr, 0, arr.length - 1);
	}

	private int peakIndexInMountainArray(int[] arr, int l, int r) {
		int mid = l + ((r - l) >> 1);
		if (mid == 0) {
			if (arr[0]>arr[1]){
				return 0;
			}else {
				return peakIndexInMountainArray(arr,mid+1,r);
			}
		}else if (mid==arr.length-1){
			if (arr[mid] > arr[mid - 1]) {
				return mid;
			}else {
				return peakIndexInMountainArray(arr,l,mid-1);
			}
		}
		if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
			return mid;
		} else if (arr[mid] == arr[mid - 1] && arr[mid] == arr[mid + 1]) {
			int a = peakIndexInMountainArray(arr,l,mid-1);
			int b = peakIndexInMountainArray(arr,mid+1,r);
			if (a >= 0) {
				return a;
			}else {
				return b;
			}
		}else if (arr[mid-1]>arr[mid]){
			return peakIndexInMountainArray(arr, l, mid - 1);
		}else {
			return peakIndexInMountainArray(arr,mid+1,r);
		}
	}

	public static void main(String[] args) {
		Offer69 o = new Offer69();
		System.out.println(o.peakIndexInMountainArray(new int[]{24,69,100,99,79,78,67,36,26,19}));
	}
}
