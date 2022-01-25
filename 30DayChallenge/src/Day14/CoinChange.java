package Day14;

public class CoinChange {
	public static int solveKnapsack(int[] coins, int n, int amount, int[][] dp)
    {
        for(int i=2; i<n+1; i++)
        {
            for(int j=1; j<amount+1; j++)
            {
                if(coins[i-1] <= j) dp[i][j] = Math.min((1 + dp[i][j - coins[i-1]]), dp[i-1][j]);
                else dp[i][j] = dp[i-1][j];
            }
        }
        if(dp[n][amount] == Integer.MAX_VALUE - 1) return -1;
        else return dp[n][amount];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins = {1,2,5};
		int amount = 11;
		
		int n = coins.length;
        
        int[][] dp = new int[n+1][amount+1];
        
        for(int i=0; i<n+1; i++) dp[i][0] = 0;
        for(int j=0; j<amount+1; j++) dp[0][j] = Integer.MAX_VALUE - 1;
        for(int j=1; j<amount+1; j++)
        {
            if(j%coins[0] == 0) dp[1][j] = j/coins[0];
            else dp[1][j] = Integer.MAX_VALUE - 1;
        }
        
        System.out.println(solveKnapsack(coins, n, amount, dp));

	}

}
