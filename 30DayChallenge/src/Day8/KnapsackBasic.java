package Day8;

import java.util.Arrays;

public class KnapsackBasic {
	public static int profitKnapsack(int[] val, int[] wt, int W, int n, int[][] dp)
	{
		if(n==0 || W==0) return 0;
		
		if(dp[n][W]!= -1) return dp[n][W];
		
		if(wt[n-1] <= W) return dp[n][W] = Math.max((val[n-1] + profitKnapsack(val, wt, W-wt[n-1], n-1, dp)),
				profitKnapsack(val, wt, W, n-1, dp));
		
		else return dp[n][W] = profitKnapsack(val, wt, W, n-1, dp);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Given weights and values of n items, put these items in a knapsack of capacity W to get the 
		//maximum total value in the knapsack.
		
		int val[] = { 60, 100, 120 };
	    int wt[] = { 10, 20, 30 };
	    int W = 50;
	    
	    int n = val.length;
	    
	    int[][] dp = new int[n+1][W+1];
	    
	    for(int i=0; i<n+1; i++) Arrays.fill(dp[i], -1);
	    
	    System.out.println("Maximum Profit: "+profitKnapsack(val, wt, W, n, dp));
	    

	}

}
