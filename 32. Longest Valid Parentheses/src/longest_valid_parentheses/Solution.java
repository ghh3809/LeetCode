package longest_valid_parentheses;

public class Solution {
    public int longestValidParentheses(String s) {
		int[] netMap = new int[s.length()+1];
		int net = 0, maxLength = 0;
		if (s.length() > 0) netMap[0] = -1;
		for (int i = 0; i < s.length(); i ++) {
			if (s.charAt(i) == '(') netMap[++net] = i;
			else if (--net >= 0) { if (i-netMap[net] > maxLength) maxLength = i-netMap[net]; }
			else netMap[net=0] = i;
		}
		return maxLength;
    }
}