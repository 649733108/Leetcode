package Solutions;

import java.util.*;

/**
 * Created by wxn
 * 2022/3/12 15:35
 *
 * 590. N 叉树的后序遍历
 * 给定一个 n 叉树的根节点 root ，返回 其节点值的 后序遍历 。
 *
 * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[5,6,3,2,4,1]
 * 示例 2：
 *
 *
 *
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：[2,6,14,11,7,3,12,8,4,13,9,10,5,1]
 *
 *
 * 提示：
 *
 * 节点总数在范围 [0, 104] 内
 * 0 <= Node.val <= 104
 * n 叉树的高度小于或等于 1000
 *
 *
 * 进阶：递归法很简单，你可以使用迭代法完成此题吗?
 */


public class Solution590 {

	class Node {
		public int val;
		public List<Node> children;

		public Node() {}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	}


	public List<Integer> postorder(Node root) {

		List<Integer> res = new ArrayList<>();
		postorder(root,res);
		return res;
	}

	private void postorder(Node node, List<Integer> res) {
		if (node == null) {
			return;
		}
		List<Node> children = node.children;
		for (Node child : children) {
			postorder(child,res);
		}
		res.add(node.val);
	}

	//非递归
	public List<Integer> postorder2(Node root) {

		List<Integer> res = new ArrayList<>();
		if (root==null){
			return res;
		}
		Stack<Node> stack = new Stack<>();
		Set<Node> visited = new HashSet<>();
		stack.add(root);
		while (!stack.isEmpty()) {
			Node n = stack.peek();
			if (n.children.size()==0 || visited.contains(n)) {
				stack.pop();
				res.add(n.val);
			}else {
				visited.add(n);
				List<Node> children = n.children;
				for (int i = children.size()-1; i >=0; i--) {
					stack.push(children.get(i));
				}
			}
		}
		return res;
	}



}
