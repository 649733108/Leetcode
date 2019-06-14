import utils.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by wxn
 * 2019/6/14 16:24
 *
 * 94. 二叉树的中序遍历
 *
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */


public class Solution94 {

	//解法1 递归法
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> resultList = new ArrayList<>();
		inorderTraversal(root,resultList);

		return resultList;
	}

	private void inorderTraversal(TreeNode root, List<Integer> resultList) {
		if (root==null)
			return;

		inorderTraversal(root.left,resultList);
		resultList.add(root.val);
		inorderTraversal(root.right,resultList);
	}

	//解法2 非递归法
	public List<Integer> inorderTraversal2(TreeNode root) {

		Stack<State> stack = new Stack<>();
		stack.push(new State("go", root));
		List<Integer> resultList = new ArrayList<>();

		while (!stack.empty()) {
			State state = stack.pop();
			if (state.action.equals("go") && state.target!=null) {
				stack.push(new State("go", state.target.right));
				stack.push(new State("add", state.target));
				stack.push(new State("go", state.target.left));
			} else if (state.action.equals("add") && state.target != null) {
				resultList.add(state.target.val);
			}
		}

		return resultList;

	}

	private class State{
		String action;
		TreeNode target;

		public State(String action, TreeNode target) {
			this.action = action;
			this.target = target;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		root.right = node1;
		node1.left = node2;

		List<Integer> list = new Solution94().inorderTraversal2(root);
		System.out.println(list);
	}

}
