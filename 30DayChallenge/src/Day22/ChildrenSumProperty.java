package Day22;
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
public class ChildrenSumProperty {
	public static int childrenSumProperty(TreeNode root)
	{
		int leftval = 0;
		int rightval = 0;
		
		if(root.left==null && root.right==null) return root.val;;
		
		if(root.left!=null) leftval = root.left.val;
		if(root.right!=null) rightval = root.right.val;
		
		if(leftval+rightval < root.val)
		{
			root.left.val = root.val;
			root.right.val = root.val;
		}
		
		
		
		int leftchild = childrenSumProperty(root.left);
		int rightchild = childrenSumProperty(root.right);
		
		if(leftchild + rightchild > root.val) root.val = leftchild+rightchild;
		
		
		return root.val;
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Children Sum Property : You can increase the value of a node any number of times to make it equal to
		//sum of the node values of its children.
		
		TreeNode root = new TreeNode(50);
		root.left = new TreeNode(7);
		root.right = new TreeNode(2);
		
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(5);
		
		
		root.right.left = new TreeNode(1);
		root.right.right = new TreeNode(30);
		
		System.out.println("Root initial value: "+root.val);
		
		childrenSumProperty(root);
		
		System.out.println("Root value following Children Sum Property: "+childrenSumProperty(root));
		

	}

}
