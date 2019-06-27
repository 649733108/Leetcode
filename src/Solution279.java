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



}
