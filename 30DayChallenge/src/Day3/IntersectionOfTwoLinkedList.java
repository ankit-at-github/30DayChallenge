package Day3;

public class IntersectionOfTwoLinkedList {

	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ptrA = headA;
        ListNode ptrB = headB;
        
        while(ptrA!=ptrB)
        {
            ptrA = ptrA==null ? headA:ptrA.next;
            ptrB = ptrB==null ? headB:ptrB.next;
        }
        return ptrA;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getIntersectionNode(null,null));
	}

}
