package Day30;

import java.util.PriorityQueue;

public class KthLargestElementinStream {
	
	PriorityQueue<Integer> pq;
	int k;
	
	KthLargestElementinStream(int k, int[] nums)
	{
		pq = new PriorityQueue<>();
		this.k = k;
		
		//Added all elements in the Priority Queue
		for(int x : nums) pq.add(x);
		
		//Now to get the Kth largest element from Priority Queue which stores elements in ascending order,
		//we will maintain only K elements in the stream/priority queue and return the top element as answer.
		
		while(pq.size() > k) pq.poll();
		
	}
	public  int add(int val)
	{
		pq.add(val);
		
		if(pq.size() > k) pq.poll();
		
		return pq.peek();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//This code will return the Kth Largest element in the stream;
		//We will maintain priority queue to store elements in order
		
		int k = 3;
		int[] nums = {4, 5, 8, 2};
		
		KthLargestElementinStream obj = new KthLargestElementinStream(k, nums);
		
		System.out.println(obj.add(9));
		System.out.println(obj.add(3));
		System.out.println(obj.add(6));
	}

}
