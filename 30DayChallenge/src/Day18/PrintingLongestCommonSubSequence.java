package Day18;

public class PrintingLongestCommonSubSequence {
	public static void printLCS(String X, String Y, int i, int j, int[][] dp)
	{
		StringBuilder sb = new StringBuilder();
		
		while(i>0 && j>0)
		{
			if(X.charAt(i-1) == Y.charAt(j-1))
			{
				sb.append(X.charAt(i-1));
				i--;
				j--;
			}
			else
			{
				if(dp[i][j-1] > dp[i-1][j])
				{
					j--;
				}
				else
				{
					i--;
				}
			}
		}
		
		System.out.println("Longest Common Subsequence is: "+sb.reverse().toString());
		
	}
	public static void LCS(String X, String Y, int m, int n, int[][] dp)
	{
		for(int i=1; i<m+1; i++)
		{
			for(int j=1; j<n+1; j++)
			{
				if(X.charAt(i-1) == Y.charAt(j-1))
				{
					dp[i][j] = 1 + dp[i-1][j-1];
				}
				else
				{
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		System.out.println("Length of Longest Common Subsequence is: "+dp[m][n]);
		printLCS(X, Y, m, n, dp);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//We need to Print the Longest Common SubSequence between two characters.
		
		String X = "AGGTAB";
        String Y = "GXTXAYB";
        int m = X.length();
        int n = Y.length();
        
        int[][] dp = new int[m+1][n+1];
        
       //Here, we initializing the first row and first column with zero. By default, array is assigned 0 in Java.
        
        LCS(X, Y, m, n, dp);

	}

}
