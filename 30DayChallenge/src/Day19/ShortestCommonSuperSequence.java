package Day19;

public class ShortestCommonSuperSequence {
	public static String SCS(String str1, String str2, int i, int j, int[][]dp)
	{
		StringBuilder sb = new StringBuilder();
		
		while(i>0 && j>0)
		{
			if(str1.charAt(i-1) == str2.charAt(j-1))
			{
				sb.append(str1.charAt(i-1));
				i--;
				j--;
			}
			else
			{
				if(dp[i-1][j] > dp[i][j-1])
				{
					sb.append(str1.charAt(i-1));
					i--;
				}
				else
				{
					sb.append(str2.charAt(j-1));
					j--;
				}
			}
		}
		
		while(i>0)
		{
			sb.append(str1.charAt(i-1));
			i--;
		}
		
		while(j>0)
		{
			sb.append(str2.charAt(j-1));
			j--;
		}
		
		return sb.reverse().toString();
		
	}
	public static void LCS(String str1, String str2, int m, int n, int[][] dp)
	{
		for(int i=1; i<m+1; i++)
		{
			for(int j=1; j<n+1; j++)
			{
				if(str1.charAt(i-1) == str2.charAt(j-1))
				{
					dp[i][j] = 1 + dp[i-1][j-1];
				}
				else
				{
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str1 = "abac";
		String str2 = "cab";
		
		System.out.println("String 1: "+str1);
		System.out.println("String 2: "+str2);
		
		int m = str1.length();
		int n = str2.length();
		
		int[][] dp = new int[m+1][n+1];
		
		LCS(str1, str2, m, n, dp);
		
		System.out.println("Shortest Common SuperSequence: "+SCS(str1, str2, m, n, dp));
		
	}

}
