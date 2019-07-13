/**
 * Created by wxn
 * 2019/7/13 22:13
 *
 * 70. 爬楼梯
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 */


public class Solution70 {
	int[] mem;

	//解法1 递归法 (超时)
	public int climbStairs(int n) {

		if (n==0 || n==1){
			return 1;
		}
		return climbStairs(n-1)+climbStairs(n-2);
	}

	//解法2 记忆搜索法
	public int climbStairs2(int n) {
		mem = new int[n+1];
		mem[0] = 1;
		mem[1] = 1;
		return getStairs(n);
	}

	private int getStairs(int n) {
		if (mem[n]==0){
			mem[n] = getStairs(n-1)+getStairs(n-2);
		}
		return mem[n];
	}

	//解法3 动态规划
	public int climbStairs3(int n) {
		mem = new int[n+1];
		mem[0] = 1;
		mem[1] = 1;
		for (int i = 2 ; i<=n ; i++){
			mem[i] = mem[i-1]+mem[i-2];
		}
		return mem[n];
	}
}
