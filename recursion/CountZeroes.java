package com.recursion;

public class CountZeroes {
    public static void main(String[] args) {
        System.out.println(count(1020005,0));
        countVoid(1020005);
        System.out.println(staticCount);
    }


    //same return value seeping through all the way to the top.
    public static int count(int n, int c){
        if(n == 0)
            return c;
        if(n % 10 == 0)
            return count(n / 10, c + 1);
        return count(n / 10, c);
    }


    //void return
    static int staticCount = 0;
    public static void countVoid(int n){
        if(n == 0)
            return;
        if(n % 10 == 0){
            staticCount += 1;
        }
        countVoid(n / 10);
    }
}
