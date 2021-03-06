package de.yefan.leetcode.array;

/**
 * Best Time to Buy and Sell Stock III
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
 */
public class Num123 {
    public int maxProfit(int[] prices) {
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;
        // Assume we only have 0 money at first
        for (int price : prices) {
            // The maximum if we've just sold 2nd stock so far.
            release2 = Math.max(release2, hold2 + price);
            // The maximum if we've just buy  2nd stock so far.
            hold2 = Math.max(hold2, release1 - price);
            // The maximum if we've just sold 1nd stock so far.
            release1 = Math.max(release1, hold1 + price);
            // The maximum if we've just buy  1st stock so far.
            hold1 = Math.max(hold1, -price);
        }
        //Since release1 is initiated as 0, so release2 will always higher than release1.
        return release2;
    }

    public int maxProfit1(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int[] l = new int[prices.length + 1];
        int[] r = new int[prices.length + 1];
        int sum = 0;
        int diff[] = new int[prices.length];
        for (int i = 1; i < diff.length; i++) {
            diff[i] = prices[i] - prices[i - 1];
        }
        for (int i = 2; i < l.length; i++) {
            l[i] = Math.max(diff[i - 1] + sum, l[i - 1]);
            sum = Math.max(0, sum + diff[i - 1]);
        }
        sum = 0;
        for (int i = r.length - 3; i >= 0; i--) {
            r[i] = Math.max(diff[i + 1] + sum, r[i + 1]);
            sum = Math.max(0, sum + diff[i + 1]);
        }
        sum = 0;
        for (int i = r.length - 1; i >= 0; i--) {
            if (l[i] + r[i] > sum) {
                sum = l[i] + r[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Num123 num123 = new Num123();
        int[] prices = {1, 2, 3, 4, 5};
        int profit = num123.maxProfit(prices);
        System.out.println(profit);
    }


}
