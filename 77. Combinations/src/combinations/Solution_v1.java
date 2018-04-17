package combinations;

import java.util.ArrayList;
import java.util.List;

public class Solution_v1 {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (k <= 0) return new ArrayList<List<Integer>>();
        ArrayList<Integer> comb = new ArrayList<Integer>();
        for (int i = 1; i <= k; i ++) comb.add(i);
        result.add(comb);
        while (true) {
        	ArrayList<Integer> newComb = new ArrayList<Integer>(comb);
        	if (newComb.get(k-1) == n) {
        		int index = k - 2;
        		while (true) {
        			if (index < 0) return result;
        			else if (newComb.get(index) != newComb.get(index + 1) - 1) {
        				newComb.set(index, newComb.get(index) + 1);
        				while(++index < k) newComb.set(index, newComb.get(index - 1) + 1);
        				break;
        			}
        			index --;
        		}
        	} else {
        		newComb.set(k-1, newComb.get(k-1) + 1);
        	}
        	result.add(newComb);
        	comb = newComb;
        }
    }
}
