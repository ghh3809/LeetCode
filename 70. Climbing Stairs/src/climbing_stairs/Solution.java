package climbing_stairs;

class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int lastlast = 1;
        int last = 2;
        for (int i = 3; i <= n; i ++) {
            last += lastlast;
            lastlast = last - lastlast;
        }
        return last;
    }
}
