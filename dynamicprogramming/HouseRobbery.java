package com.dynamicprogramming;

public class HouseRobbery {
    //max sum of subsequences formed with non adjacent elements
    //intuition - max sum of subsequences is a rec + dp problem
    //the only diff here is non adjacent elements
    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 9};
        System.out.println((solve(arr)));
    }
    private static int solve(int[] arr){
        // 2 1 4 9
        // 0 1 2 3 indeces
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        for(int i = 1; i < arr.length; i++){
            //max of pick and not pick
            if(i == 1){
                dp[i] = Math.max(arr[i], dp[i - 1]);
            }
            else {
                dp[i] = Math.max(arr[i] + dp[i - 2], dp[i - 1]);
            }
        }
        return dp[arr.length - 1];
    }
    //checkout problem on codingninjas for space optimized version
    // O(n) time and O(n) space
}
