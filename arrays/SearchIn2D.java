package com.dsapractice;

import java.util.Arrays;

public class SearchIn2D {
    public static void main(String[] args) {
        //Row wise and Col wise sorted but not strictly ordered
        int arr[][] = {
                {10,12,17,19,40},
                {14,23,45,66,70},
                {24,28,46,49,99},
                {30,31,90,93,107}
        };
        int target = 28;
//        System.out.println(Arrays.toString(search(arr, target)));
        System.out.println(Arrays.toString(alternateSearch(arr,target)));
    }
    public static int[] search(int matrix[][], int target){
        int row = 0;
        int col = matrix.length - 1;
        while(row < matrix.length && col >= 0){
            if(matrix[row][col] == target)
                return new int[]{row,col};
            else if (matrix[row][col] < target)
                row++;
            else
                col--;
        }
        return new int[]{-1,-1};
    }

    public static int[] alternateSearch(int matrix[][], int target){
        int row = matrix.length - 1;
        int col = 0;
        while(row >= 0 && col < matrix[0].length){
            if(target == matrix[row][col])
                return new int[]{row,col};
            else if (target > matrix[row][col])
                col++;
            else
                row--;
        }
        return new int[]{-1,-1};
    }
}
