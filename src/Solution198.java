/**
 * Created by wxn
 * 2019/7/15 14:05
 * <p>
 * 198. 打家劫舍
 * <p>
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 * <p>
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 */


public class Solution198 {

	//解法1 记忆搜索法
	public int rob(int[] nums) {

		//mem[x]表示考虑从[x,n-1]范围内偷取
		Integer[] mem = new Integer[nums.length];
		return rob(nums, 0, mem);
	}

	private int rob(int[] nums, int x, Integer[] mem) {
		int n = nums.length;
		if (x >= n)
			return 0;
		if (mem[x] == null) {
			if (x == n - 1) {
				mem[x] = nums[x];
			} else if (x == n - 2) {
				mem[x] = Math.max(nums[n - 1], nums[n - 2]);
			} else {
				int res = 0;
				for (int i = x; i <= x + 1; i++) {
					res = Math.max(res, nums[i] + rob(nums, i + 2, mem));
				}
				mem[x] = res;
			}
		}
		return mem[x];
	}

	//解法2 动态规划
	public int rob2(int[] nums) {

		if (nums == null || nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];

		//mem[x]表示考虑从[x,n-1]范围内偷取
		int n = nums.length;
		Integer[] mem = new Integer[n];
		mem[n - 1] = nums[n - 1];

		for (int i = n - 2; i >= 0; i--) {
			int res = 0;
			for (int j = i; j <= i + 1; j++) {
				res = Math.max(res, nums[j] + (j + 2 < n ? mem[j + 2] : 0));
			}
			mem[i] = res;
		}

		return mem[0];
	}

	//解法3 记忆搜索法2
	public int rob3(int[] nums) {
		int n = nums.length;
		if (n == 0)
			return 0;
		//mem[x]表示考虑从[0,x]中偷取
		Integer[] mem = new Integer[n];
		return rob3(nums, n - 1, mem);
	}

	private int rob3(int[] nums, int x, Integer[] mem) {
		if (x < 0)
			return 0;
		if (mem[x] == null) {
			mem[x] = Math.max(rob3(nums, x - 1, mem), nums[x] + rob3(nums, x - 2, mem));
		}
		return mem[x];
	}

	//解法4 动态规划2
	public int rob4(int[] nums) {
		int n = nums.length;
		if (n == 0)
			return 0;
		//mem[x]表示考虑从[0,x]中偷取
		Integer[] mem = new Integer[n];
		mem[0] = nums[0];
		for (int i = 1; i < n; i++) {
			mem[i] = Math.max(mem[i - 1], nums[i] + (i - 2 >= 0 ? mem[i - 2] : 0));
		}
		return mem[n - 1];
	}

	public static void main(String[] args) {
		int[] nums = {2, 7, 9, 3, 1};
		System.out.println(new Solution198().rob4(nums));
	}

}
