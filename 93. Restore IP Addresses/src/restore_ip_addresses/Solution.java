package restore_ip_addresses;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        result.add("");
        for (int steps = 0; steps < 4; steps ++) {
            List<String> newResult = new ArrayList<String>();
            for (String current : result) {
                int index = current.length() - steps;
                if (index < s.length()) {
                    newResult.add(current + s.substring(index, index + 1) + '.');
                }
                if ((index < s.length() - 1) && (s.charAt(index) != '0')) {
                    newResult.add(current + s.substring(index, index + 2) + '.');
                }
                if ((index < s.length() - 2) && (s.substring(index, index + 3).compareTo("100") >= 0) && (s.substring(index, index + 3).compareTo("256") < 0)) {
                    newResult.add(current + s.substring(index, index + 3) + '.');
                }
            }
            result = newResult;
        }
        List<String> finalResult = new ArrayList<String>();
        for (String res : result) {
            if (res.length() == s.length() + 4) {
                finalResult.add(res.substring(0, res.length() - 1));
            }
        }
        return finalResult;
    }
    
    public static void main(String args[]) {
    	System.out.println(new Solution().restoreIpAddresses("25525511135"));
    }
}
