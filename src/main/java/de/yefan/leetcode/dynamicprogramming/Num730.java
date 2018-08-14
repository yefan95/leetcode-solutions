package de.yefan.leetcode.dynamicprogramming;

/**
 * Count Different Palindromic Subsequences
 * https://leetcode.com/problems/count-different-palindromic-subsequences/description/
 */
public class Num730 {
    private static long MOD = 1000000007;

    public int countPalindromicSubsequences(String S) {
        int len = S.length();
        int[][] dp = new int[len][len];

        // all single letters are a palindrome
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }

        for (int i = 1; i < len; i++) {
            // iterating over each substring.
            for (int beg = 0, end = i; end < len; end++, beg++) {
                // if the extreme character of current substring match then it contributes to palindrome count
                if (S.charAt(beg) == S.charAt(end)) {
                    //eg :  aba, 'b' = 1. Contribution of 'b' in  'abc' are 'b', 'aba' so (contribution of 'b') * 2
                    dp[beg][end] = 2 * dp[beg + 1][end - 1];

                    // idea is to find occurrence of extreme characters with in the substring (excluding the extreme characters)
                    int leftIdx = beg + 1, rightIdx = end - 1;
                    char ch = S.charAt(beg);
                    while (leftIdx <= rightIdx && ch != S.charAt(leftIdx)) {
                        leftIdx++;
                    }

                    while (leftIdx <= rightIdx && ch != S.charAt(rightIdx)) {
                        rightIdx--;
                    }

                    // if there is no occurrence then we need to add max possible unique palindrome count of 2 characters, which is 2
                    // e,g 'a','a' can form 'a' and 'aa'
                    if (leftIdx > rightIdx) {
                        dp[beg][end] += 2;
                    }

                    // if there is one occurrence then we need to add max possible unique palindrome count of 1 character, which is 1
                    else if (leftIdx == rightIdx) {
                        dp[beg][end] += 1;
                    }

                    // if there are two occurrence then we need to remove the repetitive palindromes.
                    else {
                        dp[beg][end] -= dp[leftIdx + 1][rightIdx - 1];
                    }
                }
                // else preserve the max count so far.
                else {
                    dp[beg][end] = dp[beg][end - 1] + dp[beg + 1][end] - dp[beg + 1][end - 1];
                }

                // this is the modulus logic to prevent overflow.
                dp[beg][end] = (int) ((dp[beg][end] + MOD) % MOD);
            }
        }

        return dp[0][len - 1];
    }
}
