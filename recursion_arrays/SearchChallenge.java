package com.recursion_arrays;


import java.util.ArrayList;

/*self challenging question:
    you are given an arr, target and are required to find all occurences.
    like a default fun - search_rec(arr, target).
    expects an answer like [7,8,13,14] - it has to be the actual returned list
    no further manipulations on the returned list whatsoever.
    and helper function should not use parameter list.
 */
public class SearchChallenge {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 23, 23, 23, 23, 0, 0, 39};
        System.out.println(search_rec(arr, 1));
    }
    public static ArrayList<Integer> search_rec(int[] arr, int target){
        return helper(arr, target, arr.length - 1);
    }
    public static ArrayList<Integer> helper(int[] arr, int target, int i){
        if(i == -1){
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> ans = helper(arr, target, i - 1);
        if(arr[i] == target)
            ans.add(i);
        return ans;
    }
}
