package Solutions;

import javafx.util.Pair;
import utils.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by wxn
 * 2019/6/27 15:56
 *
 * 107. 二叉树的层次遍历 II
 *
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */


public class Solution107 {

	public List<List<Integer>> levelOrderBottom(TreeNode root) {

		List<List<Integer>> res = new ArrayList<>();
		if (root==null){
			return res;
		}

		Queue<Pair<TreeNode,Integer>> queue = new LinkedList<>();

		queue.add(new Pair<>(root, 0));

		while (!queue.isEmpty()) {
			TreeNode node = queue.peek().getKey();
			int level = queue.peek().getValue();
			queue.poll();

			if(level==res.size()){
				res.add(0,new ArrayList<>());
			}

			res.get(0).add(node.val);

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
