package de.yefan.leetcode.dynamicprogramming.interview;

/**
 * 在股市的交易日中，假设最多可进行两次买卖(即买和卖的次数均小于等于2)，规则是必须一笔成交后进行另一笔(即买-卖-买-卖的顺序进行)。
 * 给出一天中的股票变化序列，请写一个程序计算一天可以获得的最大收益。请采用实践复杂度低的方法实现。
 * <p>
 * 给定价格序列prices及它的长度n，请返回最大收益。保证长度小于等于500。
 */
public class Stock {
    public static void main(String[] args) {
//        int[] prices = {10, 22, 5, 75, 65, 80};
        int[] prices = {558, 48, 172, 370, 262, 451, 34};
        int res = maxProfit(prices, prices.length);
        System.out.println(res);
    }

    public static int maxProfit(int[] prices, int n) {
        // write code here
        int[] preProfit = new int[n];
        int[] postProfit = new int[n];
        int minBuy = prices[0];
        for (int i = 1; i < n; i++) {
            minBuy = Math.min(prices[i], minBuy);
            preProfit[i] = Math.max(preProfit[i - 1], prices[i] - minBuy);
        }

        int maxSell = prices[n - 1];
        for (int j = n - 2; j >= 0; j--) {
            maxSell = Math.max(prices[j], maxSell);
            postProfit[j] = Math.max(postProfit[j + 1], maxSell - prices[j]);
        }

        int maxProfit = 0;

        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, preProfit[i] + postProfit[i]);
        }

        return maxProfit;
    }

}
