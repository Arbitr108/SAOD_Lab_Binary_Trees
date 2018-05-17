package ru.smartdeveloper.politech;

import java.util.ArrayList;

abstract class HydratableTree<T> {

    public abstract void add(T data);

    void hydrate(ArrayList<T> elements) {
        for (T element : elements) {
            add(element);
        }
    }
}
