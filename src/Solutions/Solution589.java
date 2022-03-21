package Solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wxn
 * 2022/3/10 19:28
 */


public class Solution589 {
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

	public List<Integer> preorder(Node root) {

		List<Integer> res = new ArrayList<>();
		preorder(root,res);

		return res;
	}

	private void preorder(Node root, List<Integer> res) {
		if (root==null){
			return;
		}
		res.add(root.val);
		List<Node> children = root.children;
		for (Node child : children) {
			preorder(child,res);
		}
	}

}
