package palindrome_number;

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if ((x > 999999999) && (x % 10 > 2)) return false;
        int inverse = 0;
        int originX = x;
        while (x > 0) {
            inverse = inverse * 10 + (x % 10);
            x /= 10;
        }
        return (inverse == originX);
    }
}
