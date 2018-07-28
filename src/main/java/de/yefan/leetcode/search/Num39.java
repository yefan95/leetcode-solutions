package de.yefan.leetcode.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Combination Sum
 * https://leetcode.com/problems/combination-sum/description/
 */
public class Num39 {


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length <= 0) {
            return result;
        }
        Arrays.sort(candidates);
        helper(result, new ArrayList<>(), candidates, target, 0);

        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> path, int[] candidates, int target, int start) {
        if (start > candidates.length - 1) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        } else if (target > 0) {
            for (int i = start; i < candidates.length; i++) {
                if (target >= candidates[i]) {
                    path.add(candidates[i]);
                    helper(result, path, candidates, target - candidates[i], i);
                    path.remove(path.size() - 1);
                }
            }
        } else {
            return;
        }
    }

    public static void main(String[] args) {
        Num39 num39 = new Num39();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = num39.combinationSum(candidates, target);
        System.out.println(Arrays.toString(result.toArray()));
    }
}
