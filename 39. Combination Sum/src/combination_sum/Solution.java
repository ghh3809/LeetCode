package combination_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
	
    private class Combination {
        public ArrayList<Integer> data;
        public int sum = 0;
        public Combination(ArrayList<Integer> data) {
            this.data = data;
        }
        public Combination(Combination c, int num) {
            ArrayList<Integer> originData = c.data;
            ArrayList<Integer> newData = new ArrayList<>();
            for (int i = 0; i < originData.size(); i ++) {
                newData.add(originData.get(i).intValue());
            }
            newData.add(num);
            this.data = newData;
            this.sum = c.sum + num;
        }
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        LinkedList<Combination> list = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        Combination root = new Combination(new ArrayList<Integer>());
        list.push(root);
        for (int i = 0; i < candidates.length; i ++) {
            if (candidates[i] > target) break;
            int size = list.size();
            for (int j = 0; j < size; j ++) {
                Combination c = list.pollLast();
                list.push(c);
                while(c.sum + candidates[i] < target) {
                	c = new Combination(c, candidates[i]);
                    list.push(c);
                }
                if (c.sum + candidates[i] == target) {
                	result.add(new Combination(c, candidates[i]).data);
                }
            }
        }
        return result;
    }
}
