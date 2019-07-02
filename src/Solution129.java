import utils.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wxn
 * 2019/7/1 0:04
 * <p>
 * 129. 求根到叶子节点数字之和
 * <p>
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 * <p>
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 * <p>
 * 计算从根到叶子节点生成的所有数字之和。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 1
 * / \
 * 2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 * 示例 2:
 * <p>
 * 输入: [4,9,0,5,1]
 * 4
 * / \
 * 9   0
 *  / \
 * 5   1
 * 输出: 1026
 * 解释:
 * 从根到叶子节点路径 4->9->5 代表数字 495.
 * 从根到叶子节点路径 4->9->1 代表数字 491.
 * 从根到叶子节点路径 4->0 代表数字 40.
 * 因此，数字总和 = 495 + 491 + 40 = 1026.
 */


public class Solution129 {

	public int sumNumbers(TreeNode root) {

		List<List<Integer>> numbers = getAllNumbers(root);
		int sum = 0;
		for (List<Integer> number : numbers) {
			int num = 0;
			for (Integer integer : number) {
				num = num*10+integer;
			}
			sum+=num;
		}

		return sum;
	}


	private List<List<Integer>> getAllNumbers(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		if (root.left == null && root.right == null) {
			//叶子节点
			List<Integer> list = new ArrayList<>();
			list.add(root.val);
			res.add(list);
			return res;
		}
		//非叶子节点
		List<List<Integer>> leftNumbers = getAllNumbers(root.left);
		List<List<Integer>> rightNumbers = getAllNumbers(root.right);
		for (List<Integer> leftNumber : leftNumbers) {
			leftNumber.add(0, root.val);
			res.add(leftNumber);
		}
		for (List<Integer> rightNumber : rightNumbers) {
			rightNumber.add(0, root.val);
			res.add(rightNumber);
		}
		return res;
	}


}
