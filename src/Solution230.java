import utils.tree.TreeNode;

import java.util.Stack;

/**
 * Created by wxn
 * 2019/7/3 15:16
 *
 * 230. 二叉搜索树中第K小的元素
 *
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 *
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 1
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 3
 * 进阶：
 * 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
 *
 */


public class Solution230 {

	int count = 0;

	//解法1 中序遍历
	public int kthSmallest(TreeNode root, int k) {

		if (root == null) {
			return Integer.MIN_VALUE;
		}
		int left = kthSmallest(root.left, k);
		if (left!=Integer.MIN_VALUE){
			return left;
		}
		count++;
		if (count==k){
			return root.val;
		}
		int right = kthSmallest(root.right, k);
		if (right!=Integer.MIN_VALUE){
			return right;
		}
		return Integer.MIN_VALUE;
	}

	//解法2 中序遍历非递归法
	public int kthSmallest2(TreeNode root, int k) {
		if (root==null){
			throw new IllegalArgumentException();
		}
		Stack<TreeNode> stack = new Stack<>();
		while (!stack.isEmpty() || root!=null) {
			while (root!=null){
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			k--;
			if (k==0){
				return root.val;
			}
			root = root.right;
		}
		throw new IllegalArgumentException();
	}
}
