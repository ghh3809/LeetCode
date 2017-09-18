package merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public List<Interval> merge(List<Interval> intervals) {
    	if (intervals.size() < 2) {
    		return intervals;
    	}
    	List<Interval> result = new ArrayList<Interval>();
    	Object[] temp = intervals.toArray();
    	Interval[] intervalsArray = new Interval[temp.length];
    	for (int i = 0; i < temp.length; i ++) {
    		intervalsArray[i] = (Interval) temp[i];
    	}

    	Arrays.sort(intervalsArray, new Comparator<Interval>() {

			@Override
			public int compare(Interval arg0, Interval arg1) {
				// TODO Auto-generated method stub
				if (arg0.start < arg1.start) {
					return -1;
				} else if (arg0.start > arg1.start) {
					return 1;
				} else {
					return 0;
				}
			}
    		
    	});
    	
    	int length = intervalsArray.length;
    	int lastInterval = 0;
    	int maxEnd = intervalsArray[0].end;
    	int index = 1;
    	while (true) {
    		while ((index < length) && (intervalsArray[index].start <= maxEnd)) {
    			maxEnd = maxEnd < intervalsArray[index].end ? intervalsArray[index].end : maxEnd;
    			index ++;
    		}
    		result.add(new Interval(intervalsArray[lastInterval].start, maxEnd));
    		if (index >= length) {
    			break;
    		}
    		lastInterval = index ++;
    		maxEnd = intervalsArray[lastInterval].end;
    	}
        return result;
    }
}
