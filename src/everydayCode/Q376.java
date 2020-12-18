package everydayCode;

/**
 * Created by wxn
 * 2020/12/12 14:38
 */


public class Q376 {
	public int wiggleMaxLength(int[] nums) {

		int n = nums.length;
		if (n<2){
			return n;
		}
		int up = 1;
		int down = 1;
		for (int i = 1 ; i<n; i++){
			if (nums[i]>nums[i-1]){
				up = down+1;
			}else if (nums[i]<nums[i-1]){
				down = up+1;
			}
		}
		return Math.max(up, down);
	}
}
