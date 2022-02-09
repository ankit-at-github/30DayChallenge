package Day29;
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(){}
	TreeNode(int _val){
		val = _val;
	}
	TreeNode(int _val, TreeNode _left, TreeNode _right)
	{
		val = _val;
		left = _left;
		right = _right;
	}
}
public class DeleteANodeinBST {
	public static void inorder(TreeNode root)
	{
		if(root == null) return;
		
		inorder(root.left);
		System.out.print(root.val+" ");
		inorder(root.right);
	}
	
	public static TreeNode findMax(TreeNode root)
	{
		if(root.right == null) return root;
		return findMax(root.right);
	}
	public static TreeNode helper(TreeNode root)
	{
		if(root.left == null) return root.right;
		else if(root.right == null) return root.left;
		else
		{
			TreeNode rightChild = root.right;
			TreeNode maxInLeftSubtree = findMax(root.left);
			maxInLeftSubtree.right = rightChild;
			return root.left;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode root = new TreeNode(5);
		
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		
		root.right.right = new TreeNode(7);
		
		int key = 3;
		
		TreeNode dummy = root;
		
		while(root!=null)
		{
			if(key < root.val)
			{
				if(root.left!=null && root.left.val == key)
				{
					root.left = helper(root.left);
					break;
				}
				else
				{
					root = root.left;
				}
			}
			else
			{
				if(root.right!=null && root.right.val == key)
				{
					root.right = helper(root.right);
					break;
				}
				else
				{
					root = root.right;
				}
			}
		}
		
		System.out.print("Nodes in Tree: ");
		inorder(root);
		
	}

}
