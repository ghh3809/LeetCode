package longest_common_prefix;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder prefix = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < strs[0].length(); i ++) {
            for (int j = 1; j < strs.length; j ++) {
                if ((strs[j].length() > i) && (strs[j].charAt(i) == strs[0].charAt(i))) {
                    continue;
                } else {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                prefix.append(strs[0].charAt(i));
            } else {
                break;
            }
        }
        return prefix.toString();
    }
}
