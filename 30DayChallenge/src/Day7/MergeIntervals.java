package Day7;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
		
		List<int[]> ans = new ArrayList<>();
		
		for(int[] interval : intervals)
		{
			if(ans.isEmpty() || ans.get(ans.size() - 1)[1] < interval[0]) ans.add(interval);
			else
			{
				ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], interval[1]);
			}
		}
		
		System.out.print("[");
		for(int[] a : ans) System.out.print("["+a[0]+","+a[1]+"]");
		System.out.println("]");
		
		
	}

}
