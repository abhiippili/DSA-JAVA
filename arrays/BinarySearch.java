package com.dsapractice;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1,2,6,11,13,15,20};
        int target = 15;
        System.out.println(search(arr, target));
    }
    public static int search(int arr[], int target){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = end - (end - start) / 2;
            if(target == arr[mid])
                return mid;
            else if (target >= arr[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }
}
