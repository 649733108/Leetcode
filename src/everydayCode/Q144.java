package everydayCode;

import utils.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wxn
 * 2020/10/27 21:51
 */


public class Q144 {

	public List<Integer> preorderTraversal(TreeNode root){

		List<Integer> ret = new ArrayList<>();
		preorderTraversal(root, ret);
		return ret;
	}

	private void preorderTraversal(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		list.add(root.val);
		preorderTraversal(root.left, list);
		preorderTraversal(root.right,list);
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		n3.left = n4;
		n3.right = n6;
		n4.right = n2;
		n6.left = n1;
		n6.right = n5;

		System.out.println(new Q144().preorderTraversal(n3));
	}
}
