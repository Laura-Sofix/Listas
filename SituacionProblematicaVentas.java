/*10. Situación Problemática Contexto: Imagina que eres un profesional que trabaja en ventas. Tu trabajo implica interactuar con numerosos clientes, colegas y proveedores.
A medida que tu red de contactos crece, te das cuenta de que necesitas una forma eficiente de gestionar la información de cada persona con la que te comunicas.

Problemas:
Desorganización de Información:
Tienes múltiples notas en papeles, tarjetas de presentación y correos electrónicos que contienen información de contacto. Esto hace que sea difícil encontrar los datos correctos cuando los necesitas.

Pérdida de Oportunidades:
Algunas veces, no puedes recordar detalles importantes sobre tus contactos, como su teléfono o email, lo que puede resultar en oportunidades perdidas para hacer seguimiento o cerrar ventas.

Duplicación de Datos:
Es fácil que se creen registros duplicados para la misma persona, ya que a menudo guardas la información en diferentes lugares sin saber que ya tienes un contacto con esos datos.

Actualización de Información:
Cuando un contacto cambia su número de teléfono o dirección de email, a menudo te enteras demasiado tarde, lo que significa que intentas comunicarte con información desactualizada.

Falta de Consultas Eficientes:
Buscar un contacto específico en tu colección de notas puede ser un proceso largo y tedioso. Necesitas una manera rápida y fácil de consultar información.

Solución Propuesta
Desarrollar un sistema de gestión de contactos que te permita:
Agregar, eliminar y modificar contactos de manera rápida y sencilla.
Consultar contactos eficientemente a través de una interfaz de usuario simple.
Mantener la información organizada y accesible, reduciendo la posibilidad de duplicaciones.
Facilitar la actualización de datos cuando sea necesario. */


import java.util.Scanner;

class Contacto {
    String nombre;
    String email;
    long numero;
    Contacto siguiente;

    public Contacto(String nombre, String email, long numero) {
        this.nombre = nombre;
        this.email = email;
        this.numero = numero;
        this.siguiente = null;
    }

}

class ListaContactos {
    private Contacto cabeza;

    // Agregar contacto
    public void agregarContacto(String nombre, String email, long numero) {
        if (verificador(nombre)) {
            System.out.println("El contacto ya existe.");
            return;
        }

        Contacto nuevoContacto = new Contacto(nombre, email, numero);
        if (cabeza == null) {
            cabeza = nuevoContacto;
            return;
        }
        Contacto temp = cabeza;
        while (temp.siguiente != null) {
            temp = temp.siguiente;
        }
        temp.siguiente = nuevoContacto;
    }

    // Eliminar contacto
    public void eliminarContacto(String nombre) {
        Contacto temp = cabeza, prev = null;
        if (temp != null && temp.nombre != null && temp.nombre.equals(nombre)) {
            cabeza = temp.siguiente;
            return;
        }
        while (temp != null && !temp.nombre.equals(nombre)) {
            prev = temp;
            temp = temp.siguiente;
        }
        if (temp == null) return;
        prev.siguiente = temp.siguiente;
    }


    public boolean verificador(String nombre){
        Contacto actual = cabeza;
        while (actual != null) {
            if (actual.nombre.equals(nombre)) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    // Mostrar la lista de contacto
    public void mostrarLista() {
        Contacto temp = cabeza;
        while (temp != null) {
            System.out.println("\n Nombre: " + temp.nombre + "\n﹋﹋﹋﹋﹋﹋﹋﹋﹋﹋﹋﹋﹋﹋" + "\n Email: " + temp.email + "\n Telefono: " + temp.numero);
            temp = temp.siguiente;
        }
        System.out.println("null");
    }
}

public class SituacionProblematicaVentas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaContactos lista = new ListaContactos();
        long numero;
        int opcion;
        String email;
        lista.agregarContacto("Pepito", "Pepito1234@gmail.com",  1234567890);
        lista.agregarContacto("Ana", "ANAlisis@gmail.com", 789456123);


        System.out.println("Bienvenido a su sistema de gestion de contactos :)");

        do{
            System.out.println("¿Que accion desea realizar?");
            System.out.println("1. Agregar un contacto.");
            System.out.println("2. Eliminar un contacto.");
            System.out.println("3. Modificar un contacto.");
            System.out.println("4. Consultar contactos.");
            System.out.println("5. Salir.");
            System.out.println("Seleccione la accion que desea realizar: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:
                    System.out.println("Ingrese el nombre del contacto: ");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingrese el email del contacto: ");
                    email = scanner.nextLine();
                    System.out.println("Ingrese el número de teléfono del contacto: ");
                    numero = scanner.nextLong();
                    scanner.nextLine();
                    lista.agregarContacto(nombre, email, numero);
                    break;

                case 2:
                    System.out.print("Ingrese el nombre del contacto que desea eliminar: ");
                    nombre = scanner.nextLine();
                    lista.eliminarContacto(nombre);
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del contacto que desea modificar: ");
                    nombre = scanner.nextLine();
                    System.out.print("Ingrese el nuevo email: ");
                    email = scanner.nextLine();
                    System.out.print("Ingrese el nuevo numero de telefono: ");
                    numero = scanner.nextLong();
                    lista.eliminarContacto(nombre);
                    lista.agregarContacto(nombre, email, numero);
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
