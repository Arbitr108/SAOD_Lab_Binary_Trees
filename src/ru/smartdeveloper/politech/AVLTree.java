package ru.smartdeveloper.politech;

import java.util.Stack;

public class AVLTree<T extends Comparable<T>> extends HydratableTree<T>
{
    private Node root;
    private int current_size = 0;

    public void add(T data){
        Node<T> node = new Node<>(data);
        if(root == null){
            root = node;
            current_size++;
            return;
        }
        add(root, node);
    }

    private void add(Node<T> parent, Node<T> node){
        if(node.data.compareTo(parent.data) > 0){
            if(parent.right == null){
                parent.right = node;
                node.parent = parent;
                current_size++;
            }else{
                add(parent.right, node);
            }
        }else if(node.data.compareTo(parent.data) < 0){
            if(parent.left == null){
                parent.left = node;
                node.parent = parent;
                current_size++;
            }else{
                add(parent.left, node);
            }
        }else{
            return;
        }
        checkBalance(node);
    }

    private void checkBalance(Node<T> node){
        int difference = height(node.left) - height(node.right);
        if( difference > 1 || difference < -1){
            rebalance(node);
        }
        if(node.parent == null){
            return;
        }
        checkBalance(node.parent);
    }

    private int height(Node<T> node){
        if(node == null){
            return 0;
        }
        int leftHeight = 0, rightHeight = 0;
        leftHeight = height(node.left) + 1;
        rightHeight = height(node.right) + 1;
        return rightHeight > leftHeight ? rightHeight : leftHeight;
    }

    private void rebalance(Node<T> node){
        int difference = height(node.left) - height(node.right);
        if(difference > 1){
            if(height(node.left.left) > height(node.left.right)){
                node = rightRotate(node);
            }else{
                node = leftRightRotate(node);
            }
        }else{
            if(height(node.right.right) > height(node.right.left)){
                node = leftRotate(node);
            }else{
                node = rightLeftRotate(node);
            }
        }
        if(node.parent == null){
            root = node;
        }
    }

    private Node<T> leftRotate(Node<T> node){
        Node<T> tmp = node.right;
        node.right = tmp.left;
        tmp.left = node;
        tmp.parent = node.parent;
        node.parent = tmp;
        return tmp;
    }

    private Node<T> rightRotate(Node<T> node){
        Node<T> tmp = node.left;
        node.left = tmp.right;
        tmp.right = node;
        tmp.parent = node.parent;
        node.parent = tmp;
        return tmp;
    }
    private Node<T> rightLeftRotate(Node<T> node){
        node.right = rightRotate(node.right);
        return leftRotate(node);
    }
    private Node<T> leftRightRotate(Node<T> node){
        node.left = leftRotate(node.left);
        return rightRotate(node);
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
                AVLTree.Node temp = (AVLTree.Node)globalStack.pop();
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

    class Node<E> {
      E data;
      Node<E> parent, left, right;
      public Node(E data){
          this.data = data;
          parent = left = right = null;
      }
  }
}