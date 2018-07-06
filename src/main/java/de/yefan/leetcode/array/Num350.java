package de.yefan.leetcode.array;

import java.util.*;

/**
 * Intersection of Two Arrays II
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
 */
public class Num350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                map.put(nums1[i], map.get(nums1[i]) + 1);
            } else {
                map.put(nums1[i], 1);
            }
        }

        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
                result.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }

        int[] res = new int[result.size()];

        for (int i = 0; i < res.length; i++) {
            res[i] = result.get(i);
        }

        return res;
    }

    public int[] intersect1(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        int index = 0;
        int[] tmp = new int[nums1.length];

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                tmp[index++] = nums1[i];
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int[] res = new int[index];
        for (int k = 0; k < index; k++) {
            res[k] = tmp[k];
        }

        return res;
    }

}
