package com.dynamicprogramming;

public class Dp_1D {
    public static void main(String[] args) {

    }
    //whenever there is some sort of rec or dp involved
    //step1 : represent the problem in terms of index
    //step2 : go technically from the body or choice diagram to decide base case
    //        and then check if it also works for the min case - most of the times
    //        the min case is not even an input given. So always try to go from top down approach
    //step3 : do everything mentioned in the question - choice diagram
    //step4 : min or max or sum of choices
    //step5 : return the ans
    private int jumpStairs(int n){
        if(n == 0){
            return 1;
            //this also matches the logical sense : 0 1 2 3 are 3 steps not 4
        }
        return jumpStairs(n - 1) + jumpStairs(n - 2);
    }
}
