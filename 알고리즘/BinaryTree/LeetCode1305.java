package BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode1305 {
	public static LeetCode1305 lc = new LeetCode1305();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root1=new TreeNode(2);
        root1.left=new TreeNode(1);
        root1.right=new TreeNode(4);
        TreeNode root2=new TreeNode(1);
        root2.left=new TreeNode(0);
        root2.right=new TreeNode(3);
        
        List<Integer> result = lc.getAllElements(root1, root2);
        
        for(int i = 0; i < result.size(); i++)
        {
        	System.out.print(result.get(i) + " ");
        }
	}
	
	List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
		List<Integer> result = new ArrayList<>();
		
		treeToList(root1, result);
		treeToList(root2, result);

		Collections.sort(result);
		return result;
    }
	
	void treeToList(TreeNode root, List<Integer> tree)
	{
		if(root == null)
			return;
		tree.add(root.val);
		treeToList(root.left, tree);
		treeToList(root.right, tree);
	}
}

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
 
