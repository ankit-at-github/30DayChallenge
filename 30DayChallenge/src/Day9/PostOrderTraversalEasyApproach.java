package Day9;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
public class PostOrderTraversalEasyApproach {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Binary Tree Post Order Traversal can be solved using 2 stack easily.
		//Using 1 stack it's tough
		
		//Here, we will solve without using any stack in O(1) time complexity
		
		//Root Node will be given.
		
		TreeNode root = null;
		
		List<Integer> ans = new ArrayList<>();
		
		Stack<TreeNode> st = new Stack<>();
		
		st.push(root);
		
		while(!st.isEmpty())
		{
			TreeNode curr = st.pop();
			
			ans.add(0,curr.val);
			
			if(curr.left!=null) st.push(curr.left);
			if(curr.right!=null) st.push(curr.right);
		}
		
		for(int n : ans) System.out.println(n);

	}

}
