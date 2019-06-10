package algorithm.sort;

import java.util.Arrays;

/**
 * Created by wxn
 * 2019/5/31 13:26
 * <p>
 * 快排
 */


public class QuickSort {

	public static void sort(int[] arr){
		sort(arr,0,arr.length-1);
	}

	private static void sort(int[] arr, int start, int end) {
		if (start>=end){
			return;
		}
		int p = partition(arr, start, end);
		sort(arr, start, p-1);
		sort(arr, p+1, end);
	}

	private static int partition(int[] arr, int start, int end) {
		int pivot = arr[start];
		int left = start + 1;
		int right = end;

		while (left <= right) {
			while (left <= end && arr[left] < pivot) {
				left++;
			}
			while (right >= start + 1 && arr[right] > pivot) {
				right--;
			}
			if (left > right) {
				break;
			}else {
				swap(arr, left, right);
				left++;
				right--;
			}
		}

		swap(arr, start, right);
		return right;

	}

	private static void swap(int[] arr, int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}

	public static void main(String[] args) {
		int[] arr = {5,4,3,2,1};
		QuickSort.sort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
