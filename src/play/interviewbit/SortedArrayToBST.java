package play.interviewbit;

import java.util.Arrays;
import java.util.List;

public class SortedArrayToBST {
	
	static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("[").append(val)
					.append("]");
			return builder.toString();
		}
	    
	    
	}
	    
	public TreeNode sortedArrayToBST(final List<Integer> a) {
	    TreeNode root   = null;
	    
	    if ( a.size() == 0 ) {
	        return root;
	    }
	    
	    root   = createBST(a, 0, a.size() -1);
	    
	    return root;
	}
	
	private TreeNode createBST (List<Integer> a, int start,int end) {
		if (start > end ) {
	        return null;
	    }
	    
	    if (start == end) {
	    	return new TreeNode(a.get(start));
	    }
	    
	    int mid     = start + (end - start) / 2;
	    TreeNode root   = new TreeNode(a.get(mid));
	    
	    
	    root.left      = createBST(a, start, mid -1);
	    root.right      = createBST(a, mid +1, end);
	    
//	    System.out.println(root.left + "<-" + root + "->" + root.right);
	    return root;
	}
	
	public static void main(String[] args) {
		Integer[] ip1	= {1,2,3,4,5,6,7};
		Integer[] ip2	= {1,2};
		SortedArrayToBST inst	= new SortedArrayToBST();
		
		inst.sortedArrayToBST(Arrays.asList(ip1));
		inst.sortedArrayToBST(Arrays.asList(ip2));
	}
	
}
