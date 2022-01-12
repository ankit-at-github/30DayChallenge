package Day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] strs = {"eat","tea","tan","ate","nat","bat"}; 
		
		List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> groups = new HashMap<>();
        
        int[] freq = new int[26];
        for(String s : strs)
        {
            Arrays.fill(freq,0);
            char[] charArray = s.toCharArray();
            for(char c : charArray) freq[c-'a']++;
            
            StringBuilder sb = new StringBuilder("");
            for(int i=0; i<26; i++)
            {
                sb.append(freq[i]);
                sb.append('#');
            }
            
            String key = sb.toString();
            
            if(!groups.containsKey(key)) groups.put(key, new ArrayList<>());
            groups.get(key).add(s); //getting the ArrayList();
        }
        
        System.out.println(groups.values());
        

	}

}
