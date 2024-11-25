package Listas;
import Interfaces.*;
import Nodos.Nodo;

public class SencillaSinCola<T> implements IListasEnlazadas<T> {
    private Nodo<T> head;

    public SencillaSinCola() {
        this.head = null;
    }

    @Override
    public void pushFront(T valor) {
        Nodo<T> nuevoNodo = new Nodo<T>(valor);
        nuevoNodo.setNext(head);
        head = nuevoNodo;
    }

    @Override
    public void pushBack(T valor) {
        Nodo<T> nuevoNodo = new Nodo<T>(valor);
        if (head == null) {
            head = nuevoNodo;
        } else {
            Nodo<T> actual = head;
            while (actual.getNext() != null) {
                actual = actual.getNext();
            }
            actual.setNext(nuevoNodo);
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
        }
        if (head.getNext() == null) {
            head = null;
            return;
        }
        Nodo<T> actual = head;
        while (actual.getNext().getNext() != null) {
            actual = actual.getNext();
        }
        actual.setNext(null);
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
        Nodo<T> temp = head;
        if (head == null) {
            System.out.println("Error: Lista vacía. No se puede insertar el elemento.");
            return;
        }
        while (temp.getNext() != null) {
            if (temp.getNext().equals(nodo)) {
                nuevoNodo.setNext(temp.getNext());
                temp.setNext(nuevoNodo);
                return;
            }
            temp = temp.getNext();
        }
    }

    @Override
    public void addAfter(INodo<T> nodo, T valor) {
        if (head == null) {
            System.out.println("Error: Lista vacía. No se puede insertar el elemento.");
            return;
        }
        Nodo<T> nuevoNodo = new Nodo<T>(valor);
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
        if (head == null) {
            System.out.println("Error: Lista vacía. No se puede obtener el elemento.");
            return null;
        }
        Nodo<T> actual = head;
        while (actual.getNext() != null) {
            actual = actual.getNext();
        }
        return actual.getKey();
    }

    public void printList() {
        Nodo<T> actual = head;
        while (actual != null) {
            System.out.print(actual.getKey() + " ");
            actual = actual.getNext();
        }
        System.out.println();
    }
}
