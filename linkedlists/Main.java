package com.linkedlists;

public class Main {
    public static void main(String[] args) {
        LinkList list = new LinkList();
        list.insertFirst(2);
        list.insertFirst(4);
        list.insertFirst(6);
        list.insertFirst(8);
        list.insertLast(100);
        list.insertLast(200);
        list.display();
        System.out.println(list.size);
        list.insert(-1, 3);
        list.display();
        list.insertRecVoid(99, 0);
        list.display();





//        DoubleLinkList list1 = new DoubleLinkList();
//        list1.insertFirst(2);
//        list1.insertFirst(4);
//        list1.insertFirst(6);
//        list1.insertFirst(8);
//        list1.display();
//        list1.insertLast(100);
//        list1.insertLast(200);
//        list1.display();
//        list1.insertAfter(1000, 6);
//        list1.display();


//        CircularLinkList list2 = new CircularLinkList();
//        list2.insertFirst(2);
//        list2.insertFirst(10);
//        list2.insertFirst(20);
//        list2.insertFirst(2100);
//        list2.insertFirst(90);
//        list2.display();
//        list2.delete(90);
//        list2.display();




    }
}
