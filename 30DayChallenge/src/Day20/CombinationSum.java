package Day20;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
	public static void solve(int[] candidates, int index, List<Integer> ans, List<List<Integer>> output, int target)
    {
        if(index >= candidates.length || target <= 0)
        {
            if(target==0) output.add(new ArrayList(ans));
            return;
        }
        
        solve(candidates, index+1, ans, output, target);
        
        
        ans.add(candidates[index]);
        solve(candidates, index, ans, output, target - candidates[index]);
        ans.remove(ans.size()-1);
        
        
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Given an array of distinct integers candidates and a target integer target,
		//return a list of all unique combinations of candidates where the chosen numbers sum to target.
		//You may return the combinations in any order.
		
		
		int[] candidates = {2,3,6,7};
		int target = 7;
		
		List<List<Integer>> output = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        
        solve(candidates, 0, ans, output, target);
        
        System.out.println(output);
		

	}

}
