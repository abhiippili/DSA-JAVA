package com.recursion_arrays;

import java.util.ArrayList;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 23, 23, 23, 23, 0, 0, 39};
//        System.out.println(search(arr,39,0));
//        System.out.println(searchBoolean(arr,39,0));
//        findAllIndex(arr, 23, 0);
//        System.out.println(staticList);
//        ArrayList<Integer> list = new ArrayList<>();
//        System.out.println(findAllIndex2(arr, 23, 0, list));
        System.out.println(findAllIndex3(arr,23,0));
        System.out.println(findAllIndex4(arr,23,0));
    }
    public static int search(int[] arr, int target, int index){
        if(index == arr.length)
            return -1;
        if(arr[index] == target)
           return index;
       return search(arr, target,index + 1);
    }

    public static boolean searchBoolean(int[] arr, int target, int index){
        if(index == arr.length)
            return false;
        return (arr[index] == target) || searchBoolean(arr, target, index + 1);
    }

    //find all occurrences of target
    //static approach
    static ArrayList<Integer> staticList = new ArrayList<>();
    public static void findAllIndex(int[] arr, int target, int i){
        if(i == arr.length)
            return;
        if(arr[i] == target){
            staticList.add(i);
        }
        findAllIndex(arr, target, i + 1);
    }

    //parameter approach
    public static ArrayList<Integer> findAllIndex2(int[] arr, int target, int i, ArrayList<Integer> list){
        if(i == arr.length)
            return list;
        if(arr[i] == target){
            list.add(i);
        }
        return findAllIndex2(arr, target, i + 1, list);
    }


    //body list approach - vvip(un optimized way of doing) -- very common
    public static ArrayList<Integer> findAllIndex3(int[] arr, int target, int index){
        ArrayList<Integer> list = new ArrayList<>();
        if(index == arr.length)
            return list;
        if(arr[index] == target){
            list.add(index);
        }
        ArrayList<Integer> ans = findAllIndex3(arr, target, index + 1);
        ans.addAll(list);
        return ans;
        //instead of appending list values to ans, appending ans values to list
        //and returning list would give the answer in ascending order.
    }


    //optimised way - no static list, no list reference in parameters,
    //no body new list obj creations in every function - only one list object
    public static ArrayList<Integer> findAllIndex4(int[] arr, int target, int index){
        if(index == arr.length){
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> ans = findAllIndex4(arr, target, index + 1);
        if(arr[index] == target){
            ans.add(index);
        }
        return ans;
    }
}
