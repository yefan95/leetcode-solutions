package de.yefan.leetcode.dynamicprogramming.interview;

/**
 * 对于字符串A，其中绝对不含有字符’.’和’*’。再给定字符串B，其中可以含有’.’或’*’，’*’字符不能是B的首字符，并且任意两个’*’字符不相邻。exp中的’.’代表任何一个字符，B中的’*’表示’*’的前一个字符可以有0个或者多个。请写一个函数，判断A是否能被B匹配。
 * <p>
 * 给定两个字符串A和B,同时给定两个串的长度lena和lenb，请返回一个bool值代表能否匹配。保证两串的长度均小于等于300。
 */
public class WildMatch {

    public static void main(String[] args) {
        String str1 = "abcd";
        String str2 = ".*";
        boolean res = chkWildMatch(str1, str1.length(), str2, str2.length());
        System.out.println(res);
    }

    public static boolean chkWildMatch(String str1, int lena, String str2, int lenb) {
        // dp[i][j]表示A中的1~i位可以匹配B中的1~j位
        boolean[][] dp = new boolean[lena + 1][lenb + 1];
        dp[0][0] = true;
        for (int i = 1; i <= lena; i++) {
            for (int j = 1; j <= lenb; j++) {
                if (str2.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else if (str2.charAt(j - 1) == '.' || str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }

        return dp[lena][lenb];
    }
}
