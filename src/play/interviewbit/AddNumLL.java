package play.interviewbit;

public class AddNumLL {
	public ListNode addTwoNumbers(ListNode a, ListNode b) {
	    if(a == null || a.val == 0)
	        return b;
	    if(b ==null || b.val == 0)
	        return a;
	        
	    ListNode head = null;
	    ListNode prev = head;
	    ListNode sum;
	    int carry = 0;
	    ListNode na = a;
	    ListNode nb = b;
	    int total;
	    
	    while(na != null && nb != null ) {
	        total = na.val + nb.val + carry;
            carry = total/10 ;   
	        sum = new ListNode(total%10);
	        if(head == null) {
	            head = sum;
	            prev = head;
	        } else {
	            prev.next = sum;
	            prev = prev.next;
	        }
	        na = na.next;
	        nb = nb.next;
	    }
	    
	    while(na != null || nb != null){
	        if(na != null){
	            total = na.val + carry;
	            na = na.next;
	        } else {
	            total = nb.val + carry;
	            nb = nb.next;
	        }
            carry = total/10 ;  
            sum = new ListNode(total%10);
            prev.next = sum;
            prev = prev.next;
	    }
	    
	    if(carry == 1 ) {
	        sum = new ListNode(1);
	        prev.next = sum;
	    }
	    
	    return head;
	}
	
	
	 //Definition for singly-linked list.
	 class ListNode {
	      public int val;
	      public ListNode next;
	      ListNode(int x) { val = x; next = null; }
	 }
	 
}
