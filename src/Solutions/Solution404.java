package Solutions;

import utils.tree.TreeNode;

/**
 * Created by wxn
 * 2019/6/30 19:19
 * <p>
 * 404. 左叶子之和
 * <p>
 * 计算给定二叉树的所有左叶子之和。
 * <p>
 * 示例：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 */


public class Solution404 {

	int res = 0;

	public int sumOfLeftLeaves(TreeNode root) {

		if (root == null) {
			return res;
		}
		if (root.left != null && root.left.left == null && root.left.right == null) {
			res += root.left.val;
		} else if (root.left != null) {
			sumOfLeftLeaves(root.left);
		}
		sumOfLeftLeaves(root.right);


		return res;

	}
}
