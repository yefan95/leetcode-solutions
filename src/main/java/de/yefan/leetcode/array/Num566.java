package de.yefan.leetcode.array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Reshape the Matrix
 * https://leetcode.com/problems/reshape-the-matrix/description/
 */
public class Num566 {

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int[][] res = new int[r][c];
        if (nums.length == 0 || r * c != nums.length * nums[0].length) {
            return nums;
        }
        int rows = 0, cols = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                res[rows][cols] = nums[i][j];
                cols++;
                if (cols == c) {
                    rows++;
                    cols = 0;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Num566 num566 = new Num566();
        int[][] nums = {{1, 2}, {3, 4}};
        int[][] res = num566.matrixReshape(nums, 1, 4);
        System.out.println(res.length);
        System.out.println(res[0].length);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {

                System.out.print(" " + res[i][j]);
                if (j == res[0].length - 1) {
                    System.out.print("\n");
                }
            }
        }
    }

    public int[][] matrixReshape1(int[][] nums, int r, int c) {
        int[][] res = new int[r][c];
        if (nums.length == 0 || r * c != nums.length * nums[0].length) {
            return nums;
        }
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                queue.add(nums[i][j]);
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j] = queue.remove();
            }
        }
        return res;
    }

}
