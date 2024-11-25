package Nodos;

import Interfaces.INodo;

public class Nodo<T> implements INodo<T> {
    private T key;
    private Nodo<T> next;

    public Nodo(T val) {
        this.key = val;
        this.next = null;
    }

    @Override
    public void setKey(T val) {
        this.key = val;
    }

    @Override
    public void setNext(INodo<T> next) {
        this.next = (Nodo<T>) next;
    }

    @Override
    public T getKey() {
        return this.key;
    }

    @Override
    public Nodo<T> getNext() {
        return this.next;
    }
}