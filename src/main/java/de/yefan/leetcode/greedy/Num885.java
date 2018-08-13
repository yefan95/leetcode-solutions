package de.yefan.leetcode.greedy;

import java.util.Arrays;

/**
 * Boats to Save People
 * https://leetcode.com/problems/boats-to-save-people/description/
 */
public class Num885 {
    public int numRescueBoats(int[] people, int limit) {
        int[] count = new int[limit + 1];
        for (int i = 0; i < people.length; i++) {
            count[people[i]]++;
        }
        int start = 0;
        int end = limit;
        int ans = 0;

        while (start <= end) {
            if (count[start] <= 0) {
                start++;
            } else if (count[end] <= 0) {
                end--;
            } else if (start + end <= limit) {
                count[start]--;
                count[end]--;
                ans++;
            } else {
                count[end]--;
                ans++;
            }
        }

        return ans;
    }

    public int numRescueBoats1(int[] people, int limit) {
        Arrays.sort(people);
        int ans = 0;
        for (int hi = people.length - 1, lo = 0; hi >= lo; hi--, ++ans) {
            if (people[lo] + people[hi] <= limit) {
                ++lo;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Num885 num885 = new Num885();
//        int[] people = {3, 2, 2, 1};
//        int[] people = {3, 5, 3, 4};
//        int[] people = {5, 1, 4, 2};
        int[] people = {1, 2};
        int limit = 3;
        int res = num885.numRescueBoats(people, limit);
        System.out.println(res);
    }
}
