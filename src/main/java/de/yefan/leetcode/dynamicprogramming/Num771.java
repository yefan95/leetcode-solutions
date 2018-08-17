package de.yefan.leetcode.dynamicprogramming;

import java.util.HashSet;
import java.util.Set;

/**
 * Jewels and Stones
 * https://leetcode.com/problems/jewels-and-stones/description/
 */
public class Num771 {
    public int numJewelsInStones(String J, String S) {
        char[] jewel = J.toCharArray();
        char[] stone = S.toCharArray();
        Set<Character> set = new HashSet<>(jewel.length);
        for (char c : jewel) {
            set.add(c);
        }
        int count = 0;
        for (int i = 0; i < stone.length; i++) {
            if (set.contains(stone[i])) {
                count++;
            }
        }

        return count;
    }

    public int numJewelsInStones1(String J, String S) {
        char[] jewel = J.toCharArray();
        int[] dp = new int[S.length()];
        Set<Character> set = new HashSet<>(jewel.length);
        for (char c : jewel) {
            set.add(c);
        }
        dp[0] = set.contains(S.charAt(0)) ? 1 : 0;
        for (int i = 1; i < S.length(); i++) {
            dp[i] = dp[i - 1] + (set.contains(S.charAt(0)) ? 1 : 0);
        }

        return dp[S.length() - 1];
    }


}
