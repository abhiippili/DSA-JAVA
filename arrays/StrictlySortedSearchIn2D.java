package com.dsapractice;

import java.util.Arrays;

public class StrictlySortedSearchIn2D {
    public static void main(String[] args) {
        int arr[][] = {
                {1,3,5,7},
                {9,15,25,29},
                {34,35,51,59},
                {66,68,103,105}
        };
        int target = 59;
        Solution(arr,target);
    }
    public static void Solution(int arr[][], int target){
        //2D to 1D array conversion
        int newarr[] = new int[arr.length * arr[0].length];
        int k = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++) {
                newarr[k] = arr[i][j];
                k++;
            }
        }
        System.out.println(binarySearch(newarr,target));
    }
    public static int binarySearch(int arr[], int target){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(target == arr[mid])
                return mid;
            else if (target > arr[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }
}
