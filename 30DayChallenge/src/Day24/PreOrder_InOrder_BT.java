package Day24;

import java.util.HashMap;
import java.util.Map;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(){}
	TreeNode (int _val){
		val = _val;
	}
	TreeNode (int _val, TreeNode _left, TreeNode _right)
	{
		val = _val;
		left = _left;
		right = _right;
	}
}

public class PreOrder_InOrder_BT {
	public static TreeNode buildBT(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> hash)
    {
        if(preStart > preEnd || inStart > inEnd) return null;
        
        TreeNode root = new TreeNode(preorder[preStart]);
        
        int rootIndex = hash.get(root.val);
        int numsLeft = rootIndex - inStart;
        
        root.left = buildBT(preorder, preStart+1, preStart + numsLeft, inorder, inStart, rootIndex - 1, hash);
        root.right = buildBT(preorder, preStart + numsLeft + 1, preEnd, inorder, rootIndex + 1, inEnd, hash);
        
        return root;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] inorder = {40, 20, 50, 10, 60, 30};
		int[] preorder = {10, 20, 40, 50, 30, 60};
		
		Map<Integer, Integer> hash = new HashMap<>();
        for(int i=0; i<inorder.length; i++) hash.put(inorder[i], i);
        
        buildBT(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, hash);
        
        System.out.println("Binary Tree Constructed");
		
	}

}
