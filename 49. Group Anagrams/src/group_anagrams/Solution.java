package group_anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
	public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, List<String>> hashMap = new HashMap<>();
		for (String str : strs) {
			char[] ca = str.toCharArray();
			Arrays.sort(ca);
			String key = new String(ca);
			if (!hashMap.containsKey(key)) {
				hashMap.put(key, new ArrayList<String>());
			}
			hashMap.get(key).add(str);
		}
	    return new ArrayList<List<String>>(hashMap.values());
	}
}
