package play.interviewbit;

import java.util.Stack;

public class KthSmallestElementTree {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public int kthsmallest(TreeNode root, int k) {
        Stack<TreeNode> stk = new Stack<>();
        TreeNode curr   = root;
        TreeNode temp;
        int res         = 0;
        
        while(!stk.isEmpty() || curr != null) {
            if (curr != null) {
                stk.push(curr);
                curr    = curr.left;
            } else {
                temp    = stk.pop();
                k--;
                
                if ( k == 0)
                    res = temp.val;
                curr = temp.right;
            }
        }
        
        return res;
    }
}
