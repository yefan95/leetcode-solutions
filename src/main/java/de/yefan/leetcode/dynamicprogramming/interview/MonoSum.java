package de.yefan.leetcode.dynamicprogramming.interview;

/**
 * 现定义数组单调和为所有元素i的f(i)值之和。这里的f(i)函数定义为元素i左边(不包括其自身)小于等于它的数字之和。请设计一个高效算法，计算数组的单调和。
 * <p>
 * 给定一个数组A同时给定数组的大小n，请返回数组的单调和。保证数组大小小于等于500，同时保证单调和不会超过int范围。
 */
public class MonoSum {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 2, 4, 6};
        int res = calcMonoSum(arr, arr.length);
        System.out.println(res);
    }


    public static int calcMonoSum(int[] arr, int n) {
        // write code here
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int count = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] <= arr[i]) {
                    count+=arr[j];
                }
            }
            dp[i] = count;
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += dp[i];
        }
        return sum;
    }
}
