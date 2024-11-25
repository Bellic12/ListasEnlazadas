package Interfaces;

public interface IListasEnlazadas<T> {
    void pushFront(T valor); // Inserción de un elemento al inicio de la lista
    void pushBack(T valor);  // Inserción de un elemento al final de la lista
    void popFront();            // Eliminación del primer elemento de la lista
    void popBack();             // Eliminación del último elemento de la lista
    INodo<T> find(T valor);         // Retornando la referencia del elemento en la lista
    void erase(T valor);     // Eliminación del elemento indicado de la lista
    void addBefore(INodo<T> nodo, T valor); // Inserción de un elemento antes del nodo indicado
    void addAfter(INodo<T> nodo, T valor);  // Inserción de un elemento después del nodo indicado
    boolean empty();         // Verificar si la lista está vacía
    T topFront();            // Obtener el primer elemento de la lista
    T topBack();             // Obtener el último elemento de la lista
}