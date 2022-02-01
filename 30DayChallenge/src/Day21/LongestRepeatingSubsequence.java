package Day21;

public class LongestRepeatingSubsequence {
	public static int LRS(String a, String b, int m, int n, int[][]dp){
        for(int i=1; i<m+1; i++)
        {
            for(int j=1; j<n+1; j++)
            {
            	//Character at same index should not be taken
                if(a.charAt(i-1) == b.charAt(j-1) && i!=j)
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
		
		String st = "AABCBDC";
		int n = st.length();
		
		System.out.println("String: "+st);
		
		StringBuilder sb = new StringBuilder(st);
        
        int[][] dp = new int[n+1][n+1];
        
        System.out.println("Longest Repeating Subsequence: "+LRS(st, sb.toString(), n, n, dp));
	}

}
