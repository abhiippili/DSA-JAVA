package com.twopointers;

public class SumK {
    //given a sorted array, return the no.of pairs where sum = k
    public static void main(String[] args) {
        int[] arr = {1,3,4,4,5,5,5,5,6,6,7,11};
        System.out.println(countSumK(arr, 3));
    }
    public static int countSumK(int[] arr, int k){
        int count = 0;
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            if(arr[start] + arr[end] > k){
                end--;
            }
            else if(arr[start] + arr[end] < k){
                start++;
            }
            else{
                int temp1 = arr[start];
                int temp2 = arr[end];
                int c1 = 0;
                int c2 = 0;
                //this is when the sum is equal to target
                if(arr[start] != arr[end]){
                    while(arr[start] == temp1){
                        c1++;
                        start++;
                    }
                    while(arr[end] == temp2){
                        c2++;
                        end--;
                    }
                    count += c1 * c2;
                }
                else{
                    int n = end - start + 1;
                    //the same element contributing to the sum countC2
                    count += (n * (n - 1) / 2);
                    return count;
                }
            }
        }
        return count;
    }
}
