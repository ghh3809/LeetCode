package zigzag_conversion;

public class Solution {

    public String convert(String s, int numRows) {
    	if (numRows < 2) {
            return s;
        }
        if (s.length() <= numRows) {
            return s;
        }
        int length = s.length();
        int itemsInGroup = (numRows - 1) * 2;
        char[] result = new char[length];
        int resultIndexLast = 0, resultIndexInRow = 0;
        int oldIndex = 0;
        while (oldIndex < length) {
            result[resultIndexLast + resultIndexInRow] = s.charAt(oldIndex);
            resultIndexInRow ++;
            oldIndex = itemsInGroup * resultIndexInRow;
        }
        for (int i = 1; i < numRows - 1; i ++) {
            resultIndexLast = resultIndexLast + resultIndexInRow;
            resultIndexInRow = 0;
            oldIndex = i;
            while (oldIndex < length) {
                result[resultIndexLast + resultIndexInRow] = s.charAt(oldIndex);
                resultIndexInRow ++;
                int tempGroup = (resultIndexInRow + 1) / 2;
                int tempRemain = resultIndexInRow % 2;
                if (tempRemain == 0) {
                    oldIndex = tempGroup * itemsInGroup + i;
                } else {
                    oldIndex = tempGroup * itemsInGroup - i;
                }
            }
        }
        resultIndexLast = resultIndexLast + resultIndexInRow;
        resultIndexInRow = 0;
        oldIndex = numRows - 1;
        while (oldIndex < length) {
            result[resultIndexLast + resultIndexInRow] = s.charAt(oldIndex);
            resultIndexInRow ++;
            oldIndex = itemsInGroup/2 * (2*resultIndexInRow+1);
        }
        return new String(result);
    }
}