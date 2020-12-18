package Solutions;

/**
 * Created by wxn
 * 2019/7/15 15:05
 *
 * 213. 打家劫舍 II
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 示例 1:
 *
 * 输入: [2,3,2]
 * 输出: 3
 * 解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 示例 2:
 *
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 *
 */


public class Solution213 {

	//通过不偷第一家或最后一家的方法把环断开
	//动态规划
	public int rob(int[] nums) {

		int n = nums.length;
		if (n==0)
			return 0;
		if (n==1)
			return nums[0];
		if (n==2)
			return Math.max(nums[0], nums[1]);
		return Math.max(rob(nums,0,n-2),rob(nums,1,n-1));
	}

	private int rob(int[] nums, int start, int end) {
		int n = end-start+1;
		//mem[x]表示从[x,end]中偷取的最大值
		int[] mem = new int[nums.length];
		mem[end] = nums[end];
		for (int i = end - 1; i >= start; i--) {
			mem[i] = Math.max(mem[i + 1], nums[i] + (i+2<=end?mem[i + 2]:0));
		}
		return mem[start];
	}

	public static void main(String[] args) {
		System.out.println(new Solution213().rob(new int[]{2,3,2}));
	}

}
