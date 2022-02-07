package Day28;
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(){}
	TreeNode(int _val)
	{
		val = _val;
	}
}
public class CeilInBST {
	public static int findCeil(TreeNode root, int key)
	{
		int ans = -1;
		
		while(root!=null)
		{
			if(root.val == key) return root.val;
			
			else if(key < root.val)
			{
				ans = root.val; //Key is smaller than current value that means the current data can be just greater than Key and possibly a ceil value.
				root = root.left;
			}
			else root = root.right;
		}
		
		
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Finding the next greatest number for the given key.
		
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
		
		int ceil = findCeil(root, key);
		
		System.out.println("Ceil of "+ key+ " in BST is: "+ceil);
		
		
	}

}
