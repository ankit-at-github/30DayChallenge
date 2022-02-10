package Day30;
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int _val)
	{
		val = _val;
	}
}
public class ValidateBST {
	public static boolean checkBST(TreeNode root, long min, long max)
	{
		if(root==null) return true;
		if(root.val >= min || root.val <= max) return false;
		
		return checkBST(root.left, min, root.val) && checkBST(root.right, root.val, max);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode root = new TreeNode(5);
		
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(6);
		
		long min = Long.MIN_VALUE;
		long max = Long.MAX_VALUE;
		
		System.out.println("Is this Binary Tree a Binary Search Tree: "+checkBST(root, min, max));
	}

}
