package permutations;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        list.add(new LinkedList<Integer>());
        for (int num : nums) {
            List<List<Integer>> newlist = new LinkedList<>();
            for (List<Integer> li : list) {
                int size = li.size();
                for (int i = 0; i <= size; i ++) {
                    List<Integer> newli = new LinkedList<Integer>();
                    newli.addAll(li);
                    newli.add(i, num);
                    newlist.add(newli);
                }
            }
            list = newlist;
        }
        return list;
    }
}
