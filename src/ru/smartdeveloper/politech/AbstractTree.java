package ru.smartdeveloper.politech;

import java.util.ArrayList;

abstract class AbstractTree<T extends Comparable<T>> {
    protected Node<T> root;
    protected int current_size;

    public AbstractTree(){
        root = null;
        current_size = 0;
    }

    public abstract void add(T data);

    void hydrate(ArrayList<T> elements) {
        for (T element : elements) {
            add(element);
        }
    }

    public T find(T data) {
        Node<T> current = root;
        while(current.data.compareTo(data) != 0){
            if(data.compareTo(current.data) < 0){
                current = current.left;
            } else {
                current = current.right;
            }
            if(current == null){
                return null;
            }
        }
        return current.data;
    }

    public int size(){
        return current_size;
    }
    public void inOrderTraversal(){
        inOrderTraversal(root);
    }

    public void preOrderTraversal(){
        preOrderTraversal(root);
    }

    public void postOrderTraversal(){
        postOrderTraversal(root);
    }


    protected void inOrderTraversal(Node root){
        if(root != null){
            inOrderTraversal(root.left);
            System.out.println(root.data);
            inOrderTraversal(root.right);
        }
    }
    protected void preOrderTraversal(Node root){
        if(root != null){
            System.out.println(root.data);
            inOrderTraversal(root.left);
            inOrderTraversal(root.right);
        }
    }

    protected void postOrderTraversal(Node root){
        if(root != null){
            inOrderTraversal(root.left);
            inOrderTraversal(root.right);
            System.out.println(root.data);
        }
    }

    class Node<E> {
        E data;
        Node<E> parent, left, right;
        public Node(E data){
            this.data = data;
            parent = left = right = null;
        }
    }
}
