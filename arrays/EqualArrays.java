package com.dsapractice;

import java.util.*;

public class EqualArrays {
    public static void main(String[] args) {
        int A[] = {2,4,5,6,1,5};
        int B[] = {4,1,6,5,2,5};
        int N = 5;
        System.out.println(check(A,B,N));
    }
    public static boolean check(int A[], int B[], int N){
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i = 0; i < N; i++){
            if(A[i] != B[i])
                return false;
        }
        return true;
    }
}
