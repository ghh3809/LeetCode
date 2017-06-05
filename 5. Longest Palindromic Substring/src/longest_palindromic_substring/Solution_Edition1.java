//package longest_palindromic_substring;
//
//import java.util.ArrayList;
//
//public class Solution {
//    public String longestPalindrome(String s) {
//        ArrayList<Integer> startPosi = new ArrayList<Integer>();
//        int maxLength = 1;
//        int startPosition = 0, endPosition = 1;
//        for (int i = 0; i < s.length(); i ++) {
//            char c = s.charAt(i);
//            for (int j = 0; j < startPosi.size(); j ++) {
//                int sp = startPosi.get(j).intValue();
//                if ((sp - 1 >= 0) && (s.charAt(sp - 1) == c)) {
//                    startPosi.set(j, sp - 1);
//                    if (i - sp + 2 > maxLength) {
//                        maxLength = i - sp + 2;
//                        startPosition = sp - 1;
//                        endPosition = i + 1;
//                    }
//                } else {
//                    startPosi.remove(j);
//                    j = j - 1;
//                }
//            }
//            startPosi.add(i);
//            startPosi.add(i + 1);
//        }
//        return s.substring(startPosition, endPosition);
//    }
//}
