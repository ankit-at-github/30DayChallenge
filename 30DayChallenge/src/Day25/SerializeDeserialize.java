package Day25;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode1 {
    int val;
    TreeNode1 left;
    TreeNode1 right;
    TreeNode1(int x) {
     val = x;
     left=null;
     right=null;
    }
}
public class SerializeDeserialize {
	public static String serialize(TreeNode1 root)
	{
		StringBuilder sb = new StringBuilder();
		
		Queue<TreeNode1> q = new LinkedList<TreeNode1>();
		q.add(root);
		
		while(!q.isEmpty())
		{
			TreeNode1 node = q.poll();
			
			if(node==null)
			{
				sb.append("null"+",");
				continue;
			}
			
			sb.append(node.val+",");
			
			q.add(node.left);
			q.add(node.right);
		}
		
		sb.substring(0, sb.length()-1);
		
		return sb.toString();
		
	}
	public static TreeNode1 deserialize(String data)
	{
		if(data==null || data.length() == 0) return null;
		
		String[] values = data.split(",");
		
		TreeNode1 root = new TreeNode1(Integer.parseInt(values[0]));
		
		Queue<TreeNode1> q = new LinkedList<TreeNode1>();
		q.add(root);
		
		int i = 1;
		
		while(i<values.length)
		{
			TreeNode1 curr = q.poll();
			
			if(!values[i].equals("null"))
			{
				TreeNode1 left = new TreeNode1(Integer.parseInt(values[i]));
				curr.left = left;
				q.add(left);
			}
			
			i++;
			
			if(!values[i].equals("null"))
			{
				TreeNode1 right = new TreeNode1(Integer.parseInt(values[i]));
				curr.right = right;
				q.add(right);
			}
			
			i++;
			
		}
		
		return root;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode1 root = new TreeNode1(1);
		
		root.left = new TreeNode1(2);
		root.right = new TreeNode1(3);
		
		
		root.right.left = new TreeNode1(4);
		root.right.right = new TreeNode1(5);
		
		String data = serialize(root);
		
		System.out.println("Serialized Data of Binary Tree: [" + data+"]");
		
		deserialize(data);
		
		System.out.println("Binary Tree is Deserialized.");
		
	}

}
