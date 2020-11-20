package com.khamurai.sudoku;

public class Queens {

    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0}};

        solve(board, 0, board.length);

        printBoard(board);
    }

    private static boolean possible(int[][] board, int x, int y) {
        for(int i = 0; i < board.length; i++) {
            if(board[i][x] == 1) {
                return false;
            }
        }

        //UPP VÄNSTER
        for(int i = x, j = y; i >= 0 && j >= 0; i--, j--) {
            if(board[j][i] == 1) {
                return false;
            }
        }

        //UPP HÖGER
        for(int i = x, j = y; i < board.length && j > 0; i++, j--) {
            if(board[j][i] == 1) {
                return false;
            }
        }

        return true;
    }

    private static boolean solve(int[][] board, int row, int q) {
        if(q == 0) {
            return true;
        }

        for(int i = 0; i < board.length; i++) {
            if(possible(board, i, row)) {
                board[row][i] = 1;
                if(solve(board, row + 1, q -1)) {
                    return true;
                } else {
                    board[row][i] = 0;
                }
            }
        }

        return false;
    }

    private static void printBoard(int[][] board) {
        for(int y = 0; y < board.length; y++) {
            for(int x = 0; x < board[y].length; x++) {
                if(board[y][x] == 1) {
                    System.out.print(" Q ");
                } else {
                    System.out.print(" - ");
                }
            }
            System.out.println();
        }
    }
}
