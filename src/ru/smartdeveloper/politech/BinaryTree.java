package ru.smartdeveloper.politech;

import java.util.Stack;

public class BinaryTree <T extends Comparable<T>> extends HydratableTree<T>{
    private Node root;
    private int num_nodes;

    BinaryTree() {}

    public T find(T data) {
        Node current = root;
        while(current.data != data){
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

    @Override
    public void add(T data){
        Node newNode = new Node(data);
        if(root == null){
            root = newNode;
            ++num_nodes;
        }else{
            Node current = root;
            Node parent;
            while (true){
                parent = current;
                if(data.compareTo(current.data) < 0){
                    current = current.left;
                    if(current == null){
                        parent.left = newNode;
                        ++num_nodes;
                        return;
                    }
                }else if(data.compareTo(current.data) > 0){
                    current = current.right;
                    if(current == null){
                        parent.right = newNode;
                        ++num_nodes;
                        return;
                    }
                }else if(data == current.data){
                    return;
                }
            }
        }
    }

    public void delete(int id){};
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

    public void displayTree(){
        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        while(isRowEmpty == false){
            Stack localStack = new Stack();
            isRowEmpty = true;
            for(int j = 0; j < nBlanks; j++)
                System.out.print(' ');
            while(globalStack.isEmpty() == false){
                Node temp = (Node)globalStack.pop();
                if(temp != null){
                    System.out.print(temp.data);
                    localStack.push(temp.left);
                    localStack.push(temp.right);
                    if(temp.left != null || temp.right != null)
                        isRowEmpty = false;
                }else{
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for(int j = 0; j < nBlanks * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            nBlanks /= 2;
            while (localStack.isEmpty() == false)
                globalStack.push(localStack.pop());
        }
    }

    class Node {
        T data;
        Node left, right;
        Node(T data){
            this.data = data;
            left = right = null;
        }
    }
}
