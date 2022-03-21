package Solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wxn
 * 2022/3/11 14:40
 * <p>
 * 2049. 统计最高分的节点数目
 * 给你一棵根节点为 0 的 二叉树 ，它总共有 n 个节点，节点编号为 0 到 n - 1 。同时给你一个下标从 0 开始的整数数组 parents 表示这棵树，其中 parents[i] 是节点 i 的父节点。由于节点 0 是根，所以 parents[0] == -1 。
 * <p>
 * 一个子树的 大小 为这个子树内节点的数目。每个节点都有一个与之关联的 分数 。求出某个节点分数的方法是，将这个节点和与它相连的边全部 删除 ，剩余部分是若干个 非空 子树，这个节点的 分数 为所有这些子树 大小的乘积 。
 * <p>
 * 请你返回有 最高得分 节点的 数目 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * example-1
 * <p>
 * 输入：parents = [-1,2,0,2,0]
 * 输出：3
 * 解释：
 * - 节点 0 的分数为：3 * 1 = 3
 * - 节点 1 的分数为：4 = 4
 * - 节点 2 的分数为：1 * 1 * 2 = 2
 * - 节点 3 的分数为：4 = 4
 * - 节点 4 的分数为：4 = 4
 * 最高得分为 4 ，有三个节点得分为 4 （分别是节点 1，3 和 4 ）。
 * 示例 2：
 * <p>
 * example-2
 * <p>
 * 输入：parents = [-1,2,0]
 * 输出：2
 * 解释：
 * - 节点 0 的分数为：2 = 2
 * - 节点 1 的分数为：2 = 2
 * - 节点 2 的分数为：1 * 1 = 1
 * 最高分数为 2 ，有两个节点分数为 2 （分别为节点 0 和 1 ）。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == parents.length
 * 2 <= n <= 105
 * parents[0] == -1
 * 对于 i != 0 ，有 0 <= parents[i] <= n - 1
 * parents 表示一棵二叉树。
 */


public class Solution2049 {

	List<Integer>[] children;
	long maxScore;
	int count;
	int n;

	public int countHighestScoreNodes(int[] parents) {
		n = parents.length;
		children = new List[n];
		maxScore = 1;
		count = 1;
		for (int i = 0; i < n; i++) {
			children[i] = new ArrayList<>();
		}
		for (int i = 0; i < n; i++) {
			int parent = parents[i];
			if (parent!=-1){
				children[parent].add(i);
			}
		}
		dfs(0);
		return count;
	}

	private int dfs(int node) {
		long score = 1;
		int sum = 1;  // 以node为根的子树的节点个数，最后返回这个sum
		for (Integer child : children[node]) {
			int t = dfs(child); // 子树的节点个数
			score *= t;
			sum += t;
		}
		if (node != 0) {
			score*=(n-sum);
		}
		if (score==maxScore){
			count++;
		}else if (score>maxScore){
			maxScore=score;
			count = 1;
		}
		return sum;
	}

	public static void main(String[] args) {
		Solution2049 s = new Solution2049();
		s.countHighestScoreNodes(new int[]{-1,2,0,2,0});
	}
}
