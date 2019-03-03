
/*
 * Created by wxn
 * 2019/3/3 22:23
 */

/**
 * 209.长度最小的子数组
 *
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 *
 * 示例:
 *
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 */
public class Solution209 {

    //解法1.暴力求解
    public int minSubArrayLen(int s, int[] nums) {

	int res = nums.length+1;

	for (int i = 0 ; i<nums.length ; i++){
	    for (int j = i ; j<nums.length; j++){
	        int sum = 0;
	        for (int k = i ; k<=j ; k++){
	            sum+=nums[k];
		}
	        if (sum>=s){
	            res = Math.min(res,j-i+1);
	            break;
		}
	    }
	}
	if (res!=nums.length+1){
	    return res;
	}else {
	    return 0;
	}
    }

    //解法2 优化暴力求解
    public int minSubArrayLen2(int s, int[] nums) {

	int res = nums.length+1;

	for (int i = 0 ; i<nums.length ; i++){
	    int sum = 0;
	    for (int j = i ; j<nums.length; j++){
		sum+=nums[j];
		if (sum>=s){
		    res = Math.min(res,j-i+1);
		    break;
		}
	    }
	}
	if (res!=nums.length+1){
	    return res;
	}else {
	    return 0;
	}
    }

    //解法3. 滑动窗口
    public int minSubArrayLen3(int s, int[] nums){
        int l = 0 ;
        int r = 0;
        int res = nums.length+1;
        int sum = 0;
        while (l<nums.length){
            if (r<nums.length&&sum<s){
                sum+=nums[r];
                r++;
	    }else if (sum>=s){
                res = Math.min(res,r-l);
                sum-=nums[l];
                l++;
	    }else {
                break;
	    }
	}
	if (res!=nums.length+1){
	    return res;
	}else {
	    return 0;
	}
    }

    public static void main(String[] args) {
	Solution209 solution209 = new Solution209();
	int[] nums = {2,3,1,2,4,3};
	int s = 7;
	System.out.println(solution209.minSubArrayLen3(s,nums));
    }

}
