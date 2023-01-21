package com.recursion;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fib(7));
        System.out.println(itFib(7));
    }

    // 0  1  1  2  3  5  8  13
    public static int fib(int n){
        if(n <= 1){
            return n;
        }
        return fib(n - 2) + fib(n - 1);
    }

    public static int itFib(int n){
        int x = 0;
        int y = 1;
        for(int i = 0; i < n - 1; i++){
            int z = x + y;
            x = y;
            y = z;
        }
        return y;
    }
}
