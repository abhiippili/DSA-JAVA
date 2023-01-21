package com.recursion;

public class NTo1 {
    public static void main(String[] args) {
//        recursive();
        iterative();
    }
    public static void recursive(){
        System.out.println("calling phase print");
        print(5);
        System.out.println("returning phase print");
        printRev(5);
        System.out.println("printing both inc and dec");
        printBoth(5);
    }

    public static void iterative(){
        System.out.println("decreasing print");
        itPrint(5);
        System.out.println("increasing print");
        itPrintRev(5);
        System.out.println("printing both inc and dec");
        itPrintBoth(5);
    }

    //calling phase or increasing fun
    public static void print(int n){
        if(n == 1){
            System.out.println(n);
            return;
        }
        System.out.println(n);
        print(n - 1);
    }

    //returning phase or decreasing phase fun
    public static void printRev(int n){
        if(n == 1){
            System.out.println(n);
            return;
        }
        printRev(n - 1);
        System.out.println(n);
    }

    //call+return phase
    public static void printBoth(int n){
        if(n == 1){
            System.out.println(n);
            return;
        }
        System.out.println(n);
        printBoth(n - 1);
        System.out.println(n);
    }



    //Iterative Approaches
    public static void itPrint(int n){
        while(n > 0){
            System.out.println(n);
            n--;
        }
    }

    public static void itPrintRev(int n){
        int i = 1;
        while(i <= n){
            System.out.println(i);
            i++;
        }
    }

    public static void itPrintBoth(int n){
        int originalN = n;
        while(n > 0){
            System.out.println(n);
            n--;
        }
        n = 1;
        while(n <= originalN){
            System.out.println(n);
            n++;
        }

    }

}
