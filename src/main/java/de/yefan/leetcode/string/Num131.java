package de.yefan.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Palindrome Partitioning
 * https://leetcode.com/problems/palindrome-partitioning/description/
 */
public class Num131 {

    List<List<String>> result = new ArrayList<>();

    public List<List<String>> partition(String s) {
        dfs(s, new ArrayList<>());
        return result;
    }

    private void dfs(String s, List<String> list) {
        if (s.length() == 0) {
            result.add(list);
            return;
        }
        for (int i = 1; i <= s.length(); i++) {
            String sub = s.substring(0, i);
            if (isPalindrome(sub)) {
                List<String> newList = new ArrayList<>(list);
                newList.add(sub);
                dfs(s.substring(i, s.length()), newList);
            } else {
                continue;
            }
        }
    }

    private boolean isPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }


    List<List<String>> resultLst;
    ArrayList<String> currLst;

    public List<List<String>> partition1(String s) {
        resultLst = new ArrayList<List<String>>();
        currLst = new ArrayList<String>();
        backTrack(s, 0);
        return resultLst;
    }

    private void backTrack(String s, int l) {
        if (currLst.size() > 0 && l >= s.length()) {
            List<String> r = (List<String>) currLst.clone();
            resultLst.add(r);
        }
        for (int i = l; i < s.length(); i++) {
            if (isPalindrome(s, l, i)) {
                if (l == i) {
                    currLst.add(Character.toString(s.charAt(i)));
                } else {
                    currLst.add(s.substring(l, i + 1));
                }
                backTrack(s, i + 1);
                currLst.remove(currLst.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String str, int l, int r) {
        if (l == r) {
            return true;
        }
        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }


    public List<List<String>> partition2(String s) {
        List<List<String>> res = new ArrayList<>();
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                }
            }
        }
        helper(res, new ArrayList<>(), dp, s, 0);
        return res;
    }

    private void helper(List<List<String>> res, List<String> path, boolean[][] dp, String s, int pos) {
        if (pos == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = pos; i < s.length(); i++) {
            if (dp[pos][i]) {
                path.add(s.substring(pos, i + 1));
                helper(res, path, dp, s, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }


}
