package ru.smartdeveloper.politech;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
	    BinaryTree<Integer> binTree = new BinaryTree<>();
        Random rand = new Random();
        ArrayList<Integer> integers = new ArrayList<>();
	    for(int i = 6; i > 0; --i){
	        integers.add(rand.nextInt( 30 ) + 1);
        }
        binTree.hydrate(integers);
        System.out.println(
                "==================== Binary Tree ===================="
        );
        System.out.println("In Order Traversal");
        binTree.inOrderTraversal();

        System.out.println("Pre Order Traversal");
        binTree.preOrderTraversal();

        System.out.println("Post Order Traversal");
        binTree.postOrderTraversal();
        binTree.displayTree();
        System.out.println();
        System.out.println(
                "===================== AVL tree ======================"
        );

        AVLTree<Integer> avlTree = new AVLTree<>();
        avlTree.hydrate(integers);

        System.out.println("In Order Traversal");
        avlTree.inOrderTraversal();

        System.out.println("Pre Order Traversal");
        avlTree.preOrderTraversal();

        System.out.println("Post Order Traversal");
        avlTree.postOrderTraversal();

        avlTree.displayTree();
    }
}
