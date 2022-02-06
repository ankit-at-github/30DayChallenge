package Day26;

import java.util.ArrayList;
import java.util.List;

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
public class MorrisTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//MORRIS Traversal is In-Order traversal with O(1) Space complexity.
		
		TreeNode root = new TreeNode(1);
		
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		root.left.right.right = new TreeNode(6);
		
		List<Integer> ans = new ArrayList<>();
		
		TreeNode curr = root;
		
		while(curr!=null)
		{
			//1st Observation if left side is null, current node is root node so add it.
			if(curr.left==null)
			{
				ans.add(curr.val);
				curr = curr.right;
			}
			else
			{
				//2nd observation if check if right most node in left sub-tree is null or connected with main root.
				TreeNode prev = curr.left;
				while(prev.right!=null && prev.right!=curr)
				{
					prev = prev.right;
				}
				if(prev.right==null)
				{
					prev.right = curr;
					curr = curr.left;
				}
				else
				{
					prev.right = null;
					ans.add(curr.val); //if this line is place in 1st if condition then it becomes Pre-order Morris traversal in constant time
					curr = curr.right;
				}
			}
		}
		
		System.out.println("In-Order Morris Traversal: "+ans);
		
	}

}
