package de.yefan.leetcode.string;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/reorganize-string/description/
 * <p>
 * Reorganize String
 */
public class Num767 {
    public String reorganizeString(String S) {
        if (S == null || S.length() <= 0) {
            return "";
        }
        int N = S.length();
        int[] counts = new int[26];
        for (char c : S.toCharArray()) {
            counts[c - 'a'] += 100;
        }
        for (int i = 0; i < 26; i++) {
            counts[i] += i;
        }
        //Encoded counts[i] = 100*(actual count) + (i)
        Arrays.sort(counts);

        char[] ans = new char[N];
        int t = 1;
        for (int code : counts) {
            int ct = code / 100;
            char ch = (char) ('a' + (code % 100));
            if (ct > (N + 1) / 2) {
                return "";
            }
            for (int i = 0; i < ct; i++) {
                if (t >= N) {
                    t = 0;
                }
                ans[t] = ch;
                t += 2;
            }
        }

        return String.valueOf(ans);
    }
}
