/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.*;

/**
 * Solve a 9x9 sudoku board
 * https://practice.geeksforgeeks.org/problems/solve-the-sudoku/0
 * @author Mathew Wright
 */
public class Sudoku {

    private static int[][] grid = new int[9][9];

    /**
     * Given a suduko board 9x9 containing values 0-9, solve and update 
     * the board stored in class variable grid.
     * 0 represents no value.
     * 
     * @return true if board was solved, false otherwise
     */
    public static boolean solveSuduko() {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        
        //find next empty cell
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] == 0) {
                    row = i;
                    col = j;
                    isEmpty = false;
                }
            }
            if (!isEmpty) {
                break;
            }
        }
        //if no more empty cells, grid is solved
        if (isEmpty) {
            return true;
        }
        //try to fill cell with 1-9
        for (int i = 1; i <= 9; i++) {
            //only fill if safe
            if (isSafe(row, col, i)) {
                grid[row][col] = i;
                if (solveSuduko()) {
                    return true;
                } 
                //undo the change, no solution found when inputting i into row column
                grid[row][col] = 0;
                
            }
        }
        return false;
    }

    /**
     * Checks if a given cell can be safely converted to a given value
     * without breaking the rules of sudoku.
     * @param row row of cell to fill in
     * @param col column of cell to fill in
     * @param num value if input into cell
     * @return true if cell can be safely filled to num, false otherwise.
     */
    public static boolean isSafe(int row, int col, int num) {
        //check for row safe
        for (int i = 0; i < 9; i++) {
            if (grid[row][i] == num) {
                return false;
            }
        }
        //check for column safe
        for (int i = 0; i < 9; i++) {
            if (grid[i][col] == num) {
                return false;
            }
        }
        
        //check for grid (3x3) safe
        int x = row - row % 3;//round down nearest mulyiple of 3
        int y = col - col % 3;//round down nearest mulyiple of 3
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (grid[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Reads formulated console input for the sudoku board,
     * prints the completed board to console.
     * Sudoku board contains values 0-9 where 0 represents no value.
     * Input:
     * The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains 9*9 space separated values of the matrix mat[][] representing an incomplete Sudoku state where a 0 represents empty block.
     * 
     * Output:
     * For each test case, in a new line,      * 
     * print the space separated values of the solution of the the sudoku.
     * Each row will end with a new line.
     * 
     * 
     * Example:
     * Input:
     * 1
     * 3 0 6 5 0 8 4 0 0
     * 5 2 0 0 0 0 0 0 0
     * 0 8 7 0 0 0 0 3 1 
     * 0 0 3 0 1 0 0 8 0
     * 9 0 0 8 6 3 0 0 5
     * 0 5 0 0 9 0 6 0 0
     * 1 3 0 0 0 0 2 5 0
     * 0 0 0 0 0 0 0 7 4
     * 0 0 5 2 0 6 3 0 0

     * Output:
     * 3 1 6 5 7 8 4 9 2
     * 5 2 9 1 3 4 7 6 8
     * 4 8 7 6 2 9 5 3 1
     * 2 6 3 4 1 5 9 8 7
     * 9 7 4 8 6 3 1 2 5
     * 8 5 1 7 9 2 6 4 3
     * 1 3 8 9 4 7 2 5 6
     * 6 9 2 3 5 1 8 7 4
     * 7 4 5 2 8 6 3 1 9
     * 
     * *Note, to make it easier to copy and paste in the sudoku board, it still works
     * if the whole board in in one line. Copy and paste the below line and it will work.
     
      1      
      3 0 6 5 0 8 4 0 0      
      5 2 0 0 0 0 0 0 0     
      0 8 7 0 0 0 0 3 1 
      0 0 3 0 1 0 0 8 0
      9 0 0 8 6 3 0 0 5
      0 5 0 0 9 0 6 0 0
      1 3 0 0 0 0 2 5 0
      0 0 0 0 0 0 0 7 4
      0 0 5 2 0 6 3 0 0
     * @param args 
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            if (solveSuduko()) {
                System.out.println();
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        System.out.print(grid[i][j] + " ");
                    }
                    System.out.println();

                }
                System.out.println();
            }
            t--;
        }
    }
}
