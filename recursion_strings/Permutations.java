package com.recursion_strings;


import java.util.ArrayList;

public class Permutations {
    public static void main(String[] args) {
//        permutate("", "abcd");
//        System.out.println(permuteList("", "abc"));
        die("", 4);
    }
    public static void permutate(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        for(int i = 0; i <= p.length(); i++){
            String first = p.substring(0, i);
            String second = p.substring(i, p.length());
            permutate(first + ch + second, up.substring(1));
        }
    }


    public static ArrayList<String> permuteList(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }
        char ch = up.charAt(0);
        ArrayList<String> finalList = new ArrayList<>();
        for(int i = 0; i <= p.length(); i++){
            String first = p.substring(0, i);
            String second = p.substring(i, p.length());
            finalList.addAll(permuteList(first + ch + second, up.substring(1)));
        }
        return finalList;
    }

    //die forming a number problem
    public static void die(String p, int target){
        if(target == 0){
            System.out.println(p);
            return;
        }
        for(int i = 1; i <= target; i++){
            die(p + i, target - i);
        }
    }
}
