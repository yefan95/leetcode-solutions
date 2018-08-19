package de.yefan.leetcode.dynamicprogramming.interview;

/**
 * 给定数组arr,arr中所有的值都为正数不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意张，再给定一个整数
 * aim代表要找的钱数，求换钱有多少种方法。
 */
public class WaysOfExchangeMoney {
    public static void main(String[] args) {
        int[] arr = {5, 10, 25, 1};
        int aim = 15;
        int res = minCoins1(arr, aim);
        System.out.println(res);
        res = minCoins2(arr, aim);
        System.out.println(res);
        res = minCoins3(arr, aim);
        System.out.println(res);
        res = minCoins4(arr, aim);
        System.out.println(res);
        res = minCoins5(arr, aim);
        System.out.println(res);
    }

    public static int minCoins1(int[] arr, int aim) {
        if (arr == null || arr.length <= 0 || aim < 0) {
            return 0;
        }
        return process1(arr, 0, aim);
    }

    public static int process1(int[] arr, int index, int aim) {
        int res = 0;
        if (index == arr.length) {
            res = aim == 0 ? 1 : 0;
        } else {
            for (int i = 0; arr[index] * i <= aim; i++) {
                res += process1(arr, index + 1, aim - arr[index] * i);
            }
        }

        return res;
    }

    public static int minCoins2(int[] arr, int aim) {
        if (arr == null || arr.length <= 0 || aim < 0) {
            return 0;
        }
        int[][] map = new int[arr.length + 1][aim + 1];
        return process2(arr, 0, aim, map);
    }

    public static int process2(int[] arr, int index, int aim, int[][] map) {
        int res = 0;
        if (index == arr.length) {
            res = aim == 0 ? 1 : 0;
        } else {
            int mapValue = 0;
            for (int i = 0; arr[index] * i <= aim; i++) {
                mapValue = map[index + 1][aim - arr[index] * i];
                if (mapValue != 0) {
                    res += mapValue == -1 ? 0 : mapValue;
                } else {
                    res += process2(arr, index + 1, aim - arr[index] * i, map);
                }
            }
        }

        return res;
    }

    public static int minCoins3(int[] arr, int aim) {
        if (arr == null || arr.length <= 0 || aim < 0) {
            return 0;
        }
        int n = arr.length;
        int[][] dp = new int[arr.length][aim + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; arr[0] * j <= aim; j++) {
            dp[0][arr[0] * j] = 1;
        }

        int num = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= aim; j++) {
                num = 0;
                for (int k = 0; j - arr[i] * k >= 0; k++) {
                    num += dp[i - 1][j - arr[i] * k];
                }
                dp[i][j] = num;
            }
        }

        return dp[arr.length - 1][aim];
    }

    public static int minCoins4(int[] arr, int aim) {
        if (arr == null || arr.length <= 0 || aim < 0) {
            return 0;
        }
        int n = arr.length;
        int[][] dp = new int[arr.length][aim + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; arr[0] * j <= aim; j++) {
            dp[0][arr[0] * j] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= aim; j++) {
                dp[i][j] = dp[i - 1][j];
                dp[i][j] += j - arr[i] >= 0 ? dp[i][j - arr[i]] : 0;
            }
        }

        return dp[arr.length - 1][aim];
    }

    public static int minCoins5(int[] arr, int aim) {
        if (arr == null || arr.length <= 0 || aim < 0) {
            return 0;
        }
        int n = arr.length;
        int[] dp = new int[aim + 1];

        for (int j = 0; arr[0] * j <= aim; j++) {
            dp[arr[0] * j] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= aim; j++) {
                dp[j] += j - arr[i] >= 0 ? dp[j - arr[i]] : 0;
            }
        }

        return dp[aim];
    }


}
