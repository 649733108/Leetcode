package utils.tree;

/**
 * Created by wxn
 * 2019/6/14 16:25
 */


public class TreeNode {

	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int val) {
		this.val = val;
		left = null;
		right = null;
	}

	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
