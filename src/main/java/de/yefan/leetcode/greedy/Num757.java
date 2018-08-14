package de.yefan.leetcode.greedy;

import java.util.Arrays;

/**
 * Set Intersection Size At Least Two
 * https://leetcode.com/problems/set-intersection-size-at-least-two/description/
 */
public class Num757 {
    public int intersectionSizeTwo(int[][] intervals) {
        if (intervals == null || intervals.length <= 0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> (a[1] - b[1]));
        int count = 2;
        int last = intervals[0][1];
        int sec_last = intervals[0][1] - 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= sec_last) {
                continue;
            } else if (intervals[i][0] <= last) {
                sec_last = last;
                last = intervals[i][1];
                count++;
            } else {
                last = intervals[i][1];
                sec_last = intervals[i][1] - 1;
                count += 2;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Num757 num757 = new Num757();
//        int[][] intervals = {{1, 2}, {2, 3}, {2, 4}, {4, 5}};
        int[][] intervals = {{1, 3}, {1, 4}, {2, 5}, {3, 5}};
        int res = num757.intersectionSizeTwo(intervals);
        System.out.println(res);
    }
}
