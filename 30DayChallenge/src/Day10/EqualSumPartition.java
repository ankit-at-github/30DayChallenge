package Day10;

import java.util.Arrays;

public class EqualSumPartition {
	static void subsetSum(int[] nums, int sum, int n)
	{
		boolean[][] dp = new boolean[n+1][sum+1];
		
		for(int i=0; i<n+1; i++) Arrays.fill(dp[i], true);
		
		for(int i=1; i<n+1; i++)
		{
			for(int j=1; j<sum+1; j++)
			{
				if(nums[i-1] <= j) dp[i][j] = dp[i-1][j - nums[i-1]] || dp[i-1][j];
				else dp[i][j] = dp[i-1][j];
			}
		}
		
		System.out.println(dp[n][sum]);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Given a non-empty array nums containing only positive integers,
		//find if the array can be partitioned into two subsets such that the sum of elements in 
		//both subsets is equal.
		
		int[] nums = {1,5,11,5};
		
		//so the logic is the equal sum partition is possible only when sum of all elements in an array is equal
		//and even number as then only it can be divided into two sub parts with equal sum; 2s = s+s
		int sum = 0;
		
		for(int n : nums) sum+=n;
		
		if((sum&1) == 1) System.out.println("Not Possible");
		else subsetSum(nums, sum/2, nums.length);
	}

}
