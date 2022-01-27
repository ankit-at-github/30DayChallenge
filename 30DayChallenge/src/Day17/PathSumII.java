package Day17;

import java.util.ArrayList;
import java.util.List;

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
public class PathSumII {
	public static void pathToSum(TreeNode root, int sum, List<Integer> path, List<List<Integer>> ans)
	{
		if(root==null) return;
		
		if(root.left==null && root.right==null)
		{
			if((sum - root.val) == 0)
			{
				path.add(root.val);
				ans.add(new ArrayList(path));
				path.remove(path.size() - 1);
				return;
			}
		}
		
		path.add(root.val);
		
		pathToSum(root.left, sum - root.val, path, ans);
		pathToSum(root.right, sum - root.val, path, ans);
		
		path.remove(path.size() - 1);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Given the root of a binary tree and an integer targetSum, 
		return all root-to-leaf paths where the sum of the node values in the path equals targetSum.
		Each path should be returned as a list of the node values, not node references.*/
		
		TreeNode root = new TreeNode(5);
		
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		
		root.right = new TreeNode(8);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(1);
		
		int sum = 22;
		
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		
		pathToSum(root, sum, path, ans);
		
		System.out.println(ans);
		

	}

}
