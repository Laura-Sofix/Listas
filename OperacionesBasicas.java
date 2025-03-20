/*9. Cada estudiante deberá realizar un programa en java que se refleje las operaciones básicas en una lista enlazada:
agregar, eliminar, modificar y consultar nodos. Y después implementará un programa en Java que permita gestionar una lista enlazada. Las operaciones para implementar son:
a)	Agregar un nodo.
b)	Eliminar un nodo por dato.
c)	Modificar un nodo en una posición específica.
d)	Consultar y mostrar la lista completa. */

import java.util.Scanner;

class Nodo {
    int dato;
    Nodo siguiente;

    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}

class ListaEnlazada {
    Nodo cabeza;
    public ListaEnlazada() {
        this.cabeza = null;
    }
    public void agregarNodo(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        nuevoNodo.siguiente = cabeza;
        cabeza = nuevoNodo;
    }
    public void eliminarNodo(int valor) {
        if (cabeza == null) return;
        if (cabeza.dato == valor) {
            cabeza = cabeza.siguiente;
            return;
        }
        Nodo actual = cabeza;
        while (actual.siguiente != null && actual.siguiente.dato != valor) {
            actual = actual.siguiente;
        }
        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
        }
    }
    public void modificarNodo(int valorAntiguo, int valorNuevo) {
        Nodo actual = cabeza;

        while (actual != null) {
            if (actual.dato == valorAntiguo) {
                actual.dato = valorNuevo;
                return;
            }
            actual = actual.siguiente;
        }
    }
    public void mostrarLista() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("Null");
    }
}

public class OperacionesBasicas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaEnlazada lista = new ListaEnlazada();
        int opcion, dato, posicion;

        System.out.println("Bienvenido :) A continuacion, podras realizar las siguientes operaciones basicas para una lista enlazada:");

        do {
            System.out.println("1. Agregar Nodo");
            System.out.println("2. Eliminar Nodo por Dato.");
            System.out.println("3. Modificar Nodo en Posicion Especifica.");
            System.out.println("4. Consutar y Mostrar Lista Completa");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa el dato a agregar: ");
                    dato = scanner.nextInt();
                    lista.agregarNodo(dato);
                    break;
                case 2:
                    System.out.print("Ingresa el dato a eliminar: ");
                    dato = scanner.nextInt();
                    lista.eliminarNodo(dato);
                    break;
                case 3:
                    System.out.print("Ingresa la posición a modificar: ");
                    posicion = scanner.nextInt();
                    System.out.print("Ingresa el nuevo valor: ");
                    dato = scanner.nextInt();
                    lista.modificarNodo(dato, posicion);
                    break;
                case 4:
                    lista.mostrarLista();
                    break;
                case 5:
                    System.out.println("Saliendo, gracias por usar el programa :)");
                    break;
            }
        } while (opcion != 5);
        scanner.close();
    }
}
