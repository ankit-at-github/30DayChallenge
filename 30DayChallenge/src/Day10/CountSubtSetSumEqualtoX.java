package Day10;

public class CountSubtSetSumEqualtoX {
	static int subsetSum(int a[], int n, int sum)
	{
		int[][] dp = new int[n+1][sum+1];
		
		for(int j=0; j<sum+1; j++) dp[0][j] = 0;
		for(int i=0; i<n+1; i++) dp[i][0] = 1;
		
		for(int i=1; i<n+1; i++)
		{
		    for(int j=1; j<sum+1; j++)
		    {
		        if(a[i-1] <= j) dp[i][j] = dp[i-1][j - a[i-1]] + dp[i-1][j];
		        else dp[i][j] = dp[i-1][j];
		    }
		}
		
		return dp[n][sum];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		int a[] = { 2, 3, 5, 6, 8, 10 };
		int sum = 10;

		System.out.print(subsetSum(a, n, sum));

	}

}
