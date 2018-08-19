package de.yefan.leetcode.dynamicprogramming.hanoi;

/**
 * 给定一个整形数组arr，其中只含1、2、3，代表所有圆盘目前的状态，1代表左柱，2代表中柱，3代表右柱，
 * arr[i]的值代表第i+1个圆盘的位置。比如arr[3,3,3,1]，代表第1个圆盘在右柱上、第2个圆盘在右柱上、第3个圆盘在
 * 中柱上、第4个圆盘在左柱上。
 * <p>
 * 如果arr代表的状态是最优轨迹过程中出现的状态，返回arr这种状态是最优移动轨迹中的第几个状态。
 * 如果arr代表的状态不是最优移动轨迹过程中出现的状态，则返回-1。
 * <p>
 * S(i) = S(i-1) + 1 + S(i-1) ====> S(i) = 2^i-1;
 */
public class P1 {
    public static void main(String[] args) {
        int[] arr = {3, 3, 3, 1};
        int res = step1(arr);
        System.out.println(res);
        res = step2(arr);
        System.out.println(res);
    }

    public static int step1(int[] arr) {
        if (arr == null || arr.length <= 0) {
            return -1;
        }
        return processor(arr, arr.length - 1, 1, 2, 3);
    }

    public static int step2(int[] arr) {
        if (arr == null || arr.length <= 0) {
            return -1;
        }
        int from = 1;
        int mid = 2;
        int to = 3;
        int i = arr.length - 1;
        int res = 0;
        int tmp = 0;
        while (i >= 0) {
            if (arr[i] != from && arr[i] != to) {
                return -1;
            }
            if (arr[i] == to) {
                res += 1 << i;
                tmp = from;
                from = mid;
            } else {
                tmp = to;
                to = mid;
            }
            mid = tmp;
            i--;
        }

        return res;
    }

    public static int processor(int[] arr, int i, int from, int mid, int to) {
        if (i == -1) {
            return 0;
        }
        if (arr[i] != from && arr[i] != to) {
            return -1;
        }
        if (arr[i] == from) {
            return processor(arr, i - 1, from, to, mid);
        } else {
            int rest = processor(arr, i - 1, mid, from, to);
            if (rest == -1) {
                return -1;
            }
            return (1 << i) + rest;
        }
    }

}
