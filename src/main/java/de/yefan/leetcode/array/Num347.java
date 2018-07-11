package de.yefan.leetcode.array;

import java.util.*;

/**
 * Top K Frequent Elements
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 */
public class Num347 {

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!frequencyMap.containsKey(nums[i])) {
                frequencyMap.put(nums[i], 1);
            } else {
                frequencyMap.put(nums[i], frequencyMap.get(nums[i]) + 1);
            }
        }

        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        List<Integer> res = new ArrayList<>();

        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Num347 num347 = new Num347();
        int[] nums = {};
        num347.topKFrequent(nums, 1);

    }

}
