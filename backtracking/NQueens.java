package com.backtracking;

import java.util.ArrayList;

public class NQueens {
    public static void main(String[] args) {
        //initially, the board has all false values
        boolean[][] board = new boolean[4][4];
        System.out.println(queens(board, 0));

    }
    static int queens(boolean[][] board, int r){
        if(r == board.length){
            //this is when i have processed all the rows
            display(board);
            System.out.println();
            return 1;
        }
        int count = 0;
        for(int i = 0; i < board.length; i++){
            //this is in calling phase of all the rec calls for a row
            //but also, I can only place a queen if it is safe to
            if(isSafe(board, r, i)){
                board[r][i] = true;
                //if it is not safe to place a queen in a pos, u don't even have to call it
                count += queens(board, r + 1);
                board[r][i] = false;
            }
        }
        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        //vertical checking
        for(int i = 0; i < row; i++){
            if(board[i][col]){
                return false;
            }
        }
        int r = row;
        int c = col;
        //for the left unsafe vector, the walls are first row and first col
        while(r >= 0 && c >= 0){
            if(board[r][c]){
                return false;
            }
            r--;
            c--;
        }
        //re assigning original row and col values
        r = row;
        c = col;
        //while, for the right unsafe vector, the walls are first row and last col
        while(r >= 0 && c <= board.length - 1){
            if(board[r][c]){
                return false;
            }
            r--;
            c++;
        }
        return true;
    }

    private static void display(boolean[][] board) {
        for(boolean[] row : board){
            for(boolean element : row){
                if(element){
                    System.out.print("Q ");
                }
                else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
