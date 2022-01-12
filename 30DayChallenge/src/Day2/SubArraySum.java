package Day2;

import java.util.HashMap;
import java.util.Map;

public class SubArraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//The idea is to find continuous sub array sum equal to k;
		
		int[] nums = {3, 4, 7, 2, -3, 1, 4, 2};
		int k = 7;
		
		int sum = 0;
		int count = 0;
		
		Map<Integer, Integer> preSum = new HashMap<>();
		preSum.put(0, 1);
		
		for(int i=0; i<nums.length; i++)
		{
			sum+=nums[i];
			
			if(preSum.containsKey(sum - k)) count+= preSum.get(sum-k);
			
			//If present increment the occurrence by 1.
			preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
			
		}
		
		System.out.println(count);

	}

}
