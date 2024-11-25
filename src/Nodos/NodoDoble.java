package Nodos;

import Interfaces.INodo;

public class NodoDoble<T> implements INodo<T> {
    private T key;
    private NodoDoble<T> next;
    private NodoDoble<T> prev;

    public NodoDoble(T val) {
        this.key = val;
        this.next = null;
        this.prev = null;
    }

    @Override
    public void setKey(T val) {
        this.key = val;
    }

    @Override
    public void setNext(INodo<T> next) {
        this.next = (NodoDoble<T>) next;
    }

    public void setPrev(NodoDoble<T> prev) {
        this.prev = prev;
    }

    @Override
    public T getKey() {
        return this.key;
    }

    @Override
    public NodoDoble<T> getNext() {
        return this.next;
    }

    public NodoDoble<T> getPrev() {
        return this.prev;
    }
}