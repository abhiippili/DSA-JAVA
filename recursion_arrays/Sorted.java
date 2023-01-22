package com.recursion_arrays;

public class Sorted {
    public static void main(String[] args) {
        int[] arr = {1,3,6,8,12,17};
        System.out.println(isSorted(arr, 0));
        System.out.println(itSorted(arr));
    }

    public static boolean itSorted(int[] arr){
        int i = 0;
        for(;i < arr.length - 1; i++) {
            if (arr[i] >= arr[i + 1])
                return false;
        }
        return true;
    }

    //recursive approach - seeping
    public static boolean isSorted(int[] arr, int i){
        if(i == arr.length - 1)
            return true;
        return (arr[i] < arr[i + 1]) && isSorted(arr,i + 1);
    }
}
