package com.dsapractice;

import java.util.Arrays;

public class StrictlySortedSearchIn2DII {
    public static void main(String[] args) {
        int arr[][] = {
                {1,3,5,7,8},
                {9,15,25,29,30},
                {34,35,51,59,65},
                {66,68,103,105,109}
        };
        int target = 109;
        System.out.println(Arrays.toString(search(arr,target)));
    }
    public static int[] search(int matrix[][], int target){
        int start = 0;
        int end = matrix.length * matrix[0].length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            int mMid = mid / matrix[0].length;
            int nMid = mid % matrix[0].length;
            if (target == matrix[mMid][nMid])
                return new int[]{mMid,nMid};
            else if (target > matrix[mMid][nMid])
                start = mid + 1;
            else
                end = mid - 1;
        }
        return new int[]{-1,-1};
    }
}
