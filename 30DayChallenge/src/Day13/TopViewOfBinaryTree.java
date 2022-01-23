package Day13;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(){};
	TreeNode(int _val){
		val = _val;
	}
	TreeNode(int _val, TreeNode _left, TreeNode _right){
		val = _val;
		left = _left;
		right = _right;
	}
}

class Pair{
	TreeNode node;
	int line;
	Pair(TreeNode _node, int _line){
		node = _node;
		line = _line;
	}
}

public class TopViewOfBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.right = new TreeNode(7);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.right.left = new TreeNode(6);
		
		TreeMap<Integer,Integer> map = new TreeMap<>();
		
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(root, 0));
		
		while(!q.isEmpty())
		{
			Pair p = q.poll();
			TreeNode node = p.node;
			int line = p.line;
			
			if(!map.containsKey(line)) map.put(line, node.val);
			
			if(node.left!=null) q.add(new Pair(node.left, line - 1));
			if(node.right!=null) q.add(new Pair(node.right, line + 1));
			
		}
		
		List<Integer> ans = new ArrayList<>();
		
		for(int n : map.values()) ans.add(n);
		
		System.out.println(ans);

	}

}
