package scramble_string;

import java.util.HashMap;

class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        if (s1.equals(s2)) return true;
        int len = s1.length();
        HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();
        for (int i = 0; i < len - 1; i ++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            char c3 = s2.charAt(len - 1 - i);
            
            if (c1 != c2) {
            	if (!map1.containsKey(c1)) {
            		map1.put(c1, 1);
            	} else {
            		int value = map1.get(c1);
                	if (value != -1) map1.put(c1, value + 1); else map1.remove(c1);
            	}
            	
            	if (!map1.containsKey(c2)) {
            		map1.put(c2, -1); 
            	} else {
            		int value = map1.get(c2);
                	if (value != 1) map1.put(c2, value - 1); else map1.remove(c2);
            	}
            }
            if (map1.isEmpty() && isScramble(s1.substring(0, i+1), s2.substring(0, i+1)) && isScramble(s1.substring(i+1, len), s2.substring(i+1, len))) return true;
            
            if (c1 != c3) {
            	if (!map2.containsKey(c1)) {
            		map2.put(c1, 1);
            	} else {
            		int value = map2.get(c1);
                	if (value != -1) map2.put(c1, value + 1); else map2.remove(c1);
            	}
            	
            	if (!map2.containsKey(c3)) {
            		map2.put(c3, -1); 
            	} else {
            		int value = map2.get(c3);
                	if (value != 1) map2.put(c3, value - 1); else map2.remove(c3);
            	}
            }
            if (map2.isEmpty() && isScramble(s1.substring(0, i+1), s2.substring(len-i-1, len)) && isScramble(s1.substring(i+1, len), s2.substring(0, len-i-1))) return true;
        }
		return false;
    }
}
