package wildcard_matching;

public class Solution {
    public boolean isMatch(String s, String p) {
        int lasti = -1, lastj = -1;
        int i = 0, j = 0;
        while ((i <= p.length()) && (j <= s.length())) {
        	if (((i == 0) && (j == 0)) || (p.charAt(i-1) == '*') || (p.charAt(i-1) == '?') || (p.charAt(i-1) == s.charAt(j-1))) {
        		if ((i == p.length()) && (j == s.length())) return true;
        		if ((i > 0) && (p.charAt(i-1) == '*')) {
        			lasti = i;
        			lastj = j;
        		}
        		if (i < p.length()) {
        			if (p.charAt(i) == '*') i ++;
        			else if (j < s.length()) { i ++; j ++; }
        			else {
        				if (lasti > 0) {
        					i = lasti;
        					j = ++ lastj;
        				} else return false;
        			}
        		} else {
        			if (lasti > 0) {
    					i = lasti;
    					j = ++ lastj;
    				} else return false;
        		}
        	} else {
        		if (lasti > 0) {
					i = lasti;
					j = ++ lastj;
				} else return false;
        	}
        }
        return false;
    }
}
