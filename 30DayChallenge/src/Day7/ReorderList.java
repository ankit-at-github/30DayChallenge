package Day7;

class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class ReorderList {
	
	public static ListNode middle(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Linked List is given you need to put it in following order (L1 -> Ln -> L2 -> Ln-1 -> L3 -> Ln-2)
		
		//There are 3 concepts used here
		
		//Finding middle element
		
		ListNode head = null; //{1->2->3->4->5->6}
        
        //finding middle of the LinkedList
        ListNode slow = middle(head);
        
        //Reverse elements n - middle + 1
        ListNode prev = null;
        ListNode nxt = slow.next;
        
        while(nxt!=null)
        {
            slow.next = prev;
            prev = slow;
            slow = nxt;
            nxt = nxt.next;
        }
        slow.next = prev;
        
        //Merge both list
        
        ListNode temp;
        
        while(slow.next!=null)
        {
            temp = head.next;
            head.next = slow;
            head = temp;
            
            temp = slow.next;
            slow.next = head;
            slow = temp;
        }
        
        //Output {1->6->2->5->3->4}
        
	}

}
