package Day12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

class TreeNode1 {
    int val;
    TreeNode1 left;
    TreeNode1 right;
    TreeNode1() {}
    TreeNode1(int val) { this.val = val; }
    TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Tuple{
	TreeNode1 node;
	int vertical;
	int level;
	Tuple(TreeNode1 _node, int _vertical, int _level)
	{
		node = _node;
		vertical = _vertical;
		level = _level;
	}
}
public class VerticalOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode1 root = new TreeNode1(3);
		root.left = new TreeNode1(9);
		root.right = new TreeNode1(20);
		root.right.left = new TreeNode1(15);
		root.right.right = new TreeNode1(7);
		
		TreeMap<Integer,TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
		Queue<Tuple> q = new LinkedList<Tuple>();
		q.add(new Tuple(root, 0, 0));
		
		while(!q.isEmpty())
		{
			Tuple tuple = q.poll();
			TreeNode1 node = tuple.node;
			int vertical = tuple.vertical;
			int level = tuple.level;
			
			if(!map.containsKey(vertical)) map.put(vertical, new TreeMap<>());
			
			if(!map.get(vertical).containsKey(level)) map.get(vertical).put(level, new PriorityQueue<>());
			
			map.get(vertical).get(level).add(node.val);
			
			if(node.left!=null)
			{
				q.add(new Tuple(node.left, vertical - 1, level + 1));
			}
			
			if(node.right!=null)
			{
				q.add(new Tuple(node.right, vertical + 1, level + 1));
			}
		}
		
		List<List<Integer>> ans = new ArrayList<>();
		for(TreeMap<Integer, PriorityQueue<Integer>> itVertical : map.values())
		{
			ans.add(new ArrayList<>());
			
			for(PriorityQueue<Integer> nodes : itVertical.values())
			{
				while(!nodes.isEmpty())
				{
					ans.get(ans.size() - 1).add(nodes.poll());
				}
			}
		}
		
		System.out.print("Vertical Order Traversal Of a Tree: ");
		System.out.println(ans);

	}

}
