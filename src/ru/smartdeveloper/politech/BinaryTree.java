package ru.smartdeveloper.politech;

public class BinaryTree<T extends Comparable<T>> extends AbstractTree<T>{

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
}
