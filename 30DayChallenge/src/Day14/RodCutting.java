package Day14;

public class RodCutting {
	public static int solveKnapsack(int[] length, int n, int[] price, int[][] dp)
    {
        for(int i = 1; i<n+1; i++)
        {
            for(int j=1; j<n+1; j++)
            {
                if(length[i-1] <= j)
                dp[i][j] = Math.max((price[i-1] + dp[i][j-length[i-1]]),
                                   dp[i-1][j]);
                else dp[i][j] = dp[i-1][j];
            }
        }
        
        return dp[n][n];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Given rod
		
		int N = 5;
		int[] price = {2,5,7,8,10};
		
		int[] length = new int[N];
		int sizeofArray = length.length;
		
        for(int i=0; i<N; i++) length[i] = i+1;
        
        int[][] dp = new int[sizeofArray+1][N+1];
        
        for(int i=0; i<N+1; i++) dp[i][0] = 0;
        
        System.out.println(solveKnapsack(length, N, price, dp));
		

	}

}
