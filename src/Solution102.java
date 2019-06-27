import javafx.util.Pair;
import utils.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by wxn
 * 2019/6/27 15:34
 *
 * 102. 二叉树的层次遍历
 *
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */


public class Solution102 {

	public List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> res = new ArrayList<>();

		if (root == null) {
			return res;
		}

		Queue<Pair<TreeNode,Integer>> queue = new LinkedList<>();

		queue.add(new Pair<>(root, 0));

		while (!queue.isEmpty()) {
			TreeNode node = queue.peek().getKey();
			int level = queue.peek().getValue();
			queue.poll();

			if(level==res.size()){
				res.add(new ArrayList<>());
			}

			res.get(level).add(node.val);

			if (node.left != null) {
				queue.add(new Pair<>(node.left, level+1));
			}
			if (node.right != null) {
				queue.add(new Pair<>(node.right, level + 1));
			}
		}

		return res;

	}
}
