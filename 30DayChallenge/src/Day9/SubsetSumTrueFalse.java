package Day9;

public class SubsetSumTrueFalse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Find if subset is poosible from given set to get the sum equal to k;
		int[] matrix = {2,3,7,8,10};
		int sum = 14;
		
		int n = matrix.length;
		
		boolean[][] dp = new boolean[n+1][sum+1];
		
		for(int i=0; i<n+1; i++) dp[i][0] = true;
		
		for(int i=1; i<n+1; i++)
		{
			for(int j=1; j<sum+1; j++)
			{
				if(matrix[i-1] <= j) dp[i][j] = dp[i-1][j - matrix[i-1]] || dp[i-1][j];
				else dp[i][j] = dp[i-1][j]; 
			}
		}
		
		System.out.println("Sub-Set Sum is Possible: " + dp[n][sum]);
	}

}
