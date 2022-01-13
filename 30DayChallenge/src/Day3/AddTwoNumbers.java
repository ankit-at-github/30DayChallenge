package Day3;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class AddTwoNumbers {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ListNode l1 = new ListNode(9);
		ListNode l2 = new ListNode(1);
		
		ListNode temp = new ListNode();
        ListNode dummy = temp;
        
        ListNode ptr1 = l1, ptr2 = l2;
        int carry = 0;
        
        while(ptr1!=null || ptr2!=null)
        {
            int value1 = (ptr1!=null ? ptr1.val:0);
            int value2 = (ptr2!=null ? ptr2.val:0);

            int value = value1 + value2 + carry;
            
            temp.next = new ListNode(value%10);
            temp = temp.next;
            carry = value/10;
            
            if(ptr1!=null)ptr1 = ptr1.next;
            if(ptr2!=null)ptr2 = ptr2.next;
        }
        
        if(carry>0) temp.next = new ListNode(carry);
        
        while(dummy.next!=null)
        {
        	dummy = dummy.next;
        	System.out.print(dummy.val);
        }
	}

}
