
//Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
 
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        ListNode temp = null;
        
        while(l1 != null && l2 != null){
            temp = l2.val - l1.val > 0? l1 : l2;
            if(head == null) {
                head = temp;
                tail = head;
            }
            else {
                tail.next = temp;
                tail = tail.next;
            }
            
            if(l2.val - l1.val > 0)
                l1 = l1.next;
            else
                l2 = l2.next;
        }
        
        temp = (l1 == null) ? l2 : l1; 
        
        if(head == null){
            head = temp;
        } else {
            tail.next = temp;
        }
        
        return head;
    }
}
public class MergeLinkedList {

}
