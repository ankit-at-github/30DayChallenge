package Day29;

import java.util.Stack;

class TreeNode1{
	int val;
	TreeNode1 left;
	TreeNode1 right;
	TreeNode1(){}
	TreeNode1(int _val){
		val = _val;
	}
	TreeNode1(int _val, TreeNode1 _left, TreeNode1 _right)
	{
		val = _val;
		left = _left;
		right = _right;
	}
}
public class KthSmallestandLargestElementinBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Kth Largest Element - (Total Elements (N) - K)th Smallest Element
		
		TreeNode1 root = new TreeNode1(5);
		root.left = new TreeNode1(3);
		root.right = new TreeNode1(6);
		
		root.left.left = new TreeNode1(2);
		root.left.right = new TreeNode1(4);
		
		root.left.left.left = new TreeNode1(1);
		
		int k = 3;
		
		boolean found = false;
		
		Stack<TreeNode1> st = new Stack<>();
		
		while(root!=null || !st.isEmpty())
		{
			if(root!=null)
			{
				st.push(root);
				root = root.left;
			}
			else
			{
				root = st.pop();
				
				if(--k == 0)
				{
					found = true;
					System.out.println("Third Smallest Element in Tree: "+root.val);
				}
				
				root = root.right;
			}
		}
		
		if(!found) System.out.println(-1);
		
	}

}
