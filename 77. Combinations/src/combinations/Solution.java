package combinations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<List<Integer>> combine(int n, int k) {
        if ((n < k) || (k == 0)) return new ArrayList<List<Integer>>();
        List<List<Integer>> reduces = combine(n - 1, k - 1);
        if (reduces.isEmpty()) reduces.add(new ArrayList<Integer>());
        for (List<Integer> reduce : reduces) reduce.add(n);
        reduces.addAll(combine(n - 1, k));
        return reduces;
    }
}
