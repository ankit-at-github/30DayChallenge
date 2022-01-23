package Day13;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

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

class Pair1{
	TreeNode1 node;
	int line;
	
	Pair1(TreeNode1 _node, int _line){
		node = _node;
		line = _line;
	}
	
}

public class BottomViewOfBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode1 root= new TreeNode1(1);
		root.left = new TreeNode1(2);
		root.right = new TreeNode1(3);
		
		root.left.left = new TreeNode1(4);
		root.left.right = new TreeNode1(5);
		
		root.right.left = new TreeNode1(6);
		root.right.right = new TreeNode1(7);
		
		root.left.right.left = new TreeNode1(8);
		root.right.left.right = new TreeNode1(9);
		
		TreeMap<Integer, Integer> map = new TreeMap<>();
		
		Queue<Pair1> q = new LinkedList<Pair1>();
		q.add(new Pair1(root, 0));
		
		
		while(!q.isEmpty())
		{
			Pair1 p = q.poll();
			
			TreeNode1 curr = p.node;
			int line = p.line;
			
			map.put(line, curr.val);
			
			if(curr.left!=null) q.add(new Pair1(curr.left, line - 1));
			if(curr.right!=null) q.add(new Pair1(curr.right, line + 1));
			
		}
		
		List<Integer> ans = new ArrayList<>();
		
		for(int n : map.values()) ans.add(n);
		
		System.out.println(ans);
		

	}

}
