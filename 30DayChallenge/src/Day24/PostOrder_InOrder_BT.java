package Day24;

import java.util.HashMap;
import java.util.Map;

class TreeNode1{
	int val;
	TreeNode1 left;
	TreeNode1 right;
	TreeNode1(){}
	TreeNode1 (int _val){
		val = _val;
	}
	TreeNode1 (int _val, TreeNode1 _left, TreeNode1 _right)
	{
		val = _val;
		left = _left;
		right = _right;
	}
}
public class PostOrder_InOrder_BT {
	public static TreeNode buildBT(int[] inorder, int inStart, int inEnd, int[] postorder, int posStart, int posEnd,
			Map<Integer, Integer> hash)
	{
		if(inStart > inEnd || posStart > posEnd) return null;
		
		TreeNode root = new TreeNode(postorder[posEnd]);
		
		int rootIndex = hash.get(root.val);
		int numLeft = rootIndex - inStart;
		
		root.left = buildBT(inorder, inStart, rootIndex - 1, postorder, posStart, posStart + numLeft - 1, hash);
		root.right = buildBT(inorder, rootIndex + 1, inEnd, postorder, posStart + numLeft, posEnd - 1, hash);
		
		
		return root;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] inorder = {9, 3, 15, 20, 7};
		int[] postorder = {9, 15, 7, 20, 3};
		
		Map<Integer, Integer> hash = new HashMap<>();
        for(int i=0; i<inorder.length; i++) hash.put(inorder[i], i);
        
        buildBT(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, hash);
        
        System.out.println("Binary Tree Constructed");
        
	}

}
