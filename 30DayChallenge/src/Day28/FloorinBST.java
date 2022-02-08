package Day28;
class TreeNode1{
	int val;
	TreeNode1 left;
	TreeNode1 right;
	TreeNode1(){}
	TreeNode1(int _val)
	{
		val = _val;
	}
}
public class FloorinBST {
	public static int findFloor(TreeNode root, int key)
	{
		int ans = -1;
		
		while(root!=null)
		{
			if(root.val == key) return root.val;
			
			else if(key > root.val)
			{
				ans = root.val; //Key is greater than current value that means the current data can be just smaller than Key and possibly a floor value.
				root = root.right;
			}
			else root = root.left;
		}
		
		
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(13);
		
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(6);
		
		root.right.left = new TreeNode(11);
		root.right.right = new TreeNode(14);
		
		root.left.left.left = new TreeNode(2);
		root.left.left.right = new TreeNode(4);
		
		root.left.right.right = new TreeNode(9);
		
		int key = 8;
		
		int ceil = findFloor(root, key);
		
		System.out.println("Floor of "+ key+ " in BST is: "+ceil);

	}

}
