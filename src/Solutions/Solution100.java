package Solutions;

import utils.tree.TreeNode;

/**
 * Created by wxn
 * 2019/6/30 0:16
 * <p>
 * 100. 相同的树
 * <p>
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * <p>
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * <p>
 * 示例 1:
 * <p>
 * 输入:       1         1
 * / \       / \
 * 2   3     2   3
 * <p>
 * [1,2,3],   [1,2,3]
 * <p>
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:      1          1
 * /           \
 * 2             2
 * <p>
 * [1,2],     [1,null,2]
 * <p>
 * 输出: false
 * 示例 3:
 * <p>
 * 输入:       1         1
 * / \       / \
 * 2   1     1   2
 * <p>
 * [1,2,1],   [1,1,2]
 * <p>
 * 输出: false
 */


public class Solution100 {

	public boolean isSameTree(TreeNode p, TreeNode q) {

		if (p == null && q == null)
			return true;
		else if (p == null) {
			return false;
		} else if (q == null) {
			return false;
		} else {
			//p!=null && q!=null
			if (p.val != q.val) {
				return false;
			} else {
				return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
			}
		}
	}
}
