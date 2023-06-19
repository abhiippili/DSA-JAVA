package com.dynamicprogramming;

public class Dp_1D {
    public static void main(String[] args) {
        System.out.println(jumpStairs(5));
        int n = 5;
        int[] dp = new int[n + 1];
        System.out.println(jumpStairsMem(n, dp));
        System.out.println(jumpStairsTab(n, dp));
        System.out.println(jumpStairsSpaceOpt(n));
    }
    //whenever there is some sort of rec or dp involved
    //step1 : represent the problem in terms of index
    //step2 : go technically from the body or choice diagram to decide base case
    //        and then check if it also works for the min case - most of the times
    //        the min case is not even an input given. So always try to go from top down approach
    //step3 : do everything mentioned in the question - choice diagram
    //step4 : min or max or sum of choices
    //step5 : return the ans
    private static int jumpStairs(int n){
        if(n == 0){
            return 1;
            //this also matches the logical sense : 0 1 2 3 are 3 steps not 4
            //technically, returning 1 at the base case counts the possible ways
        }
        if(n == 1){
            return 1;
        }
        return jumpStairs(n - 1) + jumpStairs(n - 2);
    }
    //f(n-1) + f(n-2) is pretty much a fibonacci question
    //TC - O(2^N) - golden ratio bcoz each call makes two calls.
    //SC - O(N) - stack space

    private static int jumpStairsMem(int n, int[] dp){
        if(n <= 1){
            return 1;
        }
        if(dp[n] != 0){
            return dp[n];
        }
        dp[n] = jumpStairsMem(n - 1, dp) + jumpStairsMem(n - 2, dp);
        return dp[n];
    }
    // TC - O(N) - bcoz memoization makes sure that a call is made only once
    // SC - O(N) - stack space + O(N) - dp array

    private static int jumpStairsTab(int n, int[] dp){
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i < n + 1; i++){
            dp[n] = dp[n - 1] + dp[n - 2];
        }
        return dp[n];
    }
    //TC - O(N)
    //SC - O(N) - dp array

    //every cell in the array uses it's prev two cells so it makes sense to have only 2 var

    private static int jumpStairsSpaceOpt(int n){
        int x = 1;
        int y = 1;
        int z = 0;
        for(int i = 2; i < n + 1; i++){
            z = x + y;
            x = y;
            y = z;
        }
        return y;
        //there's pattern of returning prev one as answer but check it for once
    }
}
