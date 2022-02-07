package Day27;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(){}
	TreeNode(int _val){val = _val;}
}
public class FlattenABinaryTree {
	static TreeNode prev = null;
	public static void flatten(TreeNode root)
	{
		if(root==null) return;
		
		flatten(root.right);
		flatten(root.left);
		root.right = prev;
		root.left = null;
		prev = root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode root = new TreeNode(1);
		
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		
		root.right.right = new TreeNode(6);
		
		//So we need to transform this Binary Tree into Linked List in constant space O(1).
		flatten(root);
		
		System.out.println("Binary Tree is Flattened into Linked List");
		
		while(root!=null)
		{
			System.out.print(root.val+" ");
			root = root.right;
		}
		
		//This question can also be solved using Iterative Approach - Stack and Morris Traversal Approach

	}

}
