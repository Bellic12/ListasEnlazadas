package Listas;
import Interfaces.*;
import Nodos.Nodo;

public class SencillaConCola<T> implements IListasEnlazadas<T> {
    private Nodo<T> head;
    private Nodo<T> tail;

    public SencillaConCola() {
        this.head = null;
        this.tail = null;
    }

    @Override
    public void pushFront(T valor) {
        Nodo<T> nuevoNodo = new Nodo<T>(valor);
        if (head == null) {
            head = nuevoNodo;
            tail = nuevoNodo;
        } else {
            nuevoNodo.setNext(head);
            head = nuevoNodo;
        }
    }

    @Override
    public void pushBack(T valor) {
        Nodo<T> nuevoNodo = new Nodo<T>(valor);
        if (head == null) {
            head = nuevoNodo;
            tail = nuevoNodo;
        } else {
            tail.setNext(nuevoNodo);
            tail = nuevoNodo;
        }
    }

    @Override
    public void popFront() {
        if (head != null) {
            head = head.getNext();
        } else {
            System.out.println("Error: Lista vacía. No se puede eliminar el elemento.");
        }
    }

    @Override
    public void popBack() {
        if (head == null) {
            System.out.println("Error: Lista vacía. No se puede eliminar el elemento.");
            return;
        } else if (head == tail) {
            head = tail = null;
            return;
        } else {
            Nodo<T> actual = head;
            while (actual.getNext() != tail) {
                actual = actual.getNext();
            }
            tail = actual;
            tail.setNext(null);
        }
    }

    @Override
    public Nodo<T> find(T valor) {
        Nodo<T> actual = head;
        while (actual != null) {
            if (actual.getKey().equals(valor)) {
                return actual;
            }
            actual = actual.getNext();
        }
        return null;
    }

    @Override
    public void erase(T valor) {
        if (head == null) {
            System.out.println("Error: Lista vacía. No se puede eliminar el elemento.");
            return;
        }
        if (head.getKey().equals(valor)) {
            head = head.getNext();
            return;
        }
        Nodo<T> actual = head;
        while (actual.getNext() != null) {
            if (actual.getNext().getKey().equals(valor)) {
                actual.setNext(actual.getNext().getNext());
                return;
            }
            actual = actual.getNext();
        }
        System.out.println("Error: Elemento no encontrado.");
    }

    @Override
    public void addBefore(INodo<T> nodo, T valor) {
        Nodo<T> nuevoNodo = new Nodo<T>(valor);
        if (head == null) {
            System.out.println("Error: Lista vacía. No se puede insertar el elemento.");
            return;
        }
        if (head.equals(nodo)) {
            nuevoNodo.setNext(head);
            head = nuevoNodo;
            return;
        }
        Nodo<T> actual = head;
        while (actual.getNext() != null) {
            if (actual.getNext().equals(nodo)) {
                nuevoNodo.setNext(actual.getNext());
                actual.setNext(nuevoNodo);
                return;
            }
            actual = actual.getNext();
        }
        System.out.println("Error: Nodo no encontrado.");
    }

    @Override
    public void addAfter(INodo<T> nodo, T valor) {
        Nodo<T> nuevoNodo = new Nodo<T>(valor);
        if (nodo == null) {
            System.out.println("Error: Nodo no puede ser nulo.");
            return;
        }
        nuevoNodo.setNext(nodo.getNext());
        nodo.setNext(nuevoNodo);
    }

    @Override
    public boolean empty() {
        return head == null;
    }

    @Override
    public T topFront() {
        if (head != null) {
            return head.getKey();
        }
        return null;
    }

    @Override
    public T topBack() {
        if (tail != null) {
            return tail.getKey();
        }
        return null;
    }
}
