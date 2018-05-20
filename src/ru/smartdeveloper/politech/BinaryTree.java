package ru.smartdeveloper.politech;

import java.util.Stack;

public class BinaryTree<T extends Comparable<T>> extends AbstractTree<T>{

    public T find(T data) {
        Node<T> current = root;
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
        Node<T> newNode = new Node(data);
        if(root == null){
            root = newNode;
            ++current_size;
        }else{
            Node<T> current = root;
            Node<T> parent;
            while (true){
                parent = current;
                if(data.compareTo(current.data) < 0){
                    current = current.left;
                    if(current == null){
                        parent.left = newNode;
                        ++current_size;
                        return;
                    }
                }else if(data.compareTo(current.data) > 0){
                    current = current.right;
                    if(current == null){
                        parent.right = newNode;
                        ++current_size;
                        return;
                    }
                }else if(data.compareTo(current.data) == 0){
                    return;
                }
            }
        }
    }

    public void delete(int id){};



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
}
