/*import java.util.Scanner;

public class borrador {

	public static void main(String[] args)  {

		Scanner teclado = new Scanner(System.in);

		String[][]matriz = {{"p","l","l","b","b"},{"l","b","b","l","l"},
				{"l","b","l","l","l"},{"l","l","l","b","l"},{"b","l","b","l","f"}};


		for (int i = 0; i < matriz.length; i++) {
			System.out.println(" ");
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + " ");
			} 
		}

		/*	for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {

				if (matriz[i][j].equalsIgnoreCase("p") && !matriz[i+1][j].equalsIgnoreCase("b")) {

					if (matriz[i+1][j].equalsIgnoreCase("l")) {
						matriz[i+1][j]="p";
						matriz[i][j]="l";
						}

				}

			}
		}
		for (int j = 0; j < matriz.length; j++) {
			for (int i = 0; i < matriz.length; i++) {
				if (matriz[i][j].equalsIgnoreCase("p") && !matriz[i][j+1].equalsIgnoreCase("b")) {

					if (matriz[i][j+1].equalsIgnoreCase("l")) {
						matriz[i][j+1]="p";
						matriz[i][j]="l";
					}

				}

			}
		}

		System.out.println(" ");

		for (int i = 0; i < matriz.length; i++) {
			System.out.println(" ");
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + " ");
			} 
		}


		/*introduzco variables,
		String menu = "4";
		String[][][] matriz;
		String botones;
		String finJuego = "♦";
		String [] botonesJuego = {"\nPara jugar utiliza siguientes botones:"
				, "w: subir" 
				, "s: bajar" 
				, "a: izquierda" 
				, "d: derecha"
		};


		teclado.close();
	}


	//metodo para mostrar matriz,


		for (int i = 0; i < matriz.length; i++) {
			System.out.println(" ");
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + " ");
			} 
		}



	//función para bajar pepito(boton S),
	static String[][]pasoPepitoBajar(String[][]matriz){
		String vacia = "҈";
		String pepito = "☻";

		vacia = matriz[0][0];

		/*for (int i = 0; i < matriz.length-1; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				vacia = matriz[i+1][j];
				if (matriz[i+1][j] == vacia) {
					matriz[i+1][j] = pepito;
					 matriz[i][j] = vacia;
				}
			}
		}

		for (int j = 0; j < matriz[0].length; j++) {

			if (matriz[1][j] == vacia) {
				matriz[1][j] = pepito;
				 matriz[0][j] = vacia;
			}
		}



return matriz;
	}
}*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author tikov
 *
 */
public class borrador {

	public static int filaPepito;
	public static int columnaPepito;
	public static String vacia = "҈";
	public static String pepito = "☻";
	public static String finJuego = "♦";
	public static String botones;
	public static Scanner teclado = new Scanner(System.in);
	public static String [] arrayOpcionesMenuPrincipal = {
			"\nPara jugar elige una opcion:"
			,"J. Jugar partida"
			,"R. Resultados de partidas"
			,"Q. Salir"
			};
	public static String [] arrayOpcionesMenuJuego = {
			"Elige un nivel del juego:"
			, "1. Fácil"
			, "2. Medio"
			, "3. Difícil"
			, "Q. ATRAS"
			};
	public static String [] arrayOpcionesMenuResultado = {
			"Demostrar resultados por:"
			, "1. niveles"
			, "2. orden de ejecución"
			, "Q. ATRAS"
			};
	public static String stringDeSalida = "Ha salido de juego";
	public static String stringErrorDeOpcion = "Elige por favor una de las opciones válidas";


	public static void main(String[] args) throws FileNotFoundException {

		Scanner teclado = new Scanner(System.in);
		
		//1. MOSTRAR MENU PRINCIPAL
		//2. ELECCIÓN DE OPCIÓN
		//2.1. preguntamos la opción
		String menu = "incognito";
		while (!menu.equals("q")) {
			mostrarArray(arrayOpcionesMenuPrincipal);
			menu = teclado.next();
			if (menu.equals("j")) {
				mostrarArray(arrayOpcionesMenuJuego);
				menu = teclado.next();
				while (!menu.equals("q")) {
					//jugar();
				}
				//jugar
			}
			else if (menu.equals("r")) {
				mostrarArray(arrayOpcionesMenuResultado);
				//mostrar resultado
				//modificar
			}
		}
		System.out.println(stringDeSalida);
	}
	
	//2.2. según la opción elegimos la función.
			//eleccionDeOpcion();
			//3. MOSTRAR SUBMENU DE OPCIÓN O SALIR
			//4. JUGAMOS O MOSTRAMOS LOS RESULTADOS
	/**
	 * Función que devuelve la opción elegida del menú
	 * @param arrayMenu
	 * @return {@link String}
	 */
	static String menu (String[] arrayMenu)
	{
		mostrarArray(arrayMenu);
		String menu = teclado.next();
		System.out.println(mostrarMensajeDeOpcion(menu));
		return menu;
	}
	/**
	 * Devuelve 
	 * @param opcion
	 * @return {@link String}
	 */
	static String mostrarMensajeDeOpcion(String opcion) 
	{
		switch (opcion) {
		case "j":
			return menu(arrayOpcionesMenuJuego);
			
		case "r":
			return menu(arrayOpcionesMenuResultado);
			
		case "q":
			return stringDeSalida;
		default:
			return stringErrorDeOpcion;
		}
	}
	/**
	 * imprimimos por consola cualquier array
	 * @param array
	 */
	static void mostrarArray (String[] array) 
	{
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}

