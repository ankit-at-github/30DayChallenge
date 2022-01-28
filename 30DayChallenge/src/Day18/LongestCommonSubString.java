package Day18;

public class LongestCommonSubString {
	public static int findLCSubString(int[] nums1, int[] nums2, int m, int n, int[][] dp)
	{
		//The reason we are storing max in a variable because max substring can be any where since it has to
		//be continuous.
		int result = 0;
		
		for(int i=1; i<m+1; i++)
		{
			for(int j=1; j<n+1; j++)
			{
				if(nums1[i-1] == nums2[j-1])
				{
					dp[i][j] = 1 + dp[i-1][j-1];
					result = Math.max(result, dp[i][j]);
				}
				else dp[i][j] = 0; //else 0 because if character or element don't match start the count from beginning as the count becomes discontinuous
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Here, we are using Array instead of two Strings but the idea is same.
		
		int[] nums1 = {1,2,3,2,1};
		int[] nums2 = {3,2,1,4,7};
		
		int m = nums1.length;
		int n = nums2.length;
		
		int[][] dp = new int[m+1][n+1];
		
		System.out.println("Maximum Length of Repeated Subarray: "+findLCSubString(nums1, nums2, m, n, dp));

	}

}
