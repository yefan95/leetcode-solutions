package de.yefan.leetcode.dynamicprogramming.interview;

/**
 * 上台阶
 * <p>
 * 有一楼梯共m级，刚开始时你在第一级，若每次只能跨上一级或者二级，要走上m级，共有多少走法？注：规定从一级到一级有0种走法。
 * <p>
 * 给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100。为了防止溢出，请返回结果Mod 1000000007的值。
 */
public class GoUpstairs {

    public static void main(String[] args) {
        GoUpstairs goUpstairs = new GoUpstairs();
        int res = goUpstairs.countWays2(50);
        System.out.println(res);
        res = goUpstairs.countWays3(50);
        System.out.println(res);
    }

    /**
     * 超时
     *
     * @param n
     * @return
     */
    public int countWays1(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        return (countWays1(n - 1) % 1000000007 + countWays1(n - 2) % 1000000007) % 1000000007;
    }

    public int countWays2(int n) {
        // write code here
        if (n == 1 || n == 2) {
            return n;
        }

        int dp[] = new int[n];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }

        return dp[n - 1];
    }

    public int countWays3(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        int first = 1;
        int last = 1;
        int sum = 2;
        for (int i = 3; i <= n; i++) {
            sum = first + last;
            sum = sum % 1000000007;
            first = last;
            last = sum;
        }
        return sum;
    }
}
