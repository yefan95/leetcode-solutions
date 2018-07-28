package de.yefan.leetcode.search;

import java.util.ArrayList;
import java.util.List;

/**
 * Combination Sum III
 * https://leetcode.com/problems/combination-sum-iii/description/
 */
public class Num216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<>(), k, n, 1);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> path, int k, int target, int start) {
        if (path.size() > k) {
            return;
        } else if (path.size() == k && target == 0) {
            result.add(new ArrayList<>(path));
        } else {
            for (int i = start; i <= 9; i++) {
                path.add(i);
                helper(result, path, k, target - i, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }
}
