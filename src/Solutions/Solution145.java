package Solutions;

import utils.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by wxn
 * 2019/6/19 9:00
 *
 * 145. 二叉树的后序遍历
 *
 * 给定一个二叉树，返回它的 后序 遍历。
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
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */


public class Solution145 {

	//解法1 递归法
	public List<Integer> postorderTraversal(TreeNode root) {

		List<Integer> resultList = new ArrayList<>();
		postorderTraversal(root,resultList);
		return resultList;
	}

	private List<Integer> postorderTraversal(TreeNode root, List<Integer> resultList) {
		if (root == null) {
			return resultList;
		}
		postorderTraversal(root.left,resultList);
		postorderTraversal(root.right,resultList);
		resultList.add(root.val);
		return resultList;
	}

	//解法2 迭代法
	public List<Integer> postorderTraversal2(TreeNode root){
		Stack<State> stack = new Stack<>();
		stack.push(new State("go", root));
		List<Integer> resultList = new ArrayList<>();

		while (!stack.empty()) {
			State state = stack.pop();
			if (state.action.equals("go") && state.target!=null) {
				stack.push(new State("add", state.target));
				stack.push(new State("go", state.target.right));
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

}
