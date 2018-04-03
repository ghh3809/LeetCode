package add_binary;

class Solution {
    public String addBinary(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        if (lenA == 0) { a = "0"; lenA = 1; }
        if (lenB == 0) { b = "0"; lenB = 1; }
        StringBuilder sb = new StringBuilder();
        boolean addFlag = false;
        for (int i = 1; i <= Math.max(lenA, lenB); i ++) {
        	char numA = lenA - i >= 0 ? a.charAt(lenA - i) : '0';
        	char numB = lenB - i >= 0 ? b.charAt(lenB - i) : '0';
        	int sum = numA - '0' + numB - '0';
        	if (addFlag) { sum ++; addFlag = false; }
        	if (sum >= 2) { sum -= 2; addFlag = true; }
        	sb.append(sum);
        }
        if (addFlag) sb.append('1');
        return sb.reverse().toString();
    }
    public static void main(String args[]) {
    	System.out.println(new Solution().addBinary("11", "1"));
    }
}
