package Day23;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(){};
	TreeNode(int _val){val = _val;}
	TreeNode(int _val, TreeNode _left, TreeNode _right){
		val = _val;
		left = _left;
		right = _right;
	}
}
public class PrintAllNodeAtDistanceK {

	public static void markParents(TreeNode root, Map<TreeNode, TreeNode> parentTrack)
	{
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		
		while(!q.isEmpty())
		{
			int size = q.size();
			
			for(int i=0; i<size; i++)
			{
				TreeNode curr = q.poll();
				
				if(curr.left!=null)
				{
					q.add(curr.left);
					parentTrack.put(curr.left, curr);
				}
				if(curr.right!=null)
				{
					parentTrack.put(curr.right, curr);
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Print all the nodes at distance K from target;
		
		TreeNode root = new TreeNode(3);
		
		root.left = new TreeNode(5);
		root.right = new TreeNode(1);
		
		root.left.left = new TreeNode(6);
		
		root.left.right = new TreeNode(2);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(4);
		
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(8);
		
		TreeNode target = root.left;
		
		int k = 2;
		
		Map<TreeNode, TreeNode> parentTrack = new HashMap<>();
		parentTrack.put(root, root);
		
		markParents(root, parentTrack);
		
		boolean[] visited = new boolean[500];
		visited[target.val] = true;
		
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(target);
		
		int distance = 0;
		
		while(!q.isEmpty())
		{
			int size = q.size();
			
			if(distance == k) break;
			
			for(int i=0; i<size; i++)
			{
				TreeNode curr = q.poll();
				
				if(curr.left!=null && !visited[curr.left.val])
				{
					q.add(curr.left);
					visited[curr.left.val] = true;
				}
				if(curr.right!=null && !visited[curr.right.val])
				{
					q.add(curr.right);
					visited[curr.right.val] = true;
				}
				if(!visited[parentTrack.get(curr).val])
				{
					q.add(parentTrack.get(curr));
					visited[parentTrack.get(curr).val] = true;
				}
			}
			
			distance++;
		}
		
		List<Integer> ans = new ArrayList<>();
		while(q.size() > 0) ans.add(q.poll().val);
		
		System.out.println(ans);
		
	}

}
