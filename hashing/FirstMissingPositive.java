package com.hashing;

import java.util.Arrays;

public class FirstMissingPositive {
//    https://leetcode.com/problems/first-missing-positive/description/
//    if constant extra space was not a condition - huge max not allowed.

    public static void main(String[] args) {
        int arr[] = {7,8,9,11,12};
        System.out.println(missing(arr));
    }
    public static int missing(int[] nums){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > max)
                max = nums[i];
        }
        if(max <= 0){
            return 1;
        }
        int[] hash = new int[max + 1];
        //pre storing
        for(int i = 0; i < nums.length; i++){
            if(nums[i] >= 0){
                hash[nums[i]]++;
            }
        }
        //fetching or actual ans
        for(int i = 1; i < hash.length; i++){
            if(hash[i] == 0)
                return i;
        }
        return max + 1;
    }
}
