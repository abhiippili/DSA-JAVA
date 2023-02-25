package com.recursion_strings;

import java.util.ArrayList;

public class SubSeq {
    public static void main(String[] args) {
    String s = "abcd";
//    subset("", s);
//    subSetList("", s);
//    System.out.println(list);
//    ArrayList<String> list = new ArrayList<>();
//    subsetList2("", s, list);
//    System.out.println(list);
//    System.out.println(subSetList3("", s));
    System.out.println(subSetList4("", s));
    }

    public static void subset(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        //recursive call
        subset(p + ch, up.substring(1));
        subset(p, up.substring(1));
    }
    //think about returning the strings.
    //simple returning of strings is not possible because whatever that is
    //returned is only returned or available to the calling function and
    //the main function cannot reach the string after the calling function's
    //stack frame is popped. The only we to retain this info and further pass
    //to the above fun calls is by storing the ans returned from both fun calls
    //and then returning the answers together and so on n so forth.

    static ArrayList<String> list = new ArrayList<>();
    public static void subSetList(String p, String up){
        if(up.isEmpty()){
            list.add(p);
            return;
        }
        char ch = up.charAt(0);
        subSetList(p + ch, up.substring(1));
        subSetList(p, up.substring(1));
    }

    public static void subsetList2(String p, String up, ArrayList<String> list){
        if(up.isEmpty()){
            list.add(p);
            return;
        }
        char ch = up.charAt(0);
        subsetList2(p + ch, up.substring(1), list);
        subsetList2(p, up.substring(1), list);
    }
    //very interesting to understand
    public static ArrayList<String> subSetList3(String p, String up){
        ArrayList<String> bodyList = new ArrayList<>();
        if(up.isEmpty()){
            bodyList.add(p);
            return bodyList;
        }
        char ch = up.charAt(0);
        ArrayList<String> ansList1 = subSetList3(p + ch, up.substring(1));
        ArrayList<String> ansList2 = subSetList3(p, up.substring(1));
        ansList1.addAll(ansList2);
        return ansList1;
    }

    public static ArrayList<String> subSetList4(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> ansList1 = subSetList3(p + ch, up.substring(1));
        ArrayList<String> ansList2 = subSetList3(p, up.substring(1));
        ansList1.addAll(ansList2);
        return ansList1;
    }
}
