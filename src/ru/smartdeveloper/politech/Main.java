package ru.smartdeveloper.politech;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static final int SIZE_LIMIT = 10;
    public static final int VALUE_LIMIT = 10;
    public static final int SEARCH_VALUE = 3;
    public static final float VALUE_FOR_LIST = 18.5f;

    public static void main(String[] args) {

        System.out.println("Лабораторные по САОД");
        System.out.println("Выполнил Горбатюк П.О. (гр. З17-ИВТмг2)");
        System.out.println("II Семестр. 2018 год");

        System.out.println();
        Random rand = new Random();
        System.out.println("Генерация данных для заполнения....");
        ArrayList<Integer> integers = new ArrayList<>();
        for(int i = SIZE_LIMIT; i > 0; --i){
            integers.add(rand.nextInt(VALUE_LIMIT) + 1);
        }
        System.out.println();
        System.out.println("Лабораторная 'Trees': Бинарные деревья");
	    BinaryTree<Integer> binTree = new BinaryTree<>();
        System.out.println("\tзаполнение бинарного дерева....");
        long startTime = System.nanoTime();
        binTree.hydrate(integers);
        long binaryHydrateEstimatedTime = System.nanoTime() - startTime;
        System.out.println("Элементы добавлены");
        binTree.inOrderTraversal();
        System.out.println("Время затрачено " + binaryHydrateEstimatedTime  +
                " наносекунд");
        System.out.println();
        System.out.println("Поиск в простом несбалансированном " +
                "бинарном дереве числа " + SEARCH_VALUE);
        startTime = System.nanoTime();
        Integer result = binTree.find(SEARCH_VALUE);
        long bynarySearchEstimatedTime = System.nanoTime() - startTime;
        System.out.println("Результат поиска " + (result != null ? result : false));
        System.out.println("Время затрачено " + bynarySearchEstimatedTime  +
                " наносекунд");
        System.out.println();
        System.out.println("Лабораторная 'Trees': AVL деревья");
        AVLTree<Integer> avlTree = new AVLTree<>();
        System.out.println("\tзаполнение AVL дерева....");
        startTime = System.nanoTime();
        avlTree.hydrate(integers);
        long avlHydrateEstimatedTime = System.nanoTime() - startTime;
        System.out.println("Элементы добавлены");
        avlTree.inOrderTraversal();
        System.out.println("Время затрачено " + avlHydrateEstimatedTime);
        System.out.println("Разница при заполнение AVl - Binary = " +
                "" + (avlHydrateEstimatedTime - binaryHydrateEstimatedTime) +
                " наносекунд"
        );
        System.out.println();

        System.out.println("Поиск в AVL дереве числа " + SEARCH_VALUE);
        startTime = System.nanoTime();
        result = avlTree.find(SEARCH_VALUE);
        long avlSearchEstimatedTime = System.nanoTime() - startTime;
        System.out.println("Результат поиска " + (result != null ? result : false));
        System.out.println("Время затрачено " + avlSearchEstimatedTime);
        System.out.println("Разница в поиске  AVL - Binary = " + (avlSearchEstimatedTime - bynarySearchEstimatedTime) +
                " наносекунд");

        System.out.println();
        System.out.println("Лабораторная 'Lists'");
        LinkedList<Float> floats = new LinkedList<>();
        floats.addFirst(VALUE_FOR_LIST);
        floats.addLast(VALUE_FOR_LIST);
        float sum = 0;
        for( Float f : floats){
            sum += f;
        }
        System.out.println("Элементов добавлено " + floats.size());
        System.out.println("Среднее арифметическое = " + sum / floats.size());
    }
}
