package Solutions;

import utils.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wxn
 * 2019/6/30 0:23
 *
 * 101. 对称二叉树
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * 说明:
 *
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 *
 */


public class Solution101 {

	//解法1 递归
	public boolean isSymmetric(TreeNode root) {

		return isMirror(root, root);

	}

	private boolean isMirror(TreeNode node1, TreeNode node2) {
		if (node1==null && node2==null)
			return true;
		else if (node1==null || node2==null)
			return false;
		else return node1.val == node2.val && isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
	}

	//解法2 迭代
	public boolean isSymmetric2(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode n1 = queue.poll();
			TreeNode n2 = queue.poll();
			if (n1 == null && n2 == null) {
				continue;
			}
			if (n1 == null || n2 == null || n1.val != n2.val) {
				return false;
			}
			queue.add(n1.left);
			queue.add(n2.right);
			queue.add(n1.right);
			queue.add(n2.left);
		}
		return true;
	}
}
