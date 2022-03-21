package Solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wxn
 * 2021/11/18 20:39
 */


public class Solution563 {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public int findTilt(TreeNode root) {

		//key:node value:左子树节点之和+右子树节点之和+node.val
		Map<TreeNode,Integer> map = new HashMap<>();
		//梯度map
		Map<TreeNode,Integer> map2 = new HashMap<>();
		postOrder(root,map,map2);
		return map2.values().stream().reduce(0, Integer::sum);
	}

	//后序遍历
	private int postOrder(TreeNode node, Map<TreeNode, Integer> map,Map<TreeNode, Integer> map2) {

		if (node == null) {
			return 0;
		}
		int leftNum = postOrder(node.left,map,map2);
		int rightNum = postOrder(node.right, map, map2);
		int val = leftNum+rightNum+node.val;
		map.put(node,val);
		map2.put(node,Math.abs(leftNum-rightNum));
		return val;
	}

	public int findTilt2(TreeNode root) {
		int[]arr = {0};
		dfs(root,arr);
		return arr[0];
	}

	private int dfs(TreeNode root, int[] res) {
		if (root == null) {
			return 0;
		}
		int leftValue = dfs(root.left,res);
		int rightValue = dfs(root.right,res);
		res[0]+=Math.abs(leftValue-rightValue);
		return leftValue+rightValue+root.val;
	}
}
