package de.yefan.leetcode.array;

/**
 * Best Time to Buy and Sell Stock II
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 */
public class Num122 {

    public int maxProfit(int[] prices) {
        if (prices == null) {
            return 0;
        }
        int profit = 0;
        int size = prices.length;
        for (int i = 1; i < size; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

    public int maxProfit1(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            prices[i - 1] = prices[i] - prices[i - 1];
        }
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] > 0) {
                profit += prices[i];
            }
        }
        return profit;
    }

}
