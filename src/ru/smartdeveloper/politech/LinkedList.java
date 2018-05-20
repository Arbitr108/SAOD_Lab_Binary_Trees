package ru.smartdeveloper.politech;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 1. Empty
 * 2. Single
 * 3. Beginning
 * 4. End
 * 5. Middle
 */
public class LinkedList<E> implements Iterable<E>{
    private Node<E> head;
    private Node<E> tail;
    private int currentSize;

    public LinkedList(){
        tail = head = null;
        currentSize = 0;
    }

    public int size(){
        return currentSize;
    }

    public void addFirst(E data){
        Node<E> node = new Node<>(data);
        if(head == null){
            tail = node;
        }
        node.next = head;
        head = node;
        ++currentSize;
    }

    public void addLast(E data){
        Node<E> node = new Node<>(data);
        Node<E> tmp = head;
        if(head == null){
            head = tail = node;
            ++currentSize;
            return;
        }
        tail.next = node;
        tail = node;
        ++currentSize;
    }

    public E removeFirst(){
        if(head == null){
            return null;
        }
        E tmp = head.data;
        if(head == tail){
            head = tail = null;
        }else{
            head = head.next;
        }
        --currentSize;
        return tmp;
    }

    public E removeLast(){
        if(head == null){
            return null;
        }
        if(head == tail){
            return removeFirst();
        }
        Node<E> previous = null;
        Node<E> current = head;
        while(current != tail){
            previous = current;
            current = current.next;
        }
        previous.next = null;
        tail = previous;
        --currentSize;
        return current.data;
    }

    public E remove(E data){
        Node<E> previous = null;
        Node<E> current = head;
        while(current != null){
            if((((Comparable<E>)data).compareTo(current.data) == 0)){
                if(current == head)
                    return removeFirst();
                if(current == tail)
                    return removeLast();
                --currentSize;
                previous.next = current.next;
                current.next = null;
                return current.data;
            }
            previous = current;
            current = current.next;
        }
        return null;
    }

    public boolean contains(E data){
        Node<E> current = head;
        while(current != null){
            if((((Comparable<E>)data).compareTo(current.data) == 0)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public E peekFirst(){
        return head == null ? null : head.data;
    }

    public E peekLast(){
        return head == null ? null : tail.data;
    }


    @Override
    public Iterator<E> iterator() {
        return new IteratorHelper();
    }

    class IteratorHelper implements Iterator<E> {
        Node<E> index;
        public IteratorHelper(){
            index = head;
        }

        @Override
        public boolean hasNext() {
            return index != null;
        }

        @Override
        public E next() {
            if(!hasNext())
                throw new NoSuchElementException();
            E value = index.data;
            index = index.next;
            return value;
        }
    }



    class Node <E>{
        Node<E> next;
        E data;
        public Node(E data){
            this.data = data;
            next = null;
        }
    }
}
