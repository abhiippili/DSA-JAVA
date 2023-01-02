package com.dsapractice;

public class FindInMountain {
    public static void main(String[] args) {
        int arr[] = {1,2,5,9,3,2,0,-1};
        int target = 0;
        int peakIndex = findPeak(arr);
        int ans = orderAgnosticSearch(arr,target,0,peakIndex);
        if(ans == -1)
            ans = orderAgnosticSearch(arr,target,peakIndex + 1, arr.length -1);
        System.out.println(ans);
    }
    public static int findPeak(int arr[]){
        int start = 0;
        int end = arr.length - 1;
        while(start < end){
            int mid = start + (end - start) / 2;
            if(arr[mid] < arr[mid + 1])
                start = mid + 1;
            else if(arr[mid] > arr[mid + 1])
                end = mid;
        }
        return end;
    }
    public static int orderAgnosticSearch(int arr[], int target, int start, int end){
//        int start = 0;
//        int end = arr.length - 1;
        boolean isAsc = arr[end] > arr[start];

        while(start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] == target)
                return mid;
            if(isAsc){
                if(target > arr[mid])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
            else{
                if(target > arr[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            }
        }
        return -1;
    }
}
