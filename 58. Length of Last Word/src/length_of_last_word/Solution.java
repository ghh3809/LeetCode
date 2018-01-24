package length_of_last_word;

class Solution {
    public int lengthOfLastWord(String s) {
        int currentLen = 0;
        for (int i = s.length() - 1; i >= 0; i --) {
            if (s.charAt(i) != ' ') currentLen ++;
            else if (currentLen != 0) break;
        }
        return currentLen;
    }
}
