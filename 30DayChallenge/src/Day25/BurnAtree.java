package Day25;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) {
	       val = x;
	       left=null;
	       right=null;
	      }
}

public class BurnAtree {
	public static TreeNode markParents(TreeNode root, Map<TreeNode, TreeNode> parentTracker, int B)
    {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);

        TreeNode target = new TreeNode(-1);
        
        while(!q.isEmpty())
        {
            TreeNode curr = q.poll();
            if(curr.val == B) target = curr;
            if(curr.left!=null)
            {
            	q.add(curr.left);
            	parentTracker.put(curr.left, curr);
            }
            if(curr.right!=null)
            {
                q.add(curr.right);
                parentTracker.put(curr.right, curr);
            }
        }
        return target;
    }
    public static int findTime(Map<TreeNode, TreeNode> parentTracker, TreeNode target)
    {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(target);

        Map<TreeNode, Integer> visited = new HashMap<>();
        visited.put(target, 1);

        int time = 0;
        while(!q.isEmpty())
        {
            int size = q.size();
            boolean flag = false;

            for(int i=0; i<size; i++)
            {
                TreeNode curr = q.poll();
                if(curr.left!=null && visited.get(curr.left) == null)
                {
                    q.add(curr.left);
                    visited.put(curr.left, 1);
                    flag = true;
                }
                if(curr.right!=null && visited.get(curr.right) == null)
                {
                    q.add(curr.right);
                    visited.put(curr.right, 1);
                    flag = true;
                }
                if(visited.get(parentTracker.get(curr)) == null)
                {
                   q.add(parentTracker.get(curr));
                   visited.put(parentTracker.get(curr), 1);
                    flag = true;
                }

            }
            
            if(flag) time++;
            
        }
        return time;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode root = new TreeNode(1);
		
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		root.left.left = new TreeNode(4);
		
		root.right.left = new TreeNode(5);
		root.right.left = new TreeNode(6);
		
		
		int B = 4;
		
		Map<TreeNode, TreeNode> parentTracker = new HashMap<>();
        parentTracker.put(root, root);

        TreeNode leaf = markParents(root, parentTracker, B);

        int time = findTime(parentTracker, leaf);

        System.out.println("Time take to burn the tree: "+time);

	}

}
