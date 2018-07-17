package subsets_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i ++) {
            int numCount = 1;
            int resCount = result.size();
            while ((i < nums.length - 1) && (nums[i] == nums[i + 1])) {
                numCount ++; i ++;
            }
            for (int index = 0; index < resCount; index ++) {
                List<Integer> current = result.get(index);
                for (int count = 1; count <= numCount; count ++) {
                    List<Integer> newList = new ArrayList<Integer>();
                    newList.addAll(current);
                    for (int j = 0; j < count; j ++) {
                        newList.add(nums[i]);
                    }
                    result.add(newList);
                }
            }
        }
        return result;
    }
    
    public static void main(String args[]) {
    	System.out.println(new Solution().subsetsWithDup(new int[] {1,2,2}));
    }
}
