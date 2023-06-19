package com.dynamicprogramming;

public class OptimizedFrogJump {
    //prob is to reduce the energy required to go to the last stair when it can make
    //one or two jumps and the energy required is abs difference of the array.
    public static void main(String[] args) {
        int heights[] = {10, 20, 30, 10};
        System.out.println(jump(heights));
    }
    private static int jump(int[] heights){
        int n = heights.length - 1;
        int[] dp = new int[n + 1];
        for(int i = 0; i < n + 1; i++){
            dp[i] = -1;
        }
        dp[0] = 0;
        for(int i = 1; i < n + 1; i++){
            int secondJump = Integer.MAX_VALUE;
            int firstJump = Math.abs(heights[i - 1] - heights[i]) + dp[i - 1];
            if(i >= 2){
                secondJump = Math.abs(heights[i - 2] - heights[i]) + dp[i - 2];
            }
            dp[i] = Math.min(firstJump, secondJump);
        }
        return dp[n];
    }
}

