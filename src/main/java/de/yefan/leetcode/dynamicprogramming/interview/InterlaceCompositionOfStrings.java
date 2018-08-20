package de.yefan.leetcode.dynamicprogramming.interview;

/**
 * 对于三个字符串A，B，C。我们称C由A和B交错组成当且仅当C包含且仅包含A，B中所有字符，且对应的顺序不改变。请编写一个高效算法，判断C串是否由A和B交错组成。
 * <p>
 * 给定三个字符串A,B和C，及他们的长度。请返回一个bool值，代表C是否由A和B交错组成。保证三个串的长度均小于等于100。
 */
public class InterlaceCompositionOfStrings {

    public static void main(String[] args) {
        String str1 = "AB", str2 = "12", aim = "1A2B";
        boolean res = isCross(str1, str2, aim);
        System.out.println(res);
    }

    public static boolean isCross(String str1, String str2, String aim) {
        if (str1 == null || str2 == null || aim == null) {
            return false;
        }
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();

        char[] chaim = aim.toCharArray();

        boolean[][] dp = new boolean[ch1.length + 1][ch2.length + 1];

        for (int i = 1; i <= ch1.length; i++) {
            if (ch1[i - 1] != chaim[i - 1]) {
                break;
            }
            dp[i][0] = true;
        }

        for (int j = 1; j <= ch2.length; j++) {
            if (ch2[j - 1] != chaim[j - 1]) {
                break;
            }
            dp[0][j] = true;
        }

        for (int i = 1; i <= ch1.length; i++) {
            for (int j = 1; j <= ch2.length; j++) {
                if ((ch1[i - 1] == chaim[i + j - 1] && dp[i - 1][j]) || (ch2[j - 1] == chaim[i + j - 1] && dp[i][j - 1])) {
                    dp[i][j] = true;
                }
            }
        }

        return dp[ch1.length][ch2.length];
    }
}
