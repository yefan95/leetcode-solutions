package de.yefan.leetcode.greedy;

/**
 * Create Maximum Number
 * https://leetcode.com/problems/create-maximum-number/description/
 */
public class Num321 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] result = new int[k];
        int m = nums1.length, n = nums2.length;
        for (int len1 = Math.max(0, k - n); len1 <= Math.min(m, k); len1++) {
            // 0<=len2=k-len1<=n -> k-n<=len1<=n
            int len2 = k - len1;
            int[] candidate = merge(maxArray(nums1, len1), maxArray(nums2, len2));
            if (greater(candidate, 0, result, 0)) {
                result = candidate;
            }
        }

        return result;
    }

    public int[] maxArray(int[] nums, int len) {
        int[] res = new int[len];
        for (int i = 0, idx = 0; i < nums.length && idx < len; i++) {
            while (idx != -1 && nums[i] > res[idx] && nums.length - i >= len - idx) {
                idx--;
            }
            if (idx + 1 < len) {
                res[++idx] = nums[i];
            }
        }

        return res;
    }

    public int[] merge(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];
        for (int idx = 0, i = 0, j = 0; idx < res.length; idx++) {
            if (greater(a, i, b, j)) {
                res[idx] = a[i++];
            } else {
                res[idx] = b[j++];
            }
        }

        return res;
    }

    public boolean greater(int[] a, int i, int[] b, int j) {
        for (; i < a.length && j < b.length; i++, j++) {
            if (a[i] == b[j]) {
                continue;
            }
            return a[i] > b[j];
        }

        return i != a.length;
    }

}
