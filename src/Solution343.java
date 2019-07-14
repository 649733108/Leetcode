/**
 * Created by wxn
 * 2019/7/14 14:21
 *
 * 343. 整数拆分
 *
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 *
 */


public class Solution343 {


	//解法1 递归法 (超时)
	public int integerBreak(int n) {

		int res=0;
		if (n == 1) {
			return 1;
		}
		for (int i = 1; i<=n-1 ; i++){
			res = max(res, i * (n - i), i * integerBreak(n - i));
		}
		return res;
	}

	private int max(int a, int b, int c) {
		return Math.max(a, Math.max(b, c));
	}


	//解法2 记忆搜索法
	public int integerBreak2(int n) {
		//mem[i]保存将i至少分成两份的乘积最大值
		int[] mem = new int[n+1];
		mem[1] = 1;
		return integerBreak2(n,mem);
	}

	private int integerBreak2(int n, int[] mem) {
		if (mem[n]==0){
			int res = 0;
			for (int i = 1; i <= n - 1; i++) {
				res = max(res, i*(n-i), i*integerBreak2(n-i, mem));
				mem[n] = res;
			}
		}
		return mem[n];
	}

	//解法3 动态规划法
	public int integerBreak3(int n) {
		//mem[i]保存将i至少分成两份的乘积最大值
		int[] mem = new int[n+1];
		mem[1] = 1;
		for (int i = 2; i <= n; i++) {
			int res = 0;
			for (int j = 1; j <= i-1; j++) {
				res = max(res, j * (i - j), j * mem[i - j]);
			}
			mem[i] = res;
		}
		return mem[n];
	}

	public static void main(String args[]) {
		System.out.println(new Solution343().integerBreak3(10));
	}

}
