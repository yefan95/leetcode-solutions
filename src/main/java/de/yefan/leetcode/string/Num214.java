package de.yefan.leetcode.string;

/**
 * Shortest Palindrome
 * https://leetcode-cn.com/problems/shortest-palindrome/description/
 */
public class Num214 {
    /**
     * 暴力法
     *
     * @param s
     * @return
     */
    public String shortestPalindrome(String s) {
        int n = s.length();
        String revStr = new StringBuilder().append(s).reverse().toString();

        for (int i = 0; i < n; i++) {
            if (s.substring(0, n - i).equals(revStr.substring(i))) {
                return revStr.substring(0, i) + s;
            }
        }

        return "";
    }

    public String shortestPalindrome1(String s) {
        int n = s.length();
        int i = 0;
        for (int j = n - 1; j >= 0; j--) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
            }
        }
        if (i == n) {
            return s;
        }
        String remainRev = s.substring(i, n);

        remainRev = new StringBuilder().append(remainRev).reverse().toString();

        return remainRev + shortestPalindrome1(s.substring(0, i)) + s.substring(i);
    }

    /**
     *
     * KMP
     *
     * @param s
     * @return
     */
    public String shortestPalindrome2(String s) {
        int n = s.length();
        String rev = new StringBuilder().append(s).reverse().toString();

        String s_new = s + "#" + rev;

        int n_new = s_new.length();

        int[] f = new int[n_new];

        for (int i = 1; i < n_new; i++) {
            int t = f[i - 1];
            while (t > 0 && s_new.charAt(i) != s_new.charAt(t)) {
                t = f[t - 1];
            }
            if (s_new.charAt(i) == s_new.charAt(t)) {
                ++t;
            }
            f[i] = t;
        }

        return rev.substring(0, n - f[n_new - 1]) + s;
    }


}

