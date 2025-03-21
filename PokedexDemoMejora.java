import java.util.Random;
import java.util.Scanner;

class Pokemon {
    String name;
    int level;
    Pokemon next;

    public Pokemon(String name, int level) {
        this.name = name;
        this.level = level;
        this.next = null;
    }
}

class Pokedex {
    private Pokemon head;
    private Random random = new Random();

    public void addPokemon(String name, int level) {
        Pokemon newPokemon = new Pokemon(name, level);
        if (head == null) {
            head = newPokemon;
            return;
        }
        Pokemon temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newPokemon;
    }

    public void removePokemon(String name) {
        Pokemon temp = head, prev = null;
        if (temp != null && temp.name.equals(name)) {
            head = temp.next;
            return;
        }
        while (temp != null && !temp.name.equals(name)) {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null || prev == null) return;
        prev.next = temp.next;
    }

    public boolean searchPokemon(String name) {
        Pokemon temp = head;
        while (temp != null) {
            if (temp.name.equals(name)) return true;
            temp = temp.next;
        }
        return false;
    }

    public void mejorPokemon() {
        if (head == null) {
            System.out.println("No tienes pokemones :(");
            return;
        }
        Pokemon mejorPokemon = head;
        Pokemon actual = head.next;

        while (actual != null) {
            if (actual.level > mejorPokemon.level) {
                mejorPokemon = actual;
            }
            actual = actual.next;
        }
        System.out.println("El pokemon con mejor nivel es: " + mejorPokemon.name + " con un nivel de: " + mejorPokemon.level);
    }

    public void selectionSort() {
        Pokemon current = head;

        while (current != null) {
            Pokemon minNode = current;
            Pokemon search = current.next;

            while (search != null) {
                if (search.level < minNode.level) {
                    minNode = search;
                }
                search = search.next;
            }

            int tempLevel = current.level;
            String tempName = current.name;
            current.level = minNode.level;
            current.name = minNode.name;
            minNode.level = tempLevel;
            minNode.name = tempName;

            current = current.next;
        }
    }

    public Pokemon indicePokemon(int index) {
        Pokemon temp = head;
        int count = 1;
        while (temp != null) {
            if (count == index) return temp;
            temp = temp.next;
            count++;
        }
        return null;
    }

    public void atraparPokemon(String salvajes, int nivelSalvajes, Pokemon pokemonElejido) {
        int probabilidad = 50; // Probabilidad captura
        int oportunidad = random.nextInt(100); // Numero al azar para las oportunidades de captura


        System.out.println("Usaste a " + pokemonElejido.name + " para intentar capturarlo...");
        System.out.println("Intentando capturarlo...");

        if (oportunidad < probabilidad) {
            addPokemon(salvajes, nivelSalvajes);
            System.out.println("¡Capturaste a " + salvajes + "!\n");
        } else {
            System.out.println(salvajes + " escapó...\n");
        }
    }

    public void mostrarPokemon(String name){
        Pokemon temp = head;
        boolean encontrado = false;
        while (temp != null) {
            if (temp.name.equals(name)){
                System.out.println("Pokemon: "+ temp.name + "\nNivel: " + temp.level);
                encontrado = true;
            }
            temp = temp.next;
        }
        if (!encontrado) {
            System.out.println("No se encontró a " + name + " en la Pokedex.");
        }
    }

    public void showPokedex() {
        System.out.println("Tu Pokedex:");
        Pokemon temp = head;
        int indice= 1;
        while (temp != null) {
            System.out.println(indice + ". " + temp.name + " (Nivel " + temp.level + ")");
            temp = temp.next;
            indice++;
        }
    }
}
public class PokedexDemoMejora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pokedex pokedex = new Pokedex();
        Random random = new Random();
        int opcion, level;
        String name;

        System.out.println("Bienvenido, Selecciona la opcion que deseas realizar");

        pokedex.addPokemon("Pikachu", 10);
        pokedex.addPokemon("Charizard", 36);
        pokedex.addPokemon("Bulbasaur", 5);
        pokedex.removePokemon("Charizard");


        do {
            System.out.println("1. Añadir un Pokemon.");
            System.out.println("2. Eliminar un Pokemon.");
            System.out.println("3. Buscar un Pokemon.");
            System.out.println("4. Ver la Pokedex");
            System.out.println("5. Combate");
            System.out.println("6. Salir");
            System.out.print("\nSelecciona una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:
                    System.out.print("\nIngrese los datos del pokemon que desea agregar: ");
                    System.out.println("\nIngrese el nombre del pokemon: ");
                    name = scanner.nextLine();
                    System.out.println("Ingrese el nivel del pokemon: ");
                    level = scanner.nextInt();
                    scanner.nextLine();
                    pokedex.addPokemon(name, level);
                    break;

                case 2:
                    System.out.print("\nIngresa el nombre del pokemon a eliminar: ");
                    name = scanner.nextLine();
                    scanner.nextLine();
                    pokedex.removePokemon(name);
                    break;

                case 3:
                    System.out.println("¿Por qué método desea buscar su Pokémon?");
                    System.out.println("1. Mediante el nombre.");
                    System.out.println("2. Pokémon de nivel más alto.");
                    opcion = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    if (opcion == 1) {
                        System.out.print("\nIngresa el nombre del Pokémon que desea buscar: ");
                        name = scanner.nextLine(); // Capturar correctamente el nombre
                        pokedex.mostrarPokemon(name);
                    } else {
                        pokedex.mejorPokemon();
                    }

                    System.out.println("¿Está Bulbasaur en la Pokedex? " + pokedex.searchPokemon("Bulbasaur")); // true
                    System.out.println("¿Está Squirtle en la Pokedex? " + pokedex.searchPokemon("Squirtle")); // false
                    break;

                case 4:
                    pokedex.selectionSort();
                    pokedex.showPokedex(); // Pikachu (Nivel 10) -> Charizard (Nivel 36) -> Bulbasaur (Nivel 5) -> null
                    break;

                case 5:
                    String[] pokemonesSalvajes = {"Pikachu", "Charmander", "Squirtle", "Bulbasaur", "Pidgey", "Rattata", "Eevee", "Jigglypuff"};

                    // Variables pokemon salvaje
                    String salvajes;
                    int nivelSalvajes;

                    // Generar pokemon salvaje
                    salvajes = pokemonesSalvajes[random.nextInt(pokemonesSalvajes.length)];
                    nivelSalvajes = random.nextInt(40) + 1; // Nivel aleatorio
                    System.out.println("\n¡Un " + salvajes + " salvaje aparecio! Nivel: " + nivelSalvajes);

                    // pokemon a elejir
                    pokedex.showPokedex();
                    System.out.println("\nElige un Pokémon para intentar capturar al salvaje (ingresa el número): ");
                    int eleccion = scanner.nextInt();

                    Pokemon pokemonElejido = pokedex.indicePokemon(eleccion);
                    if (pokemonElejido != null) {
                        pokedex.atraparPokemon(salvajes, nivelSalvajes, pokemonElejido);
                    }
                    break;

                case 6:
                    System.out.println("Saliendo, gracias por usar la pokedex :)");
                    break;
            }
        }   while (opcion != 6);
        scanner.close();

        pokedex.showPokedex();
        scanner.close();
    }
}

