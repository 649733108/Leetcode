import javafx.util.Pair;
import utils.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by wxn
 * 2019/6/27 16:13
 *
 * 199. 二叉树的右视图
 *
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 */


public class Solution199 {

	public List<Integer> rightSideView(TreeNode root) {

		List<Integer> res = new ArrayList<>();
		if (root==null)
			return res;

		Queue<Pair<TreeNode,Integer>> queue = new LinkedList<>();
		queue.add(new Pair<>(root, 0));

		while (!queue.isEmpty()) {
			Pair<TreeNode, Integer> pair = queue.poll();
			if (queue.isEmpty()) {
				res.add(pair.getKey().val);
			}else if (queue.peek().getValue()>pair.getValue()){
				res.add(pair.getKey().val);
			}

			if (pair.getKey().left != null) {
				queue.add(new Pair<>(pair.getKey().left, pair.getValue() + 1));
			}
			if (pair.getKey().right != null) {
				queue.add(new Pair<>(pair.getKey().right, pair.getValue() + 1));
			}

		}

		return res;
	}
}
