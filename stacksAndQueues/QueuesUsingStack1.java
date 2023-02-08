package com.stacksAndQueues;

import java.util.Stack;

public class QueuesUsingStack1 {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public QueuesUsingStack1() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        int top = stack2.pop();
        while(!stack2.empty()){
            stack1.push(stack2.pop());
        }
        return top;
    }

    public int peek(){
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        int top = stack2.peek();
        while(!stack2.empty()){
            stack1.push(stack2.pop());
        }
        return top;
    }

    public boolean empty(){
        return stack1.empty();
    }
}

