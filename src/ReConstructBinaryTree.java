
/*
 * Created by wxn
 * 2019/4/1 20:00
 */


/**
 * 给定二叉树的先序遍历和中序遍历
 * 重新生成二叉树
 */
public class ReConstructBinaryTree {

	private class TreeNode{
		Integer value;
		TreeNode left;
		TreeNode right;

		public TreeNode(Integer value) {
			this.value = value;
			left = null;
			right = null;
		}
	}

	public TreeNode reConstructBinaryTree(int[] pre , int[] in){

		if (pre==null||in==null||pre.length!=in.length)
			return null;

		return reConstructBinaryTree(pre,0,pre.length-1 ,in,0,in.length-1);
	}

	//递归得到先序遍历起止点为preStart和preEnd,中序遍历起止点为inStart和inEnd所构成的二叉树的根节点
	private TreeNode reConstructBinaryTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {

		//递归出口
		if (preStart>preEnd)
			return null;
		//从先序遍历中得到根节点的值
		int rootValue = pre[preStart];
		TreeNode root = new TreeNode(rootValue);
		//在中序遍历中寻找根节点
		int index = inStart;
		while (index<=inEnd && rootValue!=in[index]){
			index++;
		}
		if (index>inEnd){
			throw new RuntimeException("输入错误");
		}
		root.left = reConstructBinaryTree(pre,preStart+1,preStart+index-inStart,in,inStart,index-1);
		root.right = reConstructBinaryTree(pre,preStart+index-inStart+1,preEnd,in,index+1,inEnd);

		return root;

	}

	private void printTree(TreeNode root){

		//中序遍历
		if (root==null)
			return;
		printTree(root.left);
		System.out.println(root.value);
		printTree(root.right);

	}

	public static void main(String args[]) {

		int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
		int[] in = {4, 7, 2, 1, 5, 3, 8, 6};

		ReConstructBinaryTree reConstructBinaryTree = new ReConstructBinaryTree();
		TreeNode treeNode = reConstructBinaryTree.reConstructBinaryTree(pre, in);
		reConstructBinaryTree.printTree(treeNode);

	}

}
