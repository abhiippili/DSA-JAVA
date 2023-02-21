package com.recursion_strings;

public class SkipCharacter {
    public static void main(String[] args) {
        String s = "baacad";
        System.out.println(skip("", s));
        System.out.println(skipString("", "ajghabhiihabhugabuabhirtyahia", "abhi"));
    }
    public static String skip(String p, String up){
        if(up.isEmpty()){
            return p;
        }
        char ch = up.charAt(0);
        if(ch == 'a'){
            return skip(p, up.substring(1));
        } else {
            return skip(p + ch, up.substring(1));
        }
    }

    public static String skipString(String p, String up, String s){
        if(up.isEmpty()){
            return p;
        }
        if(up.startsWith(s)){
            return skipString(p, up.substring(s.length()), s);
        } else {
            return skipString(p + up.charAt(0), up.substring(1), s);
        }
    }
}
