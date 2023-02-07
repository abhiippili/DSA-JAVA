package com.linkedlists;

import java.util.ArrayList;

public class LinkList {
    private Node head;
    private Node tail;
    public int size;

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        if (tail == null)
            tail = head;
        size++;
    }

    public void insertLast(int val) {
        if (tail == null) {
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insert(int val, int index) {
        if (index > size) {
            System.out.println("index error");
            return;
        }
        if (index == 0) {
            insertFirst(val);
            return;
        }
        if (index == size) {
            insertLast(val);
            return;
        }

        Node temp = head;
        for (int i = 1; i < index; i++) { // n-1 iterations
            temp = temp.next;
        }
//        Node temp = get(index - 1);
        Node node = new Node(val, temp.next);
        temp.next = node;
        size++;
    }


    //q1.
    public void insertRec(int value, int index) {
        head = insertRec(value, index, head);
        //if the new node is added at beginning the head is required to store ref returned.
    }

    public void insertRecVoid(int value, int index){
        if(index == 0){
            insertFirst(value);
            return;
        }
        insertRecVoid(value, index, head);
    }


    //returning itself
    private Node insertRec(int value, int index, Node node) {
        if(index == 0){
            Node newNode = new Node(value, node);
            return newNode;
        }
        node.next = insertRec(value, index - 1, node.next);
        return node;
    }

    private void insertRecVoid(int value, int index, Node node){
        //assume that index given is greater than 0
        if(index == 1){
            Node newNode = new Node(value, node.next);
            node.next = newNode;
            return;
        }
        insertRecVoid(value, index - 1, node.next);
    }

    public Node get(int index){
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public Node find(int value){
        Node temp = head;
        while(temp != null){
            if(temp.value == value)
                return temp;
            temp = temp.next;
        }
        return null;
    }


    public int deleteFirst(){
        if(size == 0)
            System.out.println("empty list error");
        int val = head.value;
        head = head.next;
        if(head == null)
            tail = null;
        size--;
        return val;
    }

    public int deleteLast(){
        if(size <= 1){
            return deleteFirst();
        }
        int val = tail.value;
        Node temp = get(size - 2);
        tail = temp;
        tail.next = null;
        size--;
        return val;
    }

    public int delete(int index){
        if(index >= size){
            System.out.println("index error");
            return -1;
        }
        if(index == 0){
            return deleteFirst();
        }
        if(index == size - 1){
            return deleteLast();
        }
        Node temp = get(index - 1);
        int val = temp.next.value;
        temp.next = temp.next.next;
        size--;
        return val;
    }

    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    //q2.
    public void duplicates(){
        Node temp = head;
        while(temp.next != null){
            if(temp.value == temp.next.value){
                temp.next = temp.next.next;
                size--;
            }
            else{
                temp = temp.next;
            }
        }
        tail = temp;
        tail.next = null; //optional
    }

    //q3.
    //merge two sorted lists
    public static LinkList mergeLists(LinkList list1, LinkList list2){
        LinkList ans = new LinkList();
        while(list1.head != null && list2.head != null){
            if(list1.head.value <= list2.head.value){
                ans.insertLast(list1.head.value);
                list1.head = list1.head.next;
            }
            else{
                ans.insertLast(list2.head.value);
                list2.head = list2.head.next;
            }
        }
        while(list1.head != null){
            ans.insertLast(list1.head.value);
            list1.head = list1.head.next;
        }
        while(list2.head != null){
            ans.insertLast(list2.head.value);
            list2.head = list2.head.next;
        }
        return ans;
    }


    //q4.
    //cycle detection
    public boolean hasCycle(LinkList list){
        Node slow = head;
        Node fast = head;
    while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }
        return false;
    }

    //q4.approach 1-remove elements --- naive (good on leetcode).
    public void removeElements(int val){
        Node temp = head;
        while(temp.next != null){
            if(temp.value == val){
                //this is executed only if it had no prev to handle this.
                //that means, the temp is on head.
                head = head.next;
                temp = temp.next;
            }
            if(temp.next.value == val){
                temp.next = temp.next.next;
            }
            else{
                temp = temp.next;
            }
        }
        if(temp.value == val){
            head = head.next;
            temp = temp.next; // or simply return null.
        }
    }

    //palindrome link list using stack approach

    public boolean isPalindrome(){
        ArrayList<Integer> list = new ArrayList<>();
        Node temp = head;
        int len = 0;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        System.out.println(len);
        temp = head;
        for(int i = 0; i < (len / 2); i++){
            list.add(temp.value);
            temp = temp.next;
        }
        if((len % 2) != 0){
            temp = temp.next;
        }
        while(temp != null){
            // pop the stack
            int stackTop = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            if(stackTop != temp.value)
                return false;
            temp = temp.next;
        }
        return true;
    }

    private class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }
        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }
}
