package Day19;

public class LongestPalindromicSubSequence {
	public static int LPS(String s, String sb, int m, int n, int[][] dp)
	{
		for(int i=1; i<m+1; i++)
		{
			for(int j=1; j<n+1; j++)
			{
				if(s.charAt(i-1) == sb.charAt(j-1))
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
		
		//Given a string, find it's Longest Palindromic Subsequence
		
		String s = "bbbab";
		
		System.out.println("String s: "+s);
		
		int m = s.length();
		
		StringBuilder sb = new StringBuilder(s);
		
		int[][] dp = new int[m+1][m+1];
		
		System.out.println("Length of Longest Palindromic Subsequence: "+LPS(s, sb.reverse().toString(), m, m, dp));

	}

}
