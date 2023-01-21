package com.recursion;

public class Reverse {
    public static void main(String[] args) {
        int digits = (int)(Math.log10(8962));
        System.out.println(rev(8962,digits));
        System.out.println(revNew(89782));
        System.out.println(isPal(15651));
    }
    public static int rev(int n, int base){
        if(n % 10 == n)
            return n;
        int rem = n % 10;
        return rem * ((int)Math.pow(10,base)) + rev(n / 10, base - 1);
    }
    public static int revNew(int n){
        if(n % 10 == n)
            return n;
        int rem = n % 10;
        int base = (int)(Math.log10(n));
        return rem * (int)(Math.pow(10,base)) + revNew(n / 10);
    }

    public static boolean isPal(int n){
        return n == revNew(n);
    }
}
