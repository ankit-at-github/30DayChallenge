package Day22;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongesIncreasingSubsequence {
	public static int LIS(int[] nums, Integer[] num, int m, int n, int[][] dp)
	{
		for(int i=1; i<m+1; i++)
		{
			for(int j=1; j<n+1; j++)
			{
				if(nums[i-1] == num[j-1])
				{
					dp[i][j] = 1 + dp[i-1][j-1];
				}
				else 
				{
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		return dp[m][n];
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Given an integer array nums, 
		//return the length of the longest strictly increasing subsequence. [4]
		
		
		//This question clears multiple concepts and usage of java function.
		
		//Steps to find LIS
		//1. Array2 = Replicate(Array1)
		//2. Sort(Array 2) and remove duplicates. or remove duplicates and sort array
		//3. Find LCS between Array1 and Array2, length of LCS is the answer.
		
		int[] nums = {0,3,1,6,2,2,7};
		
		System.out.print("Given Array: ");
		
		for(int x : nums) System.out.print(x+" ");
		System.out.println();
		
		Set<Integer> unique = new HashSet<>();
		
		for(int x : nums) unique.add(x);
		
		Integer[] num = new Integer[unique.size()];
		
		num = unique.toArray(num);
		
		Arrays.sort(num);
		
		int m = nums.length;
		int n = num.length;
		
		int[][] dp = new int[m+1][n+1];
		
		System.out.println("Length of Longest Increasing Subsequence: "+LIS(nums, num, m, n, dp));
		
		
		
		

	}

}
