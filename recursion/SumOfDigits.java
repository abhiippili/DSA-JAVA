package com.recursion;

public class SumOfDigits {
    public static void main(String[] args) {
        System.out.println(digitsSum(122));
        System.out.println(digitsProd(356));
    }
    public static int digitsSum(int n){
        if(n % 10 == n)
            return n;
        return (n % 10) + digitsSum(n / 10);
    }
    public static int digitsProd(int n){
        if(n % 10 == n)
            return n;
        return (n % 10) * digitsProd(n / 10);
    }
}
