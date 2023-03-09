package com.binarytrees;

public class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int val){
        this.value = val;
    }
    public Node(int val, Node left, Node right){
        this.value = val;
        this.left = left;
        this.right = right;
    }
}
