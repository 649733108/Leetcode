package Solutions;

import java.util.*;

import static utils.TestUtil.*;

/**
 * Created by wxn
 * 2021/9/2 16:16
 * <p>
 * <p>
 * 260. 只出现一次的数字 III
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 进阶：你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,1,3,2,5]
 * 输出：[3,5]
 * 解释：[5, 3] 也是有效的答案。
 * 示例 2：
 * <p>
 * 输入：nums = [-1,0]
 * 输出：[-1,0]
 * 示例 3：
 * <p>
 * 输入：nums = [0,1]
 * 输出：[1,0]
 * 提示：
 * <p>
 * 2 <= nums.length <= 3 * 104
 * -231 <= nums[i] <= 231 - 1
 * 除两个只出现一次的整数外，nums 中的其他数字都出现两次
 */


public class Solution260 {
	//方法1 使用map
	public int[] singleNumber(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int n : nums) {
			if (map.containsKey(n)) {
				map.put(n, 2);
			} else {
				map.put(n, 1);
			}
		}
		int[] ret = new int[2];
		int index = 0;
		for (Integer integer : map.keySet()) {
			if (map.get(integer) == 1) {
				ret[index++] = integer;
			}
		}
		return ret;
	}

	//方法2 使用set
	public int[] singleNumber2(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int n : nums) {
			if (set.contains(n)) {
				set.remove(n);
			} else {
				set.add(n);
			}
		}
		int[] ret = new int[2];
		int index = 0;
		for (int n : set) {
			ret[index++] = n;
		}
		return ret;
	}

	//方法3 对数组排序
	public int[] singleNumber3(int[] nums) {
		Arrays.sort(nums);
		int[] ret = new int[2];
		int index = 0;
		for (int i = 0; i < nums.length - 1; ) {
			if (nums[i] != nums[i + 1]) {
				ret[index++] = nums[i];
				i++;
			} else {
				i += 2;
			}
		}
		if (index != 2) {
			ret[index] = nums[nums.length - 1];
		}
		return ret;
	}

	//方法4 位运算
	public int[] singleNumber4(int[] nums) {
		int eor = 0;
		//最终得到a^b
		for (int n : nums) {
			eor ^= n;
		}
		//得到eor最右边=1的那一位
		int lastOne = eor & (~eor+1);

		int eor2 = 0;
		for (int n : nums) {
			if ((lastOne & n) != 0) {
				eor2^=n;
			}
		}

		int[] ret = new int[2];
		ret[0] = eor2;
		ret[1] = eor2^eor;

		return ret;
	}

	private int[] generateRandomArray(int maxSize,int maxValue){
		if (maxSize%2==1){
			maxSize++;
		}
		Set<Integer> set = new HashSet<>();
		int[] ret = new int[maxSize];
		for (int i = 0; i < ret.length-1;) {
			ret[i] = (int) ((maxValue + 1) * Math.random());
			ret[i+1] = ret[i];
			set.add(ret[i]);
			i+=2;
		}
		while (true) {
			int a = (int) ((maxValue + 1) * Math.random());
			if (!set.contains(a)) {
				ret[ret.length-2] = a;
				set.add(a);
				break;
			}
		}
		while (true) {
			int a = (int) ((maxValue + 1) * Math.random());
			if (!set.contains(a)) {
				ret[ret.length-1] = a;
				set.add(a);
				break;
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		int round = 5000000;
		int maxSize = 10;
		int maxValue = 1000;
		Solution260 solution260 = new Solution260();
		for (int i = 0; i < round; i++) {
			int[] arr = solution260.generateRandomArray(maxSize,maxValue);
			int[] arr2 = copyArr(arr);
			int[] ret1 = solution260.singleNumber(arr);
			int[] ret2 = solution260.singleNumber4(arr2);
			if (!isEqualUnOrder(ret1, ret2)) {
				System.out.println("Fucking Error!");
				printArr(arr);
				printArr(ret1);
				printArr(ret2);
				return;
			}
		}
		System.out.println("Success!");
	}

}
