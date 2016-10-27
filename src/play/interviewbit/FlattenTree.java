package play.interviewbit;

import java.util.Stack;

public class FlattenTree {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public TreeNode flatten(TreeNode a) {
	    Stack<TreeNode> stk = new Stack<>();
	    TreeNode temp   = null;
	    TreeNode p = a;
	    
	    while (p != null || !stk.isEmpty()) {
	        if (p.right != null)
	            stk.push(p.right);
	        
	        if(p.left != null) {
	            p.right = p.left;
	            p.left  = null;
	        } else if (!stk.isEmpty()) {
	            temp    = stk.pop();
	            p.right = temp;
	        }
	       
	        p   = p.right;
	    }
	    
	    return a;
	}
	
	
}
