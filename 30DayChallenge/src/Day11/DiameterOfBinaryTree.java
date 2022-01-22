package Day11;

public class DiameterOfBinaryTree {
	
	public static int getHeight(TreeNode root, int[] diameter)
	{
		if(root==null) return 0;
		
		int left = getHeight(root.left, diameter);
		int right = getHeight(root.right, diameter);
		
		diameter[0] = Math.max(diameter[0], left+right);
		
		return 1 + Math.max(left, right);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode root = null;
		
		int[] diameter = new int[1];
		
		getHeight(root, diameter);
		
		System.out.println(diameter[0]);

	}

}
