package base;

import java.util.Random;

import bibliotecas.Consola;

public class AdivinaElNumero {
	private static final int TOPE_INTENTOS = 5;
	private static Integer mejorPuntuacion = null;
	private static int intentos;

	public static void main(String[] args) {
		int minimo = Consola.pedirEntero("Mínimo");
		int maximo = Consola.pedirEntero("Máximo");

		String otraPartida;
		
		do {
			
				intentos = 0;
				int numero = new Random().nextInt(minimo, maximo + 1);
				System.out.println(numero);
				int suNumero;
				boolean repetir;
			
				
				do {
					suNumero = Consola.pedirEntero("Dime un número", minimo, maximo);

					intentos++;

					repetir = calcularResultado(numero, suNumero);
				} while (repetir);
			
			otraPartida = Consola.pedirTexto("¿Otra partida? (s/N)");
			
		} while (otraPartida.equalsIgnoreCase("s"));
	}

	private static boolean calcularResultado(int numero, int suNumero) {
		boolean seHaPasado = intentos >= TOPE_INTENTOS;

		// Comprobar si el número es mayor que el introducido
		if (numero > suNumero && !seHaPasado) {
			System.out.println("El número es mayor");
		} else if (numero < suNumero && !seHaPasado) {
			System.out.println("El número es menor");
		} else if (numero == suNumero) {
			System.out.println("Has acertado");
			System.out.println("Te ha costado " + intentos + " intentos");
			
			if(mejorPuntuacion == null || intentos < mejorPuntuacion) {
				System.out.println("Felicidades. Has conseguido la mejor puntuación");
				mejorPuntuacion = intentos;
			}
			
			System.out.println("La mejor puntuación es " + mejorPuntuacion);
			
			return false;
		} else if (seHaPasado) {
			System.out.println("Te has pasado de intentos");
			return false;
		}
		
		return true;
	}

}
/*public class AdivinaElNumero {
	
	private static final int TOPE_INTENTOS = 5;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Integer minimo = null;
		
		boolean estaMal = true;
		
		do {
				System.out.println("Minimo: ");
				
				try {
					
						minimo = Integer.parseInt(sc.nextLine());
						estaMal = false;
				} catch (NumberFormatException e) {
					System.out.println("Debes introducir un numero");
				}
		} while (estaMal);
		
		System.out.println("Maximo: ");
		int maximo = Integer.parseInt(sc.nextLine());
		
		Integer mejorPuntuacion = null;
		
		String otraPartida;
		
		do {
				// Buscar un numero aleatorio
				int numero = new Random().nextInt(minimo, maximo + 1);
				System.out.println(numero);
				int intentos = 0;
				int suNumero;
				boolean repetir = true;
				boolean seHaPasado = false;
				do {
				}
						do {
								// Pedir un numero
								System.out.println("Dime un numero: ");
								suNumero = Integer.parseInt(sc.nextLine());
								
								if (suNumero < minimo || suNumero > maximo);{
									System.out.println("El numero debe ser entre" + minimo + " y " 
											 maximo);
								}
						}
				}
		}
		
		
		
		/*int topeIntentos;
		do {
			System.out.println("Introduce el tope de intentos: ");
			topeIntentos = sc.nextInt();
		} while (topeIntentos <= 0);
		
		int limiteInferior;
		int limiteSuperior;
		do {
			System.out.println("Introduce el limite inferior: ");
			limiteInferior = sc.nextInt();
			System.out.println("Introduce el limite superior: ");
			limiteSuperior = sc.nextInt();
		} while (limiteInferior >= limiteSuperior);
		
		boolean otraPartida;
		int puntuacionMinima = Integer.MAX_VALUE;
		
		do {
			int numero = new Random().nextInt(limiteSuperior - limiteInferior + 1) + limiteInferior;
			int suNumero;
			int intentos = 0;
			boolean acertado = false;
			
			System.out.println("¡Comienza el juego!");
			
			while (intentos < topeIntentos) {
				System.out.println("Dime un numero: ");
				suNumero = sc.nextInt();
				intentos++;
				
				if (numero > suNumero) {
					System.out.println("El numero es mayor");
				} else if (numero < suNumero) {
					System.out.println("El numero es menor");
				} else {
					System.out.println("¡Has acertado en " + intentos + "intentos!");
					acertado = true;
					break;
				}
					
			}
			
			if (!acertado) {
				System.out.println("Has agotado el tope de intentos. El numero era: " + numero);	
			}
			
			if (acertado && intentos < puntuacionMinima) {
				puntuacionMinima = intentos;
				System.out.println("¡Nueva puntuacion minima: " + puntuacionMinima + "intentos!");
			}
			System.out.println("¿Quieres jugar otra partida? (true/false): ");
			otraPartida = sc.nextBoolean();
			
		}	while (otraPartida);
		
		System.out.println("Gracias por jugar. ¡Hasta la proxima!");
		sc.close();	
		}
	}
	

		/*int numero = new Random().nextInt(0, 101);

//		System.out.println(numero);
 
		int suNumero;
		int intentos = 0;

		do {
			System.out.print("Dime un número: ");
			suNumero = sc.nextInt();
			intentos++;
			
//			System.out.println(suNumero);
			
			if (numero > suNumero) {
				System.out.println("El número es mayor");
			} else if (numero < suNumero) {
				System.out.println("El número es menor");
			} else {
				System.out.println("Has acertado");
			}
		} while (numero != suNumero);
		
		sc.close();
	}
}*/
