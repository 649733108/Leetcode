package utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wxn
 * 2021/9/2 19:45
 */


public class TestUtil {

	//生成随机数组，数组长度：[0,maxSize], 取值范围:[-maxValue,maxValue)
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int)((maxSize+1)*Math.random())];
		for (int i = 0; i < arr.length; i++) {
			//[0,maxValue-1] - [0,maxValue] = [-maxValue, maxValue-1]
			arr[i] = (int) (maxValue * Math.random()) - (int) ((maxValue + 1) * Math.random());
		}
		return arr;
	}

	public static void printArr(int[] arr) {
		if (arr==null)
			return;
		for (int i : arr) {
			System.out.print(i);
			System.out.print(" ");
		}
		System.out.println();
	}

	public static int[] copyArr(int[] arr) {
		return Arrays.copyOf(arr, arr.length);
	}

	public static boolean isEqual(int[] arr1, int[] arr2) {
		if (arr1 == null && arr2 != null || arr1 != null && arr2 == null) {
			return false;
		}
		if (arr1 == null && arr2 == null) {
			return true;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}

	public static boolean isEqualUnOrder(int[] arr1, int[] arr2) {
		if (arr1 == null && arr2 != null || arr1 != null && arr2 == null) {
			return false;
		}
		if (arr1 == null && arr2 == null) {
			return true;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		Map<Integer,Integer> map1 = new HashMap<>();
		Map<Integer,Integer> map2 = new HashMap<>();
		for (int i = 0; i < arr1.length; i++) {
			map1.put(arr1[i],map1.getOrDefault(arr1[1],0)+1);
			map2.put(arr2[i],map2.getOrDefault(arr2[1],0)+1);
		}
		return map1.equals(map2);
	}

	public static void main(String[] args) {
		int round = 500000;
		for (int i = 0; i < round; i++) {
			int[] arr = generateRandomArray(10, 100);
			int[] arr2 = copyArr(arr);
			if (!isEqual(arr, arr2)) {
				System.out.println("fucking error!");
				return;
			}
		}
		System.out.println("Success!");
	}

}
