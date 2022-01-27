package Day16;

import java.util.LinkedList;
import java.util.Queue;

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
class Pair{
    TreeNode node;
    int index;
    Pair(TreeNode _node, int _index)
    {
        node = _node;
        index = _index;
    }
}
public class MaximumWidthOfBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode root = new TreeNode(1);
		
		root.left = new TreeNode(3);
		root.right = new TreeNode(2);
		
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(3);
		
		root.right.right = new TreeNode(9);
		
		
		Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(root,0));
        
        int maxi = Integer.MIN_VALUE;
        int firstIndex = 0, lastIndex = 0;
        
        int minIndex = 0;
        
        while(!q.isEmpty())
        {
            int size = q.size();
            
            for(int j=0; j<size; j++)
            {
                Pair p = q.poll();
                TreeNode node = p.node;
                int currentIndex = p.index;
                
                if(j==0) firstIndex = p.index;
                if(j==size-1) lastIndex = p.index;
                
              //MinIndex of a level is always the first one to pop in that level.
                minIndex = Math.min(minIndex, currentIndex);
                
                if(node.left!=null)
                {
                    int i = (currentIndex - minIndex);
                    int value = 2*i + 1;
                    q.add(new Pair(node.left, value));
                }
                
                if(node.right!=null)
                {
                    int i = (currentIndex - minIndex);
                    int value = 2*i + 2;
                    q.add(new Pair(node.right, value));
                }
            }
            
            maxi = Math.max(maxi, (lastIndex - firstIndex + 1));
            
        }
        System.out.println(maxi);

	}

}
