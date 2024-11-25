package Listas;
import Interfaces.*;
import Nodos.NodoDoble;

public class DobleConCola<T> implements IListasEnlazadas<T> {
    private NodoDoble<T> head;
    private NodoDoble<T> tail;

    public DobleConCola() {
        this.head = null;
        this.tail = null;
    }

    @Override
    public void pushFront(T valor) {
        NodoDoble<T> nuevoNodo = new NodoDoble<T>(valor);
        if (head == null) {
            head = nuevoNodo;
            tail = nuevoNodo;
        } else {
            nuevoNodo.setNext(head);
            head.setPrev(nuevoNodo);
            head = nuevoNodo;
        }
    }

    @Override
    public void pushBack(T valor) {
        NodoDoble<T> nuevoNodo = new NodoDoble<T>(valor);
        if (head == null) {
            head = tail = nuevoNodo;
        } else {
            tail.setNext(nuevoNodo);
            nuevoNodo.setPrev(tail);
            tail = nuevoNodo;
        }
    }

    @Override
    public void popFront() {
        if (head != null) {
            head = head.getNext();
            if (head != null) {
                head.setPrev(null);
            }
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
            tail = tail.getPrev();
            tail.setNext(null);
        }
    }

    @Override
    public NodoDoble<T> find(T valor) {
        NodoDoble<T> actual = head;
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
            if (head != null) {
                head.setPrev(null);
            } else {
                tail = null;
            }
            return;
        }
        NodoDoble<T> actual = head;
        while (actual.getNext() != null) {
            if (actual.getNext().getKey().equals(valor)) {
                actual.setNext(actual.getNext().getNext());
                if (actual.getNext() != null) {
                    actual.getNext().setPrev(actual);
                } else {
                    tail = actual;
                }
                return;
            }
            actual = actual.getNext();
        }
        System.out.println("Error: Elemento no encontrado.");
    }

    @Override
    public void addBefore(INodo<T> nodo, T valor) {
        NodoDoble<T> nuevoNodo = new NodoDoble<T>(valor);
        if (head == null) {
            head = tail = nuevoNodo;
        } else if (head.equals(nodo)) {
            nuevoNodo.setNext(head);
            head.setPrev(nuevoNodo);
            head = nuevoNodo;
        } else {
            NodoDoble<T> actual = head;
            while (actual != null) {
                if (actual.getNext() != null && actual.getNext().equals(nodo)) {
                    nuevoNodo.setNext(actual.getNext());
                    actual.setNext(nuevoNodo);
                    nuevoNodo.setPrev(actual);
                    if (nuevoNodo.getNext() != null) {
                        nuevoNodo.getNext().setPrev(nuevoNodo);
                    }
                    return;
                }
                actual = actual.getNext();
            }
            System.out.println("Error: Nodo no encontrado.");
        }
    }

    @Override
    public void addAfter(INodo<T> nodo, T valor) {
        NodoDoble<T> nuevoNodo = new NodoDoble<T>(valor);
        if (nodo == null) {
            System.out.println("Error: Nodo no puede ser nulo.");
            return;
        }
        nuevoNodo.setNext(nodo.getNext());
        nuevoNodo.setPrev((NodoDoble<T>) nodo);
        if (nodo.getNext() != null) {
            ((NodoDoble<T>) nodo.getNext()).setPrev(nuevoNodo);
        } else {
            tail = nuevoNodo;
        }
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