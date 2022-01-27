package Day17;

public class LCSubsequence {
	public static int findLCS(String text1, String text2, int m, int n, int[][] dp)
	{
		if(n==0 || m==0) return 0;
		
		for(int i=1; i<m+1; i++)
		{
			for(int j=1; j<n+1; j++)
			{
				if(text1.charAt(i-1) == text2.charAt(j-1))
				{
					//last characters are same move ahead with others
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
		//Given two strings we need to find length of longest common subsequence.
		
		String text1 = "abcde", text2 = "ace" ;
		
		System.out.println("Text1: " +text1);
		System.out.println("Text2: " +text2);
		
		int m = text1.length();
		int n = text2.length();
		
		int[][] dp = new int[m+1][n+1];
		
		System.out.println("Length of Longest Common SubSequence: "+findLCS(text1, text2, m, n, dp));
		

	}

}
