package Day16;

import java.util.ArrayList;
import java.util.List;

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
public class RootToLeafNode {
	
	public static void pathtoLeafNode(TreeNode1 root, StringBuilder sb, List<String> ans)
    {
        if(root==null) return;
        
        if(root.left==null && root.right==null)
        {
            sb.append(root.val);
            ans.add(sb.toString());
            return;
        }
        
        sb.append(root.val+"->");
        
        String save = sb.toString();
        
        pathtoLeafNode(root.left, sb, ans);
        pathtoLeafNode(root.right, new StringBuilder(save), ans);
        
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode1 root = new TreeNode1(1);
		
		root.left = new TreeNode1(2);
		root.right = new TreeNode1(3);
		
		root.left.right = new TreeNode1(5);
		
		List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        //if(root==null) return ans;
        
        pathtoLeafNode(root, sb, ans);
        
        System.out.println(ans);

	}

}
