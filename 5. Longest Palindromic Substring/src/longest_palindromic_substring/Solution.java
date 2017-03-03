package longest_palindromic_substring;

import java.util.ArrayList;

public class Solution {
	public static void main(String[] args) {
        ArrayList<Integer> startPosi = new ArrayList<Integer>();
//        int maxLength = 0;
//        for (int i = 0; i < s.length(); i ++) {
//            char c = s.charAt(i);
//            for (Integer sp : startPosi) {
//                if ((sp - 1 >= 0) && (s.charAt(sp - 1) == c)) {
//                    sp
//                } else {
//                    startPosi.remove()
//                }
//            }
//        }
        startPosi.add(1);
        Integer i = startPosi.get(0);
        i = i - 1;
        System.out.println(startPosi.get(0));
    }
}
