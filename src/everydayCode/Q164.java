package everydayCode;

import java.util.Arrays;

/**
 * Created by wxn
 * 2020/11/26 17:50
 */


public class Q164 {

	public int maximumGap(int[] nums) {

		if (nums.length < 2) {
			return 0;
		}
		Arrays.sort(nums);
		int max = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			max = Math.max(max, nums[i+1]-nums[i]);
		}
		return max;
	}

	public static void main(String[] args) {

	}
}
