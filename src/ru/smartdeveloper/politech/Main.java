package ru.smartdeveloper.politech;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        System.out.println("Лабораторная 'Trees': Бинарные деревья");
	    BinaryTree<Integer> binTree = new BinaryTree<>();
        Random rand = new Random();
        System.out.println("\tгенерация данных для заполнения....");
        ArrayList<Integer> integers = new ArrayList<>();
	    for(int i = 500; i > 0; --i){
	        integers.add(rand.nextInt( 10000 ) + 1);
        }
        System.out.println("\tзаполнение бинарного дерева....");
        binTree.hydrate(integers);
        System.out.println("Элементов добавлено " + binTree.size());
//        System.out.println(
//                "==================== Binary Tree ===================="
//        );
//        System.out.println("In Order Traversal");
//        binTree.inOrderTraversal();
//
//        System.out.println("Pre Order Traversal");
//        binTree.preOrderTraversal();
//
//        System.out.println("Post Order Traversal");
//        binTree.postOrderTraversal();
//        binTree.displayTree();
//        System.out.println();
//        System.out.println(
//                "===================== AVL tree ======================"
//        );
//
        System.out.println("Лабораторная 'Trees': AVL деревья");
        AVLTree<Integer> avlTree = new AVLTree<>();
        System.out.println("\tзаполнение AVL дерева....");
        avlTree.hydrate(integers);
        System.out.println("Элементов добавлено " + avlTree.size());
//
//        System.out.println("In Order Traversal");
//        avlTree.inOrderTraversal();
//
//        System.out.println("Pre Order Traversal");
//        avlTree.preOrderTraversal();
//
//        System.out.println("Post Order Traversal");
//        avlTree.postOrderTraversal();
//
//        avlTree.displayTree();
        System.out.println("Лабораторная 'Lists'");
        LinkedList<Float> floats = new LinkedList<>();
        floats.addFirst(18.5f);
        floats.addLast(18.5f);
        float sum = 0;
        for( Float f : floats){
            sum += f;
        }
        System.out.println("Элементов добавлено " + floats.size());
        System.out.println("Среднее арифметическое = " + sum / floats.size());
    }
}
