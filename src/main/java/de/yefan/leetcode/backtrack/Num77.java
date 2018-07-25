package de.yefan.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Combinations
 * https://leetcode.com/problems/combinations/description/
 */
public class Num77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n < k) {
            return result;
        }
        helper(1, n, k, result, new ArrayList<>());

        return result;
    }

    private void helper(int m, int n, int k, List<List<Integer>> result, List<Integer> track) {
        if (track.size() == k) {
            List<Integer> list = new ArrayList<>(track);
            result.add(list);
            return;
        }
        if (m > n) {
            return;
        }

        for (int i = m; i <= n; i++) {
            track.add(i);
            helper(i + 1, n, k, result, track);
            track.remove(track.size() - 1);
        }
    }
}

