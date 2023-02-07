package com.hashing;

import java.util.*;

public class Hashing {
    public static void main(String[] args) {
//        //creation
//        HashSet<Integer> set = new HashSet<>();
//        //insertion, search, deletion - O(1)
//        set.add(1);
//        set.add(1);
//        set.add(2 );
//        set.add(3);
//        set.add(3);
//        set.add(4);
//        System.out.println(set);
//        if(set.contains(2)){
//            System.out.println("2 is present");
//        }
//        set.remove(1);
//        System.out.println(set);
//        //iteration
//        Iterator it = set.iterator();
//        System.out.println(it.next());
//        System.out.println(it.next());
//        System.out.println(it.hasNext());
//        System.out.println(it.next());
//        System.out.println(it.hasNext());

        //creation
        HashMap<String, Integer> map = new HashMap<>();
        //insertion
        map.put("abhi",21);
        map.put("nikhil",24);
        map.put("sourab",23);
        map.put("kunal",25);

        System.out.println(map);

        //search/retrival
        System.out.println(map.containsKey("sourab"));
        System.out.println(map.containsValue(24));
        System.out.println(map.get("nikhil"));

        //iterations
//            int[] arr = {1,1,2,3,7};
//            for(int val : arr){
//                System.out.println(val + "");
//            }
        for(Map.Entry<String, Integer> el : map.entrySet()){
            System.out.println(el.getKey() + " : " + el.getValue());
        }


//        Set<String> keys = map.keySet();
//        for(String key : keys){
//            System.out.println(map.get(key));
//        }

    }
}
