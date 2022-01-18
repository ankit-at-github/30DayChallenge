package Day7;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervalsApproach2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
		
		List<List<Integer>> ans = new ArrayList<>();
        int[] start = new int[10001];
        int[] end = new int[10001];
        
        for(int[] interval : intervals)
        {
            start[interval[0]]++;
            end[interval[1]]--;
        }
        
        List<Integer> present = new ArrayList<>();
        int curr = 0;
        for(int i=0; i<10001; i++)
        {
            curr+=start[i];
            if(curr!=0)
            {
                if(present.size()==0) present.add(i);
                curr+=end[i];
                if(curr==0)
                {
                    present.add(i);
                    ans.add(present);
                    present = new ArrayList<>();
                }
            }
        }
        
       for(List l : ans) System.out.print(l);

	}

}
