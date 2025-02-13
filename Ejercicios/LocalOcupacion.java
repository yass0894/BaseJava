package Ejercicios;

import java.util.ArrayList;
import java.util.Scanner;

public class LocalOcupacion {
    private static ArrayList<String> personas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("""
                1. Listado
                2. Mostrar número de personas
                3. Añadir
                4. Modificar
                5. Quitar por nombre
                0. Salir
                """);
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer de entrada

            switch (opcion) {
                case 1 -> listarPersonas();
                case 2 -> mostrarNumeroDePersonas();
                case 3 -> anadirPersona(scanner);
                case 4 -> modificarPersona(scanner);
                case 5 -> quitarPersona(scanner);
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    private static void listarPersonas() {
        if (personas.isEmpty()) {
            System.out.println("No hay personas en la lista.");
        } else {
            System.out.println("Listado de personas:");
            for (String persona : personas) {
                System.out.println(persona);
            }
        }
    }

    private static void mostrarNumeroDePersonas() {
        System.out.println("Número de personas: " + personas.size());
    }

    private static void anadirPersona(Scanner scanner) {
        System.out.print("Introduce el nombre de la persona a añadir: ");
        String nombre = scanner.nextLine();
        personas.add(nombre);
        System.out.println("Persona añadida.");
    }

    private static void modificarPersona(Scanner scanner) {
        System.out.print("Introduce el nombre de la persona a modificar: ");
        String nombre = scanner.nextLine();
        if (personas.contains(nombre)) {
            System.out.print("Introduce el nuevo nombre: ");
            String nuevoNombre = scanner.nextLine();
            personas.set(personas.indexOf(nombre), nuevoNombre);
            System.out.println("Persona modificada.");
        } else {
            System.out.println("Persona no encontrada.");
        }
    }

    private static void quitarPersona(Scanner scanner) {
        System.out.print("Introduce el nombre de la persona a quitar: ");
        String nombre = scanner.nextLine();
        if (personas.remove(nombre)) {
            System.out.println("Persona eliminada.");
        } else {
            System.out.println("Persona no encontrada.");
        }
    }
}
