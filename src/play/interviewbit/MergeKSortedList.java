package play.interviewbit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MergeKSortedList {

	//Definition for singly-linked list.
	static class ListNode {
		public int val;
		public ListNode next;
		ListNode(int x) { val = x; next = null; }
	}

	public ListNode mergeKLists(ArrayList<ListNode> a) {
	    TreeMap<Integer,Integer> tree   = new TreeMap<>();
	    ListNode head   = null;
	    ListNode body   = null;
	    ListNode prev   = null;
	    
	    if (a == null) {
	        return head;
	    }
	    
	    a.forEach(node -> {
	    	ListNode elem	= node;
	    	while (elem != null) {
	    		Integer count	= tree.get(elem.val);
	    		tree.put(elem.val, count == null ? 1 : count+1 );
	    		elem	= elem.next;
	    	}
	    });
	    
	    Entry<Integer, Integer> entry	= null;
	    for (Iterator<Entry<Integer, Integer>> itr = tree.entrySet().iterator(); itr.hasNext();) {
	    	entry		= itr.next();
	    	int count	= entry.getValue();
	    	
	    	for (int i = 0 ; i < count; i++) {
	    		body		= new ListNode(entry.getKey());
	    		if (prev != null) prev.next	= body;
	    		prev		= body;
	    		
	    		if(head != null) 
	    			head	= body;
	    	}
	    }
	    
	    return head;
	}
}
