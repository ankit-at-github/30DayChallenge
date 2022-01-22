package Day12;

class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode() {}
	      TreeNode(int val) { this.val = val; }
	      TreeNode(int val, TreeNode left, TreeNode right) {
	          this.val = val;
	          this.left = left;
	          this.right = right;
	      }
}

public class MaxPathSum {
	public static int getMaxPathSum(TreeNode root, int[] maxValue)
	{
		if(root==null) return 0;
		
		int left = Math.max(0, getMaxPathSum(root.left, maxValue));
		int right = Math.max(0, getMaxPathSum(root.right, maxValue));
		
		maxValue[0] = Math.max(maxValue[0],	 left+right+root.val);
		
		return root.val + Math.max(left, right);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode root = new TreeNode(-10);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		int[] maxValue = new int[1];
		
		maxValue[0] = Integer.MIN_VALUE;
		
		getMaxPathSum(root,maxValue);
		
		System.out.println(maxValue[0]);

	}

}
