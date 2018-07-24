package de.yefan.leetcode.string;

/**
 * Palindrome Partitioning II
 * https://leetcode.com/problems/palindrome-partitioning-ii/description/
 */
public class Num132 {
    public int minCut(String s) {
        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i] = isPalindrome(s.substring(0, i + 1)) ? 0 : i;
            if (dp[i] == 0) {
                continue;
            }
            for (int j = 1; j <= i; j++) {
                if (isPalindrome(s.substring(j, i + 1))) {
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                } else {
                    dp[i] = Math.min(dp[i], dp[j - 1] + i + 1 - j);
                }
            }
        }
        return dp[dp.length - 1];
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

    public int minCut1(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[] cut = new int[n];
        boolean[][] pal = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = 0; j <= i; j++) {
                if (c[j] == c[i] && (j + 1 > i - 1 || pal[j + 1][i - 1])) {
                    pal[j][i] = true;
                    min = (j == 0 ? 0 : Math.min(min, cut[j - 1] + 1));
                }
            }
            cut[i] = min;
        }
        return cut[n - 1];
    }

    public int minCut2(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            // 长度为1(s.charAt 0)的时候，不用切分就是回文；长度为3的时候，最多需要切分2次，得到回文
            dp[i] = i;
        }
        for (int i = 0; i < n; i++) {
            help(s, dp, i, i);
            help(s, dp, i, i + 1);
        }
        return dp[n - 1];
    }

    public void help(String s, int[] dp, int left, int right) {
        while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
            if (left == 0) {
                dp[right] = 0;
            } else {
                dp[right] = Math.min(dp[right], dp[left - 1] + 1);
            }
            left--;
            right++;
        }
    }


}
