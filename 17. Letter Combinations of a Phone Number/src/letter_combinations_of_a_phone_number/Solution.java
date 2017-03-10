package letter_combinations_of_a_phone_number;

public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        int length = digits.length();
        if (length == 0) return result;
        result.add(new String());
        for (int i = 0; i < length; i ++) {
            result = addDigits(result, digits.charAt(i));
        }
        return result;
    }
    
    public List<String> addDigits(List<String> stringList, char digit) {
        char[] dc;
        List<String> newList = new ArrayList<String>();
        switch (digit) {
            case ('2'):
                dc = new char[]{'a', 'b', 'c'};
                break;
            case ('3'):
                dc = new char[]{'d', 'e', 'f'};
                break;
            case ('4'):
                dc = new char[]{'g', 'h', 'i'};
                break;
            case ('5'):
                dc = new char[]{'j', 'k', 'l'};
                break;
            case ('6'):
                dc = new char[]{'m', 'n', 'o'};
                break;
            case ('7'):
                dc = new char[]{'p', 'q', 'r', 's'};
                break;
            case ('8'):
                dc = new char[]{'t', 'u', 'v'};
                break;
            case ('9'):
                dc = new char[]{'w', 'x', 'y', 'z'};
                break;
            default:
                dc = new char[]{' '};
                break;
        }
        for (int i = 0; i < stringList.size(); i ++) {
            String sb = stringList.get(i);
            for (int j = 0; j < dc.length; j ++) {
                newList.add(sb + dc[j]);
            }
        }
        return newList;
    }
}
