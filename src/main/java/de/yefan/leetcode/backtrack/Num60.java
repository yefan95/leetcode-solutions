package de.yefan.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Permutation Sequence
 * https://leetcode.com/problems/permutation-sequence/description/
 */
public class Num60 {
    public String getPermutation(int n, int k) {
        boolean[] used = new boolean[n];
        return helper(n, k, used);
    }

    private String helper(int n, int k, boolean[] used) {
        // termination
        if (n == 0) {
            return "";
        }

        // recursion
        int sum = 1;
        for (int i = n; i >= 1; i--) {
            sum *= i;
        }
        int section = sum / n;

        int index = 0;
        // point to next available number
        while (used[index] == true) {
            index++;
        }

        while (k > section) {
            k -= section;
            // next available number
            index++;
            while (used[index] == true) {
                index++;
            }
        }

        used[index] = true;
        return String.valueOf(index + 1) + helper(n - 1, k, used);
    }

    public String getPermutation1(int n, int k) {
        int pos = 0;
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n + 1];
        StringBuilder sb = new StringBuilder();

        int sum = 1;
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
            factorial[i] = sum;
        }

        // factorial[] = {1, 1, 2, 6, 24, ... n!}

        // create a list of numbers to get indices
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        // numbers = {1, 2, 3, 4}

        k--;

        for (int i = 1; i <= n; i++) {
            int index = k / factorial[n - i];
            sb.append(String.valueOf(numbers.get(index)));
            numbers.remove(index);
            k -= index * factorial[n - i];
        }


        return String.valueOf(sb);
    }

    public String getPermutation2(int n, int k) {

        // recursive
        // how do you make the problem smaller?
        List<Integer> list = new ArrayList<>();
        // 1,1,2,6
        int[] factorials = new int[n];
        factorials[0] = 1;
        for (int i = 1; i < n; i++) {
            factorials[i] = factorials[i - 1] * i;
        }

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        return helper(list, k, factorials);
    }

    private String helper(List<Integer> list, int k, int[] factorials) {

        if (list.size() == 0) {
            return "";
        }

        int num = (k - 1) / factorials[list.size() - 1];
        String str = "" + list.get(num);
        k -= num * factorials[list.size() - 1];
        list.remove(num);

        return str + helper(list, k, factorials);
    }


}
