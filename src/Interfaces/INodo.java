package Interfaces;

public interface INodo<T> {
    void setKey(T val);
    void setNext(INodo<T> next);
    T getKey();
    INodo<T> getNext();
}