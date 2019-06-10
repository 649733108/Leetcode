package algorithm.sort;

import java.util.Arrays;

/**
 * Created by wxn
 * 2019/5/31 14:04
 * <p>
 * 归并排序
 */


public class MergeSort {

	public static void sort(int[] arr) {
		sort(arr, 0, arr.length-1);
	}

	private static void sort(int[] arr, int l, int r) {
		if (l >= r) {
			//如果只有一个元素,则结束递归
			return;
		}
		int mid = l + (r - l) / 2;
		sort(arr, l, mid);
		sort(arr, mid + 1, r);
		if (arr[mid] > arr[mid + 1]) {
			//如果第一个数组的最大值比第二个数组的最小值大的话,才需要进行合并
			//否则两个数组已经有序,不需要合并
			merge(arr, l, mid, r);
		}
	}

	private static void merge(int[] arr, int l, int mid, int r) {
		int[] temp = Arrays.copyOf(arr, arr.length);
		int i = l;
		int j = mid+1;
		for (int k = l; k <= r; k++) {
			if (i > mid) {
				arr[k] = temp[j];
				j++;
			} else if (j>r){
				arr[k] = temp[i];
				i++;
			}else if (temp[i]<=temp[j]){
				arr[k] = temp[i];
				i++;
			}else {
				arr[k] = temp[j];
				j++;
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = {7,3,7,34,1,5,3,6,8,1,4,6 };
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
