package play.interviewbit;

public class ReverseList {
	public static ListNode reverseBetween(ListNode a, int m, int n) {
	    int idx = 1;
	    if(m == n)
	    	return a;
	    ListNode prev   = null;
	    ListNode curr   = a;
	    ListNode nxt;
	    ListNode head   = null;
	    ListNode tail   = null;
	    ListNode start	= null;
	    ListNode end	= null;
	    
	    while (curr != null && idx <= n) {
	    	nxt = curr.next;
	        if(idx == m) {
	            start = prev;
	            head = curr;
	        } else if(idx > m && idx < n) {
	            curr.next = prev;
	        } else if (idx == n) {
	        	curr.next = prev;
	            end = nxt;
	            tail = curr;
	        }
	        prev = curr;
	        curr = nxt;
	        
	        idx++;
	    }

	    if(start != null)
	    	start.next = tail;
	    head.next = end;
	    
	    return m==1 ? tail : a;
	}
	
	public static void main(String[] args) {
		ListNode ll = new ListNode(1);
		ListNode a = ll;
		
//		for(int i=2; i<=5; i++ ) {
//			ListNode b = new ListNode(i);
//			a.next = b;
//			a = b;
//		}
//		traverse (ll);
//		reverseBetween(ll, 2 ,4);
//		traverse (ll);
		
		ll = new ListNode(1);
		a = ll;

		for(int i=2; i<=5; i++ ) {
			ListNode b = new ListNode(i);
			a.next = b;
			a = b;
		}
		
		traverse(ll);
		ll = reverseBetween(ll, 1 ,2);
		traverse(ll);
	}
	
	public static void traverse (ListNode a) {
		while(a != null ) {
			System.out.print(a.val+ "->");
			a = a.next;
		}
		System.out.println("NULL");
	}
}


class ListNode {
	     public int val;
	     public ListNode next;
	     ListNode(int x) { val = x; next = null; }
	     
	     @Override
	    public String toString() {
	    	 StringBuilder sb = new StringBuilder();
	    	 
	    	 sb.append('[');
	    	 sb.append(val);
	    	 sb.append(']');
	    	 return sb.toString();
	    }
	 }