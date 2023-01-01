package com.dsapractice;

public class InfinteArray {
    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 7, 7, 9, 10, 13, 17, 20, 25, 29};
        int target = 9;
        System.out.println(solution(arr,target));
    }

    public static int solution(int arr[], int target) {
        int start = 0;
        int end = 1;
        while(target > arr[end]){
            int tempStart = start;
            start = end + 1;
            end = end + (end - tempStart + 1) * 2;
        }
        return search(arr,target,start,end);
    }
    public static int search(int arr[], int target, int start, int end){
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(target == arr[mid])
                return mid;
            else if(target > arr[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }
}
