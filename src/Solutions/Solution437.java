package Solutions;

import utils.tree.TreeNode;

/**
 * Created by wxn
 * 2019/7/2 15:04
 *
 * 437. 路径总和 III
 *
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 *
 * 找出路径和等于给定数值的路径总数。
 *
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 *
 * 示例：
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * 返回 3。和等于 8 的路径有:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 *
 */


public class Solution437 {

	//寻找以root为根节点的树中,和为sum的路径数目,路径不一定包括root
	public int pathSum(TreeNode root, int sum) {

		int res = 0;
		if (root == null) {
			return res;
		}
		res+=getPath(root,sum);
		res+=pathSum(root.left, sum);
		res+=pathSum(root.right, sum);
		return res;
	}

	//寻找以root为根节点的树中,和为sum的路径数目,路径包括root
	private int getPath(TreeNode root, int sum) {
		int res = 0;
		if (root == null) {
			return res;
		}
		if (root.val == sum) {
			res++;
		}
		res += getPath(root.left, sum - root.val);
		res += getPath(root.right, sum - root.val);
		return res;
	}
}
