import utils.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wxn
 * 2019/7/1 0:02
 *
 * 113. 路径总和 II
 *
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */


public class Solution113 {

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		if (root.left == null && root.right == null) {
			//root为叶子节点
			if (root.val==sum){
				List<Integer> list = new ArrayList<>();
				list.add(root.val);
				res.add(list);
				return res;
			}
		}
		//root不是叶子节点
		List<List<Integer>> leftList = pathSum(root.left, sum - root.val);
		List<List<Integer>> rightList = pathSum(root.right, sum - root.val);
		for (List<Integer> list : leftList) {
			list.add(0,root.val);
			res.add(list);
		}
		for (List<Integer> list : rightList) {
			list.add(0,root.val);
			res.add(list);
		}
		return res;
	}
}
