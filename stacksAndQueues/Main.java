package com.stacksAndQueues;

public class Main {
    public static void main(String[] args) {
        QueuesUsingStack1 queue = new QueuesUsingStack1();
        queue.push(2);
        queue.push(4);
        queue.push(6);
        queue.push(10);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }

}
