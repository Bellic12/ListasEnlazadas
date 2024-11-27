# Listas Enlazadas en Java

Este proyecto es una implementación de listas enlazadas en Java, que incluye:

- Listas enlazadas sencillas sin cola (`SencillaSinCola`)
- Listas enlazadas sencillas con cola (`SencillaConCola`)
- Listas doblemente enlazadas con cola (`DobleConCola`)

## Descripción

El proyecto utiliza interfaces y genéricos para proporcionar una implementación flexible y reutilizable de listas enlazadas. Cada tipo de lista enlazada tiene sus propias características y métodos específicos.

### Listas Enlazadas Sencillas Sin Cola (`SencillaSinCola`)

Esta implementación de lista enlazada no mantiene una referencia al último nodo (cola). Los métodos principales incluyen:

- `pushFront(T valor)`: Inserta un nodo al inicio de la lista.
- `pushBack(T valor)`: Inserta un nodo al final de la lista.
- `popFront()`: Elimina el nodo al inicio de la lista.
- `popBack()`: Elimina el nodo al final de la lista.
- `find(T valor)`: Encuentra un nodo con el valor especificado.
- `erase(T valor)`: Elimina un nodo con el valor especificado.
- `addBefore(INodo<T> nodo, T valor)`: Inserta un nodo antes de un nodo específico.
- `addAfter(INodo<T> nodo, T valor)`: Inserta un nodo después de un nodo específico.
- `empty()`: Verifica si la lista está vacía.
- `topFront()`: Obtiene el valor del primer nodo.
- `topBack()`: Obtiene el valor del último nodo.

### Listas Enlazadas Sencillas Con Cola (`SencillaConCola`)

Esta implementación de lista enlazada mantiene una referencia tanto al primer nodo (cabeza) como al último nodo (cola). Los métodos principales incluyen:

- `pushFront(T valor)`: Inserta un nodo al inicio de la lista.
- `pushBack(T valor)`: Inserta un nodo al final de la lista.
- `popFront()`: Elimina el nodo al inicio de la lista.
- `popBack()`: Elimina el nodo al final de la lista.
- `find(T valor)`: Encuentra un nodo con el valor especificado.
- `erase(T valor)`: Elimina un nodo con el valor especificado.
- `addBefore(INodo<T> nodo, T valor)`: Inserta un nodo antes de un nodo específico.
- `addAfter(INodo<T> nodo, T valor)`: Inserta un nodo después de un nodo específico.
- `empty()`: Verifica si la lista está vacía.
- `topFront()`: Obtiene el valor del primer nodo.
- `topBack()`: Obtiene el valor del último nodo.

### Listas Doblemente Enlazadas Con Cola (`DobleConCola`)

Esta implementación de lista enlazada mantiene una referencia tanto al primer nodo (cabeza) como al último nodo (cola), y cada nodo tiene referencias a su nodo anterior y siguiente. Los métodos principales incluyen:

- `pushFront(T valor)`: Inserta un nodo al inicio de la lista.
- `pushBack(T valor)`: Inserta un nodo al final de la lista.
- `popFront()`: Elimina el nodo al inicio de la lista.
- `popBack()`: Elimina el nodo al final de la lista.
- `find(T valor)`: Encuentra un nodo con el valor especificado.
- `erase(T valor)`: Elimina un nodo con el valor especificado.
- `addBefore(INodo<T> nodo, T valor)`: Inserta un nodo antes de un nodo específico.
- `addAfter(INodo<T> nodo, T valor)`: Inserta un nodo después de un nodo específico.
- `empty()`: Verifica si la lista está vacía.
- `topFront()`: Obtiene el valor del primer nodo.
- `topBack()`: Obtiene el valor del último nodo.

## Ejecución

Para ejecutar el proyecto, asegúrate de tener instalado Java en tu sistema. Compila y ejecuta la clase `App.java` para ver ejemplos de uso y pruebas de rendimiento de las diferentes implementaciones de listas enlazadas.

```sh
javac src/App.java
java src/App
```

## Contribuciones

Las contribuciones son bienvenidas. Si encuentras algún problema o tienes alguna sugerencia, por favor abre un issue o envía un pull request.