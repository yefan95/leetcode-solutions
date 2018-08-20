package de.yefan.leetcode.dynamicprogramming.interview;

/**
 * 给定一个字符串str,str全部由数字字符组成，如果str中某一个或某相邻两个字符组成的子串值在1-26之间，
 * 则这个子串可以转换为一个字母。规定"1"转换为"A"，"2"转换为"B",..."26"转换为"Z"。返回str转换的种类数。
 */
public class NumConvertLetterCombination {

    public static void main(String[] args) {
        String str = "1111";
        int res = num(str);
        System.out.println(res);
        res = num1(str);
        System.out.println(res);
        res = num2(str);
        System.out.println(res);
    }

    public static int num(String str) {
        if (str == null || str.equals("")) {
            return 0;
        }
        int len = str.length();
        int[] dp = new int[len];
        char[] arr = str.toCharArray();

        if (arr[len - 1] == '0') {
            dp[len - 1] = 0;
            //10或者20
            if (len >= 2 && (arr[len - 2] == '1' || arr[len - 2] == '2')) {
                dp[len - 2] = 1;
            } else if (len >= 2) {
                dp[len - 2] = 0;
            }
        } else {
            dp[len - 1] = 1;
            // 11-26
            if (len >= 2 && (arr[len - 2] == '1' || arr[len - 2] == '2') && (arr[len - 1] > '0' && arr[len - 1] < '7')) {
                dp[len - 2] = 2;
            }
            //01-09
            else if (len >= 2 && arr[len - 2] == '0') {
                dp[len - 2] = 0;
            } else if (len >= 2) {
                dp[len - 2] = 1;
            }
        }

        for (int i = len - 3; i >= 0; i--) {
            if (arr[i] == '0') {
                dp[i] = 0;
            } else if ((arr[i] == '1' || arr[i] == '2') && (arr[i + 1] > '0' && arr[i + 1] < '7')) {
                dp[i] = dp[i + 1] + dp[i + 2];
            } else {
                dp[i] = dp[i + 1];
            }
        }

        return dp[0];
    }

    public static int num1(String str) {
        if (str == null || str.equals("")) {
            return 0;
        }
        char[] chs = str.toCharArray();
        return process(chs, 0);
    }

    public static int process(char[] chs, int i) {
        if (i == chs.length) {
            return 1;
        }
        if (chs[i] == '0') {
            return 1;
        }
        int res = process(chs, i + 1);
        if (i + 1 < chs.length && (chs[i] - '0') * 10 + chs[i + 1] - '0' < 27) {
            res += process(chs, i + 2);
        }
        return res;
    }


    public static int num2(String str) {
        if (str == null || str.equals("")) {
            return 0;
        }
        char[] chs = str.toCharArray();
        int cur = chs[chs.length - 1] == '0' ? 0 : 1;
        int next = 1;
        int tmp = 0;
        for (int i = chs.length - 2; i >= 0; i--) {
            if (chs[i] == '0') {
                next = cur;
                cur = 0;
            } else {
                tmp = cur;
                if ((chs[i] - '0') * 10 + chs[i + 1] - '0' < 27) {
                    cur += next;
                }
                next = tmp;
            }
        }

        return cur;
    }

}
