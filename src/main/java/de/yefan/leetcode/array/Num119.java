package de.yefan.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Pascal's Triangle II
 * https://leetcode.com/problems/pascals-triangle-ii/description/
 */
public class Num119 {

    public List<Integer> getRow(int rowIndex) {

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
            res.add(1);
            for (int j = i - 1; j > 0; j--) {
                res.set(j, res.get(j - 1) + res.get(j));
            }
        }

        return res;
    }

    public List<Integer> getRow1(int rowIndex) {
        List<Integer> list = new ArrayList<>(rowIndex + 1);
        list.add(1);
        long prev = 1;
        long rowIndexPlusOne = rowIndex + 1;
        for (int i = 1; i <= rowIndex; i++) {
            prev = (prev * (rowIndexPlusOne - i)) / i;
            list.add((int) prev);
        }
        return list;
    }


    public static void main(String[] args) {
        Num119 num119 = new Num119();
        List<Integer> res = num119.getRow(3);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
