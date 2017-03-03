package zigzag_conversion;

public class Solution_Edition1 {

    public String convert(String s, int numRows) {
    	if (numRows < 2) {
            return s;
        }
        if (s.length() <= numRows) {
            return s;
        }
        int length = s.length();
        int itemsInGroup = (numRows - 1) * 2;
        int remain = length % itemsInGroup;
        int group = length / itemsInGroup;
        int[] startPosi = new int[numRows + 1];
        char[] result = new char[length];
        startPosi[0] = 0;
        startPosi[numRows] = length;
        if (remain > itemsInGroup/2) {
            startPosi[1] = group + 1;
            for (int i = 2; i < numRows; i ++) {
                if (i <= itemsInGroup - remain + 1) {
                    startPosi[i] = startPosi[i-1] + 2*group + 1;
                } else {
                    startPosi[i] = startPosi[i-1] + 2*group + 2;
                }
            }
        } else {
            if (remain == 0) {
                startPosi[1] = group;
            } else {
                startPosi[1] = group + 1;
            }
            for (int i = 2; i < numRows; i ++) {
                if (i <= remain) {
                    startPosi[i] = startPosi[i-1] + 2*group + 1;
                } else {
                    startPosi[i] = startPosi[i-1] + 2*group;
                }
            }
        }
        for (int i = 0; i < numRows; i ++) {
            for (int j = startPosi[i]; j < startPosi[i+1]; j ++) {
                int indexInRow = j - startPosi[i];
                if (i == 0) {
                    result[itemsInGroup * indexInRow] = s.charAt(j);
                } else if (i == numRows - 1) {
                    result[(numRows-1)*(2*indexInRow + 1)] = s.charAt(j);
                } else {
                    int tempRemain = indexInRow % 2;
                    int tempGroup = (indexInRow + 1) / 2;
                    if (tempRemain == 0) {
                        result[tempGroup*itemsInGroup+i] = s.charAt(j);
                    } else {
                        result[tempGroup*itemsInGroup-i] = s.charAt(j);
                    }
                }
            }
        }
        return new String(result);
    }
}