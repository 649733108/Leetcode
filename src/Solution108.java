import utils.tree.TreeNode;

/**
 * Created by wxn
 * 2019/7/3 15:03
 * <p>
 * 108. 将有序数组转换为二叉搜索树
 * <p>
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * 示例:
 * <p>
 * 给定有序数组: [-10,-3,0,5,9],
 * <p>
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 */


public class Solution108 {

	//利用二分法
	public TreeNode sortedArrayToBST(int[] nums) {

		if (nums == null || nums.length == 0) {
			return null;
		}
		return getBST(nums, 0, nums.length - 1);
	}

	private TreeNode getBST(int[] nums, int left, int right) {

		if (left > right || left < 0 || right >= nums.length) {
			return null;
		}
		if (left == right) {
			return new TreeNode(nums[left]);
		}
		int mid = left + (right - left) / 2;
		TreeNode node = new TreeNode(nums[mid]);
		node.left = getBST(nums, left, mid - 1);
		node.right = getBST(nums, mid + 1, right);
		return node;
	}
}
