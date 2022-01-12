package Day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Rat {
	
	public static boolean isSafe(int x, int y, int n, int[][] visited, int[][] m)
	{
		if((x>=0 && x<n) && (y>=0 && y<n) && (visited[x][y]==0) && (m[x][y]==1)) return true;
		else return false;
	}
	public static void solve(int[][] m, int n, int x, int y, int[][] visited, List<String> ans, StringBuilder path)
	{
		if(x == n-1 && y == n-1)
		{
			ans.add(path.toString());
			return;
		}
		
		visited[x][y] = 1;
		
		//4 choices to go - D/L/R/U
		
		//down
		int newX = x+1;
		int newY = y;
		
		if(isSafe(newX, newY, n, visited, m))
		{
			path.append('D');
			solve(m, n, newX, newY, visited, ans, path);
			path.deleteCharAt(path.length()-1);
		}
		
		//left
		newX = x;
		newY = y-1;
		if(isSafe(newX, newY, n, visited, m))
		{
			path.append('L');
			solve(m, n, newX, newY, visited, ans, path);
			path.deleteCharAt(path.length()-1);
		}
		
		//right
		newX = x;
		newY = y+1;
		if(isSafe(newX, newY, n, visited, m))
		{
			path.append('R');
			solve(m, n, newX, newY, visited, ans, path);
			path.deleteCharAt(path.length()-1);
		}
		
		//up
		newX = x-1;
		newY = y;
		if(isSafe(newX, newY, n, visited, m))
		{
			path.append('U');
			solve(m, n, newX, newY, visited, ans, path);
			path.deleteCharAt(path.length()-1);
		}
		
		visited[x][y] = 0;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] matrix = {{1,0,0,0},{1,1,0,1},{1,1,0,0},{0,1,1,1}};
		int n = 4;
		
		int[][] visited = new int[n][n];
		
		for(int i=0; i<n; i++)
		Arrays.fill(visited[i], 0);
		
		int srcx = 0, srcy = 0;
		
		List<String> ans = new ArrayList<>();
		
		StringBuilder path = new StringBuilder();
		
		solve(matrix, n, srcx, srcy, visited, ans, path);
		
		Collections.sort(ans);
		
		System.out.println(ans);

	}

}
