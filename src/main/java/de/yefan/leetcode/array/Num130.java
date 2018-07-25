package de.yefan.leetcode.array;

/**
 * Surrounded Regions
 * https://leetcode.com/problems/surrounded-regions/description/
 */
public class Num130 {
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || i == row - 1) {
                    continue;
                }
                if (board[i][j] == 'O' && isSurrounded(board, i, j)) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private boolean isSurrounded(char[][] board, int row, int col) {

        if (board.length <= 0) {
            return false;
        }

        boolean left = false;
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 'X') {
                left = true;
                break;
            }
        }
        boolean right = false;
        for (int i = col + 1; i < board[0].length; i++) {
            if (board[row][i] == 'X') {
                right = true;
                break;
            }
        }
        boolean top = false;
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'X') {
                top = true;
                break;
            }
        }
        boolean bottom = false;
        for (int i = row + 1; i < board.length; i++) {
            if (board[i][col] == 'X') {
                bottom = true;
                break;
            }
        }

        return (left & right & top & bottom);
    }

    public void solve1(char[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        if (board.length < 3 || board[0].length < 3) {
            return;
        }
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                helper(board, i, 0);
            }
            if (board[i][n - 1] == 'O') {
                helper(board, i, n - 1);
            }
        }
        for (int j = 1; j < n - 1; j++) {
            if (board[0][j] == 'O') {
                helper(board, 0, j);
            }
            if (board[m - 1][j] == 'O') {
                helper(board, m - 1, j);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void helper(char[][] board, int r, int c) {
        if (r < 0 || c < 0 || r > board.length - 1 || c > board[0].length - 1 || board[r][c] != 'O') {
            return;
        }
        board[r][c] = '*';
        helper(board, r + 1, c);
        helper(board, r - 1, c);
        helper(board, r, c + 1);
        helper(board, r, c - 1);
    }
}
