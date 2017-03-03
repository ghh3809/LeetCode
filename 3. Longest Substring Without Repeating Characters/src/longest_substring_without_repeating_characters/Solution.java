package longest_substring_without_repeating_characters;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] posi = new int[128];
        for (int i = 0; i < 128; i ++) {
            posi[i] = -1;
        }
        int posiAtNoDiff = 0;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i ++) {
            int val = s.charAt(i);
            if (posi[val] >= posiAtNoDiff) {
                posiAtNoDiff = posi[val] + 1;
            } else {
                maxLength = (i - posiAtNoDiff + 1 > maxLength) ? i - posiAtNoDiff + 1 : maxLength;
            }
            posi[val] = i;
        }
        return maxLength;
    }
}
