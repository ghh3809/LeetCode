package valid_number;

class Solution {
    public boolean isNumber(String s) {
    	return s.trim().matches("(\\+|-)?((\\d*\\.?\\d+)|(\\d+\\.?\\d*))((E|e)(\\+|-)?\\d+)?");
    }
    public static void main(String args[]) {
    	System.out.println(new Solution().isNumber("1."));
    }
}
