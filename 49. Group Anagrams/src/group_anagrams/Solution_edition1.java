package group_anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution_edition1 {
	public class MyCharArray {
		int[] data;
		public MyCharArray(int[] data) {
			this.data = data;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			for (int i = 0; i < data.length; i ++) {
				result = prime * result + data[i];
			}
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			MyCharArray other = (MyCharArray) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (!Arrays.equals(data, other.data))
				return false;
			return true;
		}

		private Solution_edition1 getOuterType() {
			return Solution_edition1.this;
		}
	}
    public List<List<String>> groupAnagrams(String[] strs) {
    	List<List<String>> result = new ArrayList<>();
    	HashMap<MyCharArray, ArrayList<String>> hashMap = new HashMap<>();
    	for (String str : strs) {
    		int[] charNum = new int[26];
    		for (int i = 0; i < str.length(); i ++) {
    			char c = str.charAt(i);
    			charNum[c - 'a'] ++;
    		}
    		MyCharArray mca = new MyCharArray(charNum);
    		if (!hashMap.containsKey(mca)) {
    			hashMap.put(mca, new ArrayList<String>());
    		}
    		hashMap.get(mca).add(str);
    	}
        for (MyCharArray mca : hashMap.keySet()) {
        	result.add(hashMap.get(mca));
        }
        return result;
    }
}
