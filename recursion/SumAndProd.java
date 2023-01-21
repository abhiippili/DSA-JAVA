package com.recursion;

public class SumAndProd {
    public static void main(String[] args) {
        recursive();
        iterative();
    }

    public static void recursive(){
        System.out.println(fact(6));
        System.out.println(sum(2));
    }
    public static void iterative(){
        System.out.println(itFact(3));
        System.out.println(itSum(10));
    }
    public static int fact(int n){
        if(n <= 1)
            return 1;
        return n * fact(n - 1);
    }

    public static int sum(int n){
        if(n == 1)
            return 1;
        return n + sum(n - 1);
    }

    public static int itFact(int n){
        int prod = 1;
        while(n > 1){
            prod = prod * n;
            n--;
        }
        return prod;
    }

    public static int itSum(int n){
        int sum = 0;
        while(n > 0){
            sum = sum + n;
            n--;
        }
        return sum;
    }
}
