package Day21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
	public static void solve(int[] candidates, int index, List<Integer> ans, List<List<Integer>> output, int target)
	{
		if(target==0)
		{
			output.add(new ArrayList(ans));
			return;
		}
		
		for(int i=index; i<candidates.length; i++)
		{
			if(i>index && candidates[i]==candidates[i-1]) continue;
			if(candidates[i] > target) break;
			
			ans.add(candidates[i]);
			solve(candidates, i+1, ans, output, target - candidates[i]);
			ans.remove(ans.size()-1);
			
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Given a collection of candidate numbers (candidates) and a target number (target), 
		//find all UNIQUE combinations in candidates where the candidate numbers sum to target.
		
		int[] candidates = {10,1,2,7,6,1,5};
		int target = 8;
		
		List<List<Integer>> output = new ArrayList<>();
		List<Integer> ans = new ArrayList<>();
		
		Arrays.sort(candidates);
		
		solve(candidates, 0, ans, output, target);
		
		System.out.println(output);
		
		
	}

}
