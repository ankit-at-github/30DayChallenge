package Day15;

public class KadaneAlgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Finding maximum sub-array sum. Main Purpose is to get the subarray which gives maximum sum.
		//Algorithm: We carry a Subarray Sum as long as it gives positive sum.
		
		int[] nums = {-2,-3,4,-1,-2,1,5,3};
		
		int max = Integer.MIN_VALUE;
		
		int sum = 0;
		
		for(int i=0; i<nums.length; i++)
		{
			sum+=nums[i];
			
			sum = Math.max(sum, nums[i]);
			
			max = Math.max(max, sum);
		}
		
		System.out.println(max);

	}

}
