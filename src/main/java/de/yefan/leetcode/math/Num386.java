package de.yefan.leetcode.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Lexicographical Numbers
 * https://leetcode-cn.com/problems/lexicographical-numbers/description/
 */
public class Num386 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>(n);
        for (int i = 1; i <= 9; i++) {
            if (i > n) {
                break;
            }
            dfs(i, res, n);
        }
        return res;
    }

    private void dfs(int i, List<Integer> res, int n) {
        res.add(i);
        for (int m = 0; m <= 9; m++) {
            if (i * 10 + m > n) {
                break;
            }
            dfs(i * 10 + m, res, n);
        }
    }

    public List<Integer> lexicalOrder1(int n) {
        List<Integer> res = new ArrayList<>(n);
        res.add(1);
        int pre = 1;
        for (int i = 1; i < n; i++) {
            if (pre * 10 <= n) {
                pre *= 10;
            } else {
                while (pre % 10 == 9 || pre == n) {
                    pre /= 10;
                }
                pre++;
            }
            res.add(pre);
        }
        return res;
    }

    /**
     * 暴力法(超时)
     *
     * @param n
     * @return
     */
    public List<Integer> lexicalOrder2(int n) {
        List<Integer> res = new ArrayList<>();
        String[] arr = new String[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = String.valueOf(i + 1);
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            res.add(Integer.parseInt(arr[i]));
        }
        return res;
    }

    public static void main(String[] args) {
        Num386 num386 = new Num386();
        List<Integer> res = num386.lexicalOrder1(12);
        System.out.println(Arrays.toString(res.toArray()));
    }
}
