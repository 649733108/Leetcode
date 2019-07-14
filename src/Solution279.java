import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wxn
 * 2019/6/27 16:49
 *
 * 279.完全平方数
 *
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 示例 1:
 *
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 *
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 */


public class Solution279 {

	//解法1 BFS
	public int numSquares(int n) {

		Queue<Pair<Integer,Integer>>queue = new LinkedList<>();
		boolean[] visited = new boolean[n+1];


		//表示经过0步可以到达n
		queue.add(new Pair<>(n, 0));

		while (!queue.isEmpty()) {
			Pair<Integer, Integer> pair = queue.poll();
			int num = pair.getKey();
			int step = pair.getValue();

			for (int i = 1; ; i++) {
				int a = num-i*i;
				if (a==0)
					return step+1;
				if (a<0)
					break;
				if (!visited[a]){
					queue.add(new Pair<>(a, step + 1));
					visited[a] = true;
				}
			}
		}
		return 0;
	}

	//解法2 记忆搜索法
	public int numSquares2(int n) {
		//mem[i]表示组成i的平方数的个数
		int[] mem = new int[n+1];
		return numSquares2(n,mem);
	}

	private int numSquares2(int n, int[] mem) {
		if (n==0)
			return 0;
		if (n==1)
			return 1;
		if (mem[n]==0){
			int min = Integer.MAX_VALUE;
			for (int i = 1;n-i*i>=0 ;i++){
				min = Math.min(min, numSquares2(n-i*i, mem)+1);
			}
			mem[n] = min;
		}
		return mem[n];
	}

	//解法3 动态规划
	public int numSquares3(int n){
		//mem[i]表示组成i的平方数的个数
		int[] mem = new int[n+1];
		mem[0] = 0;
		mem[1] = 1;
		for (int i = 2; i <= n; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 1; i - j * j >= 0; j++) {
				min = Math.min(min, mem[i-j*j]+1);
			}
			mem[i] = min;
		}
		return mem[n];
	}

	public static void main(String args[]) {
		System.out.println(new Solution279().numSquares3(12));
	}


}
