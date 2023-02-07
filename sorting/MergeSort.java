package com.sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 1, 4};
//        System.out.println(Arrays.toString(mergeSort(arr)));
//        System.out.println(Arrays.toString(arr));
        mergeSortInPlace(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    public static int[] mergeSort(int[] arr){
        if(arr.length == 1)
            return arr;
        int mid = arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(left, right);
    }

    public static void mergeSortInPlace(int[] arr, int s, int e){
        if(e - s == 0)
            return;
        int mid = s + (e - s) / 2;
        mergeSortInPlace(arr, s, mid);
        mergeSortInPlace(arr, mid + 1, e);
        mergeInPlace(arr, s, mid, e);
    }
    //we cannot actually merge in-place but can try simulating it.
    private static void mergeInPlace(int[] arr, int s, int m, int e){
        int i = s;
        int j = m + 1;
        int k = 0;
        int[] merged = new int[e - s + 1];
        while(i <= m && j <= e){
            if(arr[i] <= arr[j]){
                merged[k++] = arr[i++];
            } else{
                merged[k++] = arr[j++];
            }
        }
        while(i <= m){
            merged[k++] = arr[i++];
        }
        while(j <= e){
            merged[k++] = arr[j++];
        }
        for(int l = 0; l < merged.length; l++){
            arr[s + l] = merged[l];
        }
    }

    //merging can not be done without extra space - no inplace merging.
    //remember, we can go for space optimization like in-place
    //as long as, the checkables or the input is not affected by the manipulations
    private static int[] merge(int[] left, int[] right){
        int i = 0;
        int j = 0;
        int k = 0;
        int merged[] = new int[left.length + right.length];
        while(i < left.length && j < right.length){
            if(left[i] <= right[j]){
                //consume left unpicked
                merged[k] = left[i];
                i++;
            }
            else{
                merged[k] = right[j];
                j++;
            }
            k++;
        }
        while(i < left.length){
            merged[k] = left[i];
            i++;
        }
        while(j < right.length){
            merged[k] = right[j];
            j++;
        }
        return merged;
    }
}
