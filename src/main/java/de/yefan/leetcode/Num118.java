package de.yefan.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Pascal's Triangle
 * https://leetcode.com/problems/pascals-triangle/description/
 */
public class Num118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) {
            return res;
        }
        List<Integer> list;
        int row = 1;

        while (row <= numRows) {
            if (row == 1) {
                list = new ArrayList<>();
                list.add(1);
                res.add(list);
            } else if (row == 2) {
                list = new ArrayList<>();
                list.add(1);
                list.add(1);
                res.add(list);
            } else {
                list = new ArrayList<>();
                List<Integer> pre = res.get(row - 2);
                int index = 0;
                for (int i = 0; i < row; i++) {
                    if (i == 0) {
                        list.add(1);
                    } else if (i == row - 1) {
                        list.add(1);
                    } else {
                        list.add(pre.get(index) + pre.get(index + 1));
                        index++;
                    }
                }
                res.add(list);
            }
            row++;
        }

        return res;
    }

    public List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();

        // First base case; if user requests zero rows, they get zero rows.
        if (numRows == 0) {
            return triangle;
        }

        // Second base case; first row is always [1].
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum - 1);

            // The first row element is always 1.
            row.add(1);

            // Each triangle element (other than the first and last of each row)
            // is equal to the sum of the elements above-and-to-the-left and
            // above-and-to-the-right.
            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            // The last row element is always 1.
            row.add(1);

            triangle.add(row);
        }

        return triangle;
    }

    public static void main(String[] args) {
        Num118 num118 = new Num118();
        List<List<Integer>> res = num118.generate(5);
        System.out.println(res);
    }

}
