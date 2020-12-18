package Solutions;

import utils.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wxn
 * 2019/6/30 20:12
 *
 * 257. 二叉树的所有路径
 *
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 */


public class Solution257 {

	public List<String> binaryTreePaths(TreeNode root) {

		List<String> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		if (root.left == null && root.right == null) {
			res.add(String.valueOf(root.val));
			return res;
		}
		List<String> leftS = binaryTreePaths(root.left);
		List<String> rightS = binaryTreePaths(root.right);

		for (String left : leftS) {
			res.add(root.val+"->"+left);
		}

		for (String right : rightS) {
			res.add(root.val+"->"+right);
		}
		return res;

	}
}
