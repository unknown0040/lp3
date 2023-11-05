package Sem7.DAA;

import java.util.Scanner;

public class NQueens1 {

    public static void solveNQueens(int n) {
        int[] board = new int[n];
        if (placeQueens(board, 0, n)) {
            printSolution(board);
        } else {
            System.out.println("No solution found.");
        }
    }

    private static boolean placeQueens(int[] board, int row, int n) {
        if (row == n) {
            return true;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row] = col;
                if (placeQueens(board, row + 1, n)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isSafe(int[] board, int row, int col, int n) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col || Math.abs(board[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }

    private static void printSolution(int[] board) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("no. of queens: ");
        int n = input.nextInt();
//        int n = 8; // Change this to the desired board size (e.g., 4, 8, 12, etc.)
        solveNQueens(n);
    }
}
