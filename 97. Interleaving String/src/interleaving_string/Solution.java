package interleaving_string;

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length()) return false;
        if (s1.length() == 0) return s2.equals(s3);
        if (s2.length() == 0) return s1.equals(s3);
        boolean[][] paths = new boolean[s1.length() + 1][s2.length() + 1];
        paths[0][0] = true;
        for (int i = 0; i < s3.length(); i ++) {
            char c = s3.charAt(i);
            for (int j = 0; j <= i; j ++) {
            	if ((j < s1.length()) && (i-j <= s2.length())) {
                	if (s1.charAt(j)   == c) paths[j+1][i-j] = paths[j+1][i-j] || paths[j][i-j];
                }
                if ((j <= s1.length()) && (i-j < s2.length())) {
                	if (s2.charAt(i-j) == c) paths[j][i-j+1] = paths[j][i-j+1] || paths[j][i-j];
                }
            }
        }
        return paths[s1.length()][s2.length()];
    }
}
