package com.recursion_arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSet {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] arr = {1,2,2};
//        subSet(list, arr, 0);
//        subSetList(list, arr, 0);
//        System.out.println(finalList);
//        int[] nums = {1,2,2,2,2,3};
        subSetDuplicates(list, arr, 0);
//        System.out.println(finalList);
        System.out.println(subSetIterativeDup(arr));
    }
    public static void subSet(ArrayList<Integer> list, int[] arr, int i){
        if(i == arr.length) {
            System.out.println(list);
            return;
        }
        //picked list is created by picking up the first element
        ArrayList<Integer> pickedList = (ArrayList<Integer>) list.clone();
        pickedList.add(arr[i]);
        subSet(pickedList, arr, i + 1);
        subSet((ArrayList<Integer>) list.clone(), arr, i + 1);
    }


    static List<List<Integer>> finalList = new ArrayList<>();
    public static void subSetList(ArrayList<Integer> ans, int[] arr, int i ){
        if(i == arr.length){
            finalList.add(ans);
            return;
        }
        //unpicked recursive call
        subSetList(new ArrayList<>(ans), arr, i + 1);
        //picked recursive call
        //it's okay to change the ans list so far, as long as appropriate copies
        //of it is passed as parameters to both recursive calls
        ans.add(arr[i]);
        subSetList(new ArrayList<>(ans), arr, i + 1);
    }

    //with duplicates
    public static void subSetDuplicates(ArrayList<Integer> ans, int[] arr, int i){
        while(i > 0 && i < arr.length && arr[i] == arr[i - 1]){
            i++;
        }

        //base condition
        if(i == arr.length) {
//            finalList.add(ans);
            System.out.println(ans);
            return;
        }

        ArrayList<Integer> left = new ArrayList<>(ans);
        ans.add(arr[i]);
        subSetDuplicates(left, arr, i + 1);
        ArrayList<Integer> right = new ArrayList<>(ans);
        subSetDuplicates(right, arr, i + 1);
    }

    public static List<List<Integer>> subSetIterative(int[] arr){
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> empty = new ArrayList<>();
        ans.add(empty);
        for(int i = 0; i < arr.length; i++){
            int ansSize = ans.size();
            for(int j = 0; j < ansSize; j++){
                ArrayList<Integer> dup = new ArrayList<>(ans.get(j));
                dup.add(arr[i]);
                ans.add(dup);
            }
        }
        return ans;
    }


    public static List<List<Integer>> subSetIterativeDup(int[] arr){
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> empty = new ArrayList<>();
        ans.add(empty);
        for(int i = 0; i < arr.length; i++){
            int ansSize = ans.size();
            int j = 0;
            if(i > 0 && arr[i] == arr[i - 1]){
                //do the cloning only for the second half
                j = ansSize / 2;
            }
            for(; j < ansSize; j++){
                ArrayList<Integer> dup = new ArrayList<>(ans.get(j));
                dup.add(arr[i]);
                ans.add(dup);
            }
        }
        return ans;
    }
}
