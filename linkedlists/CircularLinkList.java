package com.linkedlists;

public class CircularLinkList {

    private Node head;
    private Node tail;

    public void insertFirst(int val){
        Node node = new Node(val);
        if(tail == null){
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        node.next = head;
        tail = node;
    }

    public void delete(int key){
        if(head.value == key){
            head = head.next;
            tail.next = head;
            return;
        }
        Node temp = head;
        while(temp.next != tail){
            if(temp.next.value == key)
                break;
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }

    public void display(){
        Node temp = head;
        if(head != null){
            do{
                System.out.print(temp.value + " -> ");
                temp = temp.next;
            }while(temp != head);
            System.out.println("END");
        }
    }

    private class Node{
        int value;
        Node next;

        public Node(int value){
            this.value = value;
        }
        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }
}
