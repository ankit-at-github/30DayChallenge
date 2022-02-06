package Day26;

public class LongestPalindromicSubstring {
	public static String LPS(String s, String sb, int m, int n, int[][] dp)
	{
		StringBuilder ans = new StringBuilder();
		int max = 0;
		
		for(int i=1; i<m+1; i++)
		{
			for(int j=1; j<n+1; j++)
			{
				if(s.charAt(i-1) == sb.charAt(j-1))
				{
					dp[i][j] = 1 + dp[i-1][j-1];
					//if found subsequence which is greater than previous, check whether substring found
					//is palindrome or not.
					if(dp[i][j] > max)
					{
						String forward = s.substring(i-dp[i][j], i);
						StringBuilder backward = new StringBuilder(forward);
						backward.reverse();
						if(forward.equals(backward.toString()))
						{
							ans.delete(0, ans.length());
							ans.append(forward);
							max = dp[i][j];
						}
					}
				}
				else
				{
					dp[i][j] = 0; //Substring is always continuous
				}
			}
		}
		
		
		return ans.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aacabdkacaa";
		StringBuilder sb = new StringBuilder(s);
		
		System.out.println("String: "+ s);
		
		int m = s.length();
		int n = sb.length();
		
		int[][] dp = new int[m+1][n+1];
		
		String ans = LPS(s, sb.reverse().toString(), m, n, dp);
		
		System.out.println("Longest Palindromic Substring: "+ans);
		
	}

}
