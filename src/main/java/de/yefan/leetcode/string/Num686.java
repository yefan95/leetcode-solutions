package de.yefan.leetcode.string;

import java.math.BigInteger;

/**
 * Repeated String Match
 * https://leetcode.com/problems/repeated-string-match/description/
 */
public class Num686 {
    public int repeatedStringMatch(String A, String B) {
        int q = 1;
        StringBuilder S = new StringBuilder(A);
        for (; S.length() < B.length(); q++) {
            S.append(A);
        }
        if (S.indexOf(B) >= 0) {
            return q;
        }
        if (S.append(A).indexOf(B) >= 0) {
            return q + 1;
        }
        return -1;
    }

    public boolean check(int index, String A, String B) {
        for (int i = 0; i < B.length(); i++) {
            if (A.charAt((i + index) % A.length()) != B.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public int repeatedStringMatch1(String A, String B) {
        int q = (B.length() - 1) / A.length() + 1;
        int p = 113, MOD = 1_000_000_007;
        int pInv = BigInteger.valueOf(p).modInverse(BigInteger.valueOf(MOD)).intValue();

        long bHash = 0, power = 1;
        for (int i = 0; i < B.length(); i++) {
            bHash += power * B.codePointAt(i);
            bHash %= MOD;
            power = (power * p) % MOD;
        }

        long aHash = 0;
        power = 1;
        for (int i = 0; i < B.length(); i++) {
            aHash += power * A.codePointAt(i % A.length());
            aHash %= MOD;
            power = (power * p) % MOD;
        }

        if (aHash == bHash && check(0, A, B)) {
            return q;
        }
        power = (power * pInv) % MOD;

        for (int i = B.length(); i < (q + 1) * A.length(); i++) {
            aHash -= A.codePointAt((i - B.length()) % A.length());
            aHash *= pInv;
            aHash += power * A.codePointAt(i % A.length());
            aHash %= MOD;
            if (aHash == bHash && check(i - B.length() + 1, A, B)) {
                return i < q * A.length() ? q : q + 1;
            }
        }
        return -1;
    }

    public int repeatedStringMatch2(String A, String B) {
        int n = A.length(), m = B.length();
        int[] kmp = new int[m];
        int i = 1, j = 0;
        while (i < m) {
            if (B.charAt(i) == B.charAt(j)) {
                kmp[i++] = ++j;
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = kmp[j - 1];
                }
            }
        }
        for (i = 0, j = 0; i < n; i++) {
            while (j < m && A.charAt((i + j) % n) == B.charAt(j)) {
                j++;
            }
            if (j == m) {
                return (i + j + n - 1) / n;
            }
            j = j == 0 ? 0 : kmp[j - 1];
        }
        return -1;
    }

    public static void main(String[] args) {
        Num686 num686 = new Num686();
        String A = "bb";
        String B = "bbbbbbb";
        int count = num686.repeatedStringMatch1(A, B);
        System.out.println(count);
    }
}
