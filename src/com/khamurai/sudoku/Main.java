package com.khamurai.sudoku;

public class Main {

    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 8, 0, 4, 9, 3, 7},
                {0, 7, 4, 1, 0, 0, 0, 8, 0},
                {8, 3, 2, 0, 0, 0, 4, 0, 0},
                {2, 0, 5, 3, 0, 0, 7, 4, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 6},
                {1, 4, 3, 0, 0, 0, 2, 0, 0},
                {0, 0, 7, 0, 9, 0, 6, 0, 0},
                {0, 2, 1, 7, 5, 6, 8, 9, 0},
                {6, 5, 9, 2, 3, 0, 0, 7, 4}};

        int[][] emptyBoard = {{0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}};


        System.out.println("EMPTY BOARD");
        if (solve(emptyBoard)) {
            printBoard(emptyBoard, emptyBoard.length);
        } else {
            System.out.println("No solution");
        }

        System.out.println("==============================");
        System.out.println("Pre-filled board");


        if (solve(board)) {
            printBoard(board, board.length);
        } else {
            System.out.println("No solution");
        }
    }

    private static boolean possible(int[][] board, int x, int y, int value) {
        for (int i = 0; i < 9; i++) {
            if (board[y][i] == value || board[i][x] == value) {
                return false;
            }
        }
        int x0 = (int) Math.floor(x / 3) * 3;
        int y0 = (int) Math.floor(y / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[y0 + i][x0 + j] == value) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean solve(int[][] board) {
        int row = -1;
        int col = -1;
        boolean isSolved = true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    isSolved = false;
                    break;
                }
            }
            if (!isSolved) {
                break;
            }
        }

        if (isSolved) {
            return true;
        }

        for (int num = 1; num <= board.length; num++) {
            //  Loopa igenom alla värden från 1 till 9
            //  Kolla om man kan placera aktuellt värd på aktuell position
            if (possible(board, col, row, num)) {
                //  Om ja, placera aktuellt värde
                board[row][col] = num;
                //  anropa solve
                if (solve(board)) {
                    return true;
                } else {
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    public static void printBoard(int[][] board, int n) {
        for (int r = 0; r < n; r++) {
            for (int d = 0; d < n; d++) {
                System.out.print(board[r][d]);
                System.out.print(" ");
            }
            System.out.print("\n");

            if ((r + 1) % (int) Math.sqrt(n) == 0) {
                System.out.print("");
            }
        }
    }
}
