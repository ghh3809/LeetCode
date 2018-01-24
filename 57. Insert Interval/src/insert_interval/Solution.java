package insert_interval;

import java.util.List;

class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	int newstartposi = 0;
    	int newendposi = -1;
    	for (Interval interval : intervals) {
    		if (interval.end < newInterval.start) {
    			newstartposi ++;
    			newendposi ++;
    			continue;
    		} else {
    			if (interval.start > newInterval.end) {
    				break;
    			}
    			newendposi ++;
    		}
    	}
    	
    	int startnum = 0, endnum = 0;
		if (newstartposi - newendposi == 1) {
			startnum = newInterval.start;
			endnum = newInterval.end;
		} else {
			startnum = Math.min(intervals.get(newstartposi).start, newInterval.start);
			endnum = Math.max(intervals.get(newendposi).end, newInterval.end);
		}

        for (int i = newstartposi; i <= newendposi; i ++) {
        	intervals.remove(newstartposi);
        }
		
		intervals.add(newstartposi, new Interval(startnum, endnum));
        return intervals;
    }
}
