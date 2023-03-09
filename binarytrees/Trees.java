package com.binarytrees;

public class Trees {
    public Node root;

    public void preorder(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.value + " ");
        preorder(node.left);
        preorder(node.right);
    }


    public void inorder(Node node){
        if(node == null){
            return;
        }
        inorder(node.left);
        System.out.print(node.value + " ");
        inorder(node.right);
    }


    public void postorder(Node node){
        if(node == null){
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value + " ");
    }
}
