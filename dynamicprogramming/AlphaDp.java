package com.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AlphaDp {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] dp = new int[n + 1];
//        for(int i = 0; i <= n; i++){
//            dp[i] = -1;
//        }
//        System.out.println(noOfWays(n, dp));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //we could string tokenize both the lines
        String[] tokens = br.readLine().split(" ");
        int nCoins = Integer.parseInt(tokens[0]);
        int n = Integer.parseInt(tokens[1]);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] coins = new int[nCoins];
        for (int i = 0; i < nCoins; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }
        System.out.println(minCoins(n, coins, dp));
    }
    //q1 given a dice and a sum to construct find the no of ways to construct sum
    //if you can throw it more than once
    //https://cses.fi/problemset/task/1633
    public static int noOfWays(int n, int[] dp){
        if(n == 0){
            return 1;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        dp[n] = 0;
        for(int i = 1; i <= 6; i++){
            //for state - f(8) = f(7)+f(6)+f(5)+f(4)+f(3)+f(2)
            if((n - i) >= 0){
                dp[n] += noOfWays(n - i, dp);
            }
        }
        return dp[n];
    }

    //q2 - given a ncoins each having a value, return min no of coins required to make
    // the given sum
    //https://cses.fi/problemset/task/1634
    public static int minCoins(int n, int[] coins, int[] dp){
        //base condition
        for(int i = 0; i < coins.length; i++){
            if(n == coins[i]) {
                return 1;
            }
        }
        if(dp[n] != -1){
            return dp[n];
        }
        dp[n] = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++){
            if(n - coins[i] >= 0){
                dp[n] = Math.min(dp[n], minCoins(n - coins[i], coins, dp) + 1);
            }
        }
        return dp[n];
    }


    //colored bricks - codeforces 1081
    public static int bricks(int level, int bp, int n, int m, int k, int[][] dp){
        //base case
        if(level == n){
            if(bp == k){
                return 1;
            }
            return 0;
        }
        if(dp[level][bp] != -1){
            return dp[level][bp];
        }
        //transitions
        int ans = 0;
        ans += bricks(level + 1, bp, n, m, k, dp);
        if((bp + 1) <= k){
            ans += (m -1) * bricks(level + 1, bp + 1, n, m, k, dp);
        }
        dp[level][bp] = ans;
        return ans;
    }
}
