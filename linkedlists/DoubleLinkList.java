package com.linkedlists;

public class DoubleLinkList {
    private Node head;
    public int size;

    public void insertFirst(int val){
        Node node = new Node(val,head,null);
        if(head != null){
            head.prev = node;
        }
        head = node;
        size++;
    }

    public void insertLast(int val){
        if(head == null){
            insertFirst(val);
        }
        Node last = head;
        while(last.next != null){
            last = last.next;
        }
        Node node = new Node(val,null,last);
        last.next = node;
        size++;
    }

    public void insertAfter(int value, int key){
        Node temp = head;
        while(temp != null){
            if(temp.value == key)
                break;
            temp = temp.next;
        }
        Node node = new Node(value,temp.next,temp);
        temp.next = node;
        if(node.next != null){
            node.next.prev = node;
        }
        size++;
    }


    public void display(){
        //approach to find last without using tail
        Node temp = head;
        Node last = null;
        System.out.println("Ordered print");
        while(temp != null){
            last = temp;
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
        System.out.println("Reverse print");
        while(last != null){
            System.out.print(last.value + " -> ");
            last = last.prev;
        }
        System.out.println("START");

    }


    private class Node{
        int value;
        Node prev;
        Node next;

        public Node(int value){
            this.value = value;
        }
        public Node(int value, Node next, Node prev){
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}
