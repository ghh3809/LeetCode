package permutations_ii;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        list.add(new LinkedList<Integer>());
        HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i ++) {
            if (countMap.containsKey(nums[i])) {
            	countMap.put(nums[i], countMap.get(nums[i]) + 1);
            } else {
                countMap.put(nums[i], 1);
            }
        }
        for (int i : countMap.keySet()) {
            List<List<Integer>> newlist = new LinkedList<>();
            int count = countMap.get(i);
            for (List<Integer> li : list) {
                int size = li.size();
                int[] positions = new int[count];
                while (true) {
                    List<Integer> newli = new LinkedList<>();
                    newli.addAll(li);
                    for (int j = 0; j < count; j ++) {
                        newli.add(positions[j] + j, i);
                    }
                    newlist.add(newli);
                    if (!nextPosition(positions, size)) break;
                }
            }
            list = newlist;
        }
        return list;
    }
    private boolean nextPosition(int[] positions, int size) {
        int index = positions.length - 1;
        if (positions[index] < size) {
            positions[index] ++;
        } else {
            while ((index >= 0) && (positions[index] == size)) index --;
            if (index < 0) return false;
            else {
                positions[index] += 1;
                index ++;
                while (index < positions.length) {
                    positions[index] = positions[index - 1];
                    index ++;
                }
            }
        }
        return true;
    }
}
