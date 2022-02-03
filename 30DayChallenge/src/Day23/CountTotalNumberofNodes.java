package Day23;

class TreeNode1{
	int val;
	TreeNode1 left;
	TreeNode1 right;
	TreeNode1(){}
	TreeNode1(int _val){
		val = _val;
	}
	TreeNode1(int _val, TreeNode1 _left, TreeNode1 _right){
		val = _val;
		left = _left;
		right = _right;
	}
}
public class CountTotalNumberofNodes {
	public static int getHeightLeft(TreeNode1 root)
	{
		int count = 0;
		while(root.left!=null)
		{
			count++;
			root = root.left;
		}
		
		return count;
	}
	public static int getHeightRight(TreeNode1 root)
	{
		int count = 0;
		while(root.right!=null)
		{
			count++;
			root = root.right;
		}
		
		return count;
	}
	public static int countNodes(TreeNode1 root)
	{
		if(root==null) return 0;
		
		int left = getHeightLeft(root);
		int right = getHeightRight(root);
		
		if(left==right) return ((2<<(left)) - 1);
		else return countNodes(root.left) + countNodes(root.right) + 1;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode1 root = new TreeNode1(1);
		root.left = new TreeNode1(2);
		root.right = new TreeNode1(3);
		
		root.left.left = new TreeNode1(4);
		root.left.right = new TreeNode1(5);
		
		root.right.left = new TreeNode1(6);
		
		System.out.println("Total Number of Nodes are: "+countNodes(root));

	}

}
