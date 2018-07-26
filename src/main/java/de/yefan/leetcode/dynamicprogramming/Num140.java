package de.yefan.leetcode.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Word Break II
 * https://leetcode.com/problems/word-break-ii/description/
 */
public class Num140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<String>();
        // Do a fast check and see if we can break the input string
        Set<String> dict = new HashSet<>(wordDict);
        if (!canBreak(s, dict)) {
            return res;
        }

        helper(s, dict, 0, "", res);
        return res;
    }

    void helper(String s, Set<String> dict, int start, String sol, List<String> res) {
        if (start == s.length()) {
            res.add(sol);
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String sub = s.substring(start, i + 1);

            if (dict.contains(sub)) {
                helper(s, dict, i + 1, sol + (sol.length() == 0 ? "" : " ") + sub, res);
            }
        }
    }


    boolean canBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0) {
            return false;
        }

        int n = s.length();

        // dp[i] represents whether s[0...i] can be formed by dict
        boolean[] dp = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                String sub = s.substring(j, i + 1);

                if (dict.contains(sub) && (j == 0 || dp[j - 1])) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n - 1];
    }
}
