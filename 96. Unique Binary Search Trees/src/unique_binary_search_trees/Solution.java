package unique_binary_search_trees;

class Solution {
    public int numTrees(int n) {
        if (n == 0) return 0;
        int[] types = new int[n + 1];
        types[0] = 1;
        for (int i = 1; i <= n; i ++) {
            for (int left = 0; left < i; left ++) {
                types[i] += types[left] * types[i - 1 - left];
            }
        }
        return types[n];
    }
}
