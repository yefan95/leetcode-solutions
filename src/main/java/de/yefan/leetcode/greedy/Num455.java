package de.yefan.leetcode.greedy;

import java.util.Arrays;

/**
 * Assign Cookies
 * https://leetcode.com/problems/assign-cookies/description/
 */
public class Num455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int index = 0;

        for (int i = 0; i < s.length && index < g.length; i++) {
            if (s[i] >= g[index]) {
                index++;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        Num455 num455 = new Num455();
        int[] g = {1, 2};
        int[] s = {1, 2, 3};
        int res = num455.findContentChildren(g, s);
        System.out.println(res);
    }
}
