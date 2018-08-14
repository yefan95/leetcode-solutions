package de.yefan.leetcode.greedy;

import java.util.*;

/**
 * Minimum Number of Arrows to Burst Balloons
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/
 */
public class Num452 {


    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }

        Arrays.sort(points, (a, b) -> a[1] - b[1]);
        int minRight = Integer.MAX_VALUE, count = 0;
        for (int[] point : points) {
            int start = point[0], end = point[1];
            if (start > minRight) {
                count++;
                minRight = end;
            } else {
                minRight = Math.min(minRight, end);
            }
        }

        return count + 1;
    }

    public static void main(String[] args) {
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        Num452 num452 = new Num452();
        int res = num452.findMinArrowShots(points);
        System.out.println(res);
    }
}
