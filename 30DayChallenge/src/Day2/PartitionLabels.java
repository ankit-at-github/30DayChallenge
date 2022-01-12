package Day2;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Given a String partition the string in such a way where each character appears in its own partition.
		//Print length of each partition of a string.
		
		List<Integer> ans = new ArrayList<>();
		
		String s = "ababcbacadefegdehijhklij";
		
		//finding lastIndex of each character as that will be the minimum partition of a string for a character.
		int[] lastIndex = new int[26];
		
		for(int i=0; i<s.length(); i++) lastIndex[s.charAt(i) - 'a'] = i;
		
		int end = 0, lastValue = 0;
		
		for(int i=0; i<s.length(); i++)
		{
			end = Math.max(end, lastIndex[s.charAt(i) - 'a']);
			
			if(i == end)
			{
				ans.add(end - lastValue + 1);
				lastValue = end+1;
			}
		}
		
		System.out.println(ans);
		
	}

}
