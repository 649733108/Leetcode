import utils.tree.TreeNode;

/**
 * Created by wxn
 * 2019/6/30 0:44
 *
 * 222. 完全二叉树的节点个数
 *
 * 给出一个完全二叉树，求出该树的节点个数。
 *
 * 说明：
 *
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 *
 * 示例:
 *
 * 输入:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 *
 * 输出: 6
 */


public class Solution222 {

	private int count = 0;

	//解法1 依次遍历
	public int countNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}
		count++;
		countNodes(root.left);
		countNodes(root.right);
		return count;
	}

	public int countNodes2(TreeNode root) {
		if (root==null)
			return 0;
		return countNodes2(root.left)+countNodes2(root.right)+1;
	}

	public int countNodes3(TreeNode root) {
		TreeNode left = root;
		TreeNode right = root;
		int leftHeight = 0;
		int rightHeight = 0;
		while (left != null) {
			leftHeight++;
			left = left.left;
		}
		while (right != null) {
			rightHeight++;
			right = right.right;
		}
		if(leftHeight==rightHeight){
			return (int) (Math.pow(2, leftHeight)-1);
		}
		return countNodes3(root.left)+countNodes3(root.right)+1;
	}
}
