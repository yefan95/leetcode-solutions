package de.yefan.leetcode.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Combination Sum II
 * https://leetcode.com/problems/combination-sum-ii/description/
 */
public class Num40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length <= 0) {
            return result;
        }
        Arrays.sort(candidates);
        helper(result, new ArrayList<>(), candidates, target, 0);

        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> path, int[] candidates, int target, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        } else if (target > 0) {
            for (int i = start; i < candidates.length; i++) {
                //skip duplicates
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                path.add(candidates[i]);
                helper(result, path, candidates, target - candidates[i], i + 1);
                path.remove(path.size() - 1);
            }
        } else {
            return;
        }
    }
}
