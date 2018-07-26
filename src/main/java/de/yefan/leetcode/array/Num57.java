package de.yefan.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Insert Interval
 * https://leetcode.com/problems/insert-interval/description/
 */
public class Num57 {

    class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<>();
        if (intervals == null || newInterval == null) {
            return intervals;
        }
        int insertInx = 0;
        for (Interval interval : intervals) {
            if (interval.start > newInterval.end) {
                result.add(interval);
            } else if (interval.end < newInterval.start) {
                result.add(interval);
                insertInx++;
            } else {
                newInterval.start = Math.min(interval.start, newInterval.start);
                newInterval.end = Math.max(interval.end, newInterval.end);
            }
        }

        result.add(insertInx, newInterval);
        return result;
    }

    public List<Interval> insert1(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        int i = 0;
        //add all the intervals ending before newInterval starts
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            result.add(intervals.get(i));
            i++;
        }
        //merge all overlapping intervals to one considering newInterval
        int start = newInterval.start;
        int end = newInterval.end;

        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            start = Math.min(start, intervals.get(i).start);
            end = Math.max(end, intervals.get(i).end);
            i++;
        }

        result.add(new Interval(start, end));

        //add all the rest
        while (i < intervals.size()) {
            result.add(intervals.get(i++));
        }

        return result;
    }
}
