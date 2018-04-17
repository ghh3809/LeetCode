package subsets;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> subset = new ArrayList<Integer>();
        result.add(subset);
        for (int i = 0; i < nums.length; i ++) {
            int size = result.size();
            for (int j = 0; j < size; j ++) {
                subset = new ArrayList<Integer>(result.get(j));
                subset.add(nums[i]);
                result.add(subset);
            }
        }
        return result;
    }
}
