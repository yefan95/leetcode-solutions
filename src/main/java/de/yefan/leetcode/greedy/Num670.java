package de.yefan.leetcode.greedy;

/**
 * Maximum Swap
 * https://leetcode.com/problems/maximum-swap/description/
 */
public class Num670 {

    public int maximumSwap(int num) {
        char[] A = Integer.toString(num).toCharArray();
        int[] last = new int[10];
        for (int i = 0; i < A.length; i++) {
            last[A[i] - '0'] = i;
        }

        for (int i = 0; i < A.length; i++) {
            for (int d = 9; d > A[i] - '0'; d--) {
                if (last[d] > i) {
                    char tmp = A[i];
                    A[i] = A[last[d]];
                    A[last[d]] = tmp;
                    return Integer.valueOf(new String(A));
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        Num670 num670 = new Num670();
        int res = num670.maximumSwap(115);
        System.out.println(res);
    }
}
