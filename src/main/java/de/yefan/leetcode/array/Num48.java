package de.yefan.leetcode.array;

/**
 * Rotate Image
 * https://leetcode.com/problems/rotate-image/description/
 * <p>
 * <p>
 * The idea was firstly transpose the matrix and then flip it symmetrically. For instance,
 * <p>
 * 1  2  3
 * 4  5  6
 * 7  8  9
 * after transpose, it will be swap(matrix[i][j], matrix[j][i])
 * <p>
 * 1  4  7
 * 2  5  8
 * 3  6  9
 * Then flip the matrix horizontally. (swap(matrix[i][j], matrix[i][matrix.length-1-j])
 * <p>
 * 7  4  1
 * 8  5  2
 * 9  6  3
 */
public class Num48 {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length <= 0) {
            return;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }

    public void rotate1(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        Num48 num48 = new Num48();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        num48.rotate(matrix);
    }
}
