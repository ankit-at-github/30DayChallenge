package Day15;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithGivenSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Array contains positive and negative integers, we need to find subarray that gives maximum sum.
		
		//If only given to solve using positive integers then we can use variable size sliding window approach
		//where we use two pointers to maintain the size of window depending on the sum<k or greater than k.
		
		//Here inputs integers can be negative so sliding window appraco will not work, we need to solve this
		//using prefixSum approach and maintaing the sum in the map if seen.
		
		//int[] nums = {10, 2, -2, -20, 10};
		//int k = -10;
		
		int[] nums = {6, -1, -1, 1, 1,1,1,1,0};
		int k = 5;
		
		Map<Integer, Integer> prefixSum = new HashMap<>();
		int sum = 0;
		int count = 0;
		
		Map<Integer, Integer> largestSubArray = new HashMap<>();
		int maxi = 0;
		int start = 0;
		
		for(int i=0; i<nums.length; i++)
		{
			sum+= nums[i];
			
			//To get the count of subarray with given sum K
			if(sum==k) 
			{
				count++;
				start = 0;
				maxi = Math.max(maxi, i - start);
			}
			
			
			if(prefixSum.containsKey(sum - k)) count+=prefixSum.get(sum - k);
			prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);
			
			
			//To get the largest subarray that gives the sum K.
			if(largestSubArray.containsKey(sum - k))
			{
				start = largestSubArray.get(sum - k) + 1;
				
				maxi  = Math.max(maxi, i-start);
			}
			largestSubArray.put(sum, i);
			
		}
		
		System.out.println("Total number of subarray with given sum K are: "+count);
		
		System.out.println("Size of largest subArray that gives the sum K is: "+(maxi+1));
		
	}

}
