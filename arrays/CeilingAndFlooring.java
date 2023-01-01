package com.dsapractice;

public class CeilingAndFlooring {
    public static void main(String[] args) {
        int arr[] = {2,4,5,11,14,15,19,22};
        int target = 16;
        System.out.println(ceiling(arr,target));
        System.out.println(flooring(arr,target));
        int arr1[] = {2,4,5,5,5,9,11,11,17,20,20,20,20};
        int target1 = 20;
        System.out.println(leetcodeCeil(arr1,target1));
    }
    public static int ceiling(int arr[], int target){
        if(target > arr[arr.length - 1])
            return -1;
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(target == arr[mid])
                return arr[mid];
            else if (target > arr[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }
        return arr[start];
    }
    public static int flooring(int arr[], int target){
        if(target < arr[0])
            return -1;
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(target == arr[mid])
                return arr[mid];
            else if(target > arr[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }
        return arr[end];
    }
//    leetcode question -
//        all the equal elements are to be skipped to right
//        wrapping is also allowed
    public static int leetcodeCeil(int arr[], int target){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(target >= arr[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }
        return arr[start % arr.length];
    }
}

