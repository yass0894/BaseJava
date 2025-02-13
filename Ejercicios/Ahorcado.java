package Ejercicios;

/*
 * Juego en el que hay que adivinar por letras una palabra
 * 
 * El juego tendrá una lista de palabras almacenada en una variable
 * 
 * El programa seleccionará una palabra al azar
 * 
 * El usuario debe de proporcionar letras por cada turno
 * 
 * Si el usuario acierta con una letra existente, no cuenta intento
 * 
 * Si el usuario falla, se cuenta un intento
 * 
 * Al de un cierto número tope de intentos el usuario pierde
 */

	import java.util.Random;
	import java.util.Scanner;

	public class Ahorcado {
		private static final String[] PALABRAS = {"programacion", "java", "eclipse", "ahorcado"};
	    private static final int INTENTOS_MAX = 6;
	
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        String palabra = PALABRAS[new Random().nextInt(PALABRAS.length)];
	        StringBuilder progreso = new StringBuilder("_".repeat(palabra.length()));
	        int intentos = 0;
	        boolean acertado = false;
	        boolean letraEncontrada;
	        char letra;

	        System.out.println("¡Bienvenido al juego de ahorcado!");

	        while (intentos < INTENTOS_MAX && !acertado) {
	            System.out.println("Palabra: " + progreso);
	            System.out.println("Intentos restantes: " + (INTENTOS_MAX - intentos));
	            System.out.print("Introduce una letra: ");
	            letra = scanner.nextLine().charAt(0);

	            letraEncontrada = false;
	            for (int i = 0; i < palabra.length(); i++) {
	                if (palabra.charAt(i) == letra) {
	                    progreso.setCharAt(i, letra);
	                    letraEncontrada = true;
	                }
	            }

	            if (!letraEncontrada) {
	                intentos++;
	            }

	            if (progreso.toString().equals(palabra)) {
	                acertado = true;
	            }
	        }

	        if (acertado) {
	            System.out.println("¡Felicidades, has adivinado la palabra: " + palabra + "!");
	        } else {
	            System.out.println("Lo siento, has perdido. La palabra era: " + palabra);}
	        scanner.close();
	    }}