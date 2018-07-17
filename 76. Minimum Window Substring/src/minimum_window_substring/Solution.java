package minimum_window_substring;

public class Solution {
	public String minWindow(String s, String t) {
        char[] target = new char[128];
        char[] current = new char[128];
        int ind1 = 1, ind2 = 0, minLen = s.length() + 1;
        for (int i = 0; i < t.length(); i ++) {
            target[t.charAt(i)] ++;
        }
        int first = 0, last = 0;
        while (true) {
            while (!isLarger(current, target)) {
                if (last >= s.length()) return s.substring(ind1 - 1, ind2);
                current[s.charAt(last ++)] ++;
            }
            while(isLarger(current, target)) {
                current[s.charAt(first ++)] --;
            }
            if (last - first < minLen) {
                ind1 = first;
                ind2 = last;
                minLen = ind2 - ind1;
            }
        }
    }
    public boolean isLarger(char[] current, char[] target) {
        for (int i = 0; i < target.length; i ++) {
            if (current[i] < target[i]) return false;
        }
        return true;
    }
}
