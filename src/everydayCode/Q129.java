package everydayCode;

import utils.tree.TreeNode;

/**
 * Created by wxn
 * 2020/10/29 10:31
 */


public class Q129 {

	public int sumNumbers(TreeNode root) {

		return dfs(root,0);
	}

	private int dfs(TreeNode root, int curSum) {
		if (root==null){
			return curSum;
		}
		int sum = 0;
		curSum = curSum*10+root.val;
		if (root.left==null && root.right==null){
			return curSum;
		}
		if (root.left!=null){
			sum+=dfs(root.left, curSum);
		}
		if (root.right!=null){
			sum+=dfs(root.right, curSum);
		}
		return sum;
	}
}
