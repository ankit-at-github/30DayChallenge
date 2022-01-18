package Day8;

public class KnapsackDP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int val[] = { 60, 100, 120 };
	    int wt[] = { 10, 20, 30 };
	    int W = 50;
	    
	    int n = val.length;
	    
	    int[][] dp = new int[n+1][W+1];
	    
	    
	    //If 0/no item is chose so then there is not profit so filling 1st row with 0.
	    for(int j=0; j<W+1; j++) dp[0][j] = 0;
	    
	    //If knapsack weight is 0, there is no profit so filling 1st column with 0.
	    for(int i=0; i<n+1; i++) dp[i][0] = 0;
	    
	    //Iterative approach to find maiximum profit.
	    for(int i=1; i<n+1; i++)
	    {
	    	for(int j=1; j<W+1; j++)
	    	{
	    		if(wt[i-1] <= j)
	    			dp[i][j] = Math.max((val[i-1] + dp[i-1][j - wt[i-1]]), dp[i-1][j]);
	    		else
	    			dp[i][j] = dp[i-1][j];
	    	}
	    }
	    
	    System.out.println("Maximum Profit: "+ dp[n][W]);

	}

}
