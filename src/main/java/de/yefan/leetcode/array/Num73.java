package de.yefan.leetcode.array;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Set Matrix Zeroes
 * https://leetcode.com/problems/set-matrix-zeroes/description/
 */
public class Num73 {

    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        boolean firstColZero = false, firstRowZero = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
            }
        }
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 1; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (firstColZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        if (firstRowZero) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
    }

    public void setZeroes1(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        HashSet<Integer> xCoor = new HashSet<>();
        HashSet<Integer> yCoor = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (xCoor.contains(i) && yCoor.contains(j)) {
                        continue;
                    } else if (xCoor.contains(i) && !yCoor.contains(j)) {
                        yCoor.add(j);
                    } else if (!xCoor.contains(i) && yCoor.contains(j)) {
                        xCoor.add(i);
                    } else {
                        xCoor.add(i);
                        yCoor.add(j);
                    }
                }
            }
        }

        Iterator paintRow = xCoor.iterator();
        Iterator paintCol = yCoor.iterator();

        while (paintRow.hasNext()) {
            paintRow(matrix, paintRow.next());
        }


        while (paintCol.hasNext()) {
            paintCol(matrix, paintCol.next());
        }
    }

    private void paintRow(int[][] matrix, Object row) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[(int) row][i] = 0;
        }
    }


    private void paintCol(int[][] matrix, Object col) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][(int) col] = 0;
        }
    }
}
