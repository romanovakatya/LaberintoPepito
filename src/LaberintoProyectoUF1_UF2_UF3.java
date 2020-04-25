import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LaberintoProyectoUF1_UF2_UF3 {

	public static Scanner teclado = new Scanner(System.in);

	//introduzco variables,
	public static int filaPepito;
	public static int columnaPepito;
	public static String vacia = "҈";
	public static String pepito = "☻";
	public static String finJuego = "♦";
	public static String botones;
	public static String menu = "4";
	public static String [] menuPrincipal = {
			"\nMenu principal:"
			,"J. Jugar partida"
			,"R. Resultados de las partidas"
			,"Q. Salir"
	};
	public static String [] menuNiveles = {
			"Niveles del juego:"
			, "1. Fácil"
			, "2. Medio"
			, "3. Difícil"
			, "Q. ATRAS"
	};
	public static String [] menuResultado = {
			"Mostrar resultados por:"
			, "1. niveles"
			, "2. orden de ejecución"
			, "Q. ATRAS"
	};
	public static String [] menuBotonesJuego = {
			"\nBotones para mover pepito:"
			, "w: ↑ subir" 
			, "s: ↓ bajar" 
			, "a: ← izquierda" 
			, "d: → derecha"
			, "Q. SALIR"
	};

	public static boolean salidaPepito = true; 

	public static void main(String[] args) throws FileNotFoundException {

		String[][][] matriz;

		//llenamos matriz con el contenido de un documento txt(tres niveles de del juego,
		//utilizando función generarMatriz,
		matriz = generarMatriz();

		//Saludamos al jugador,
		System.out.println("¡Bienvenido al LABERINTO DE PEPIT☻!");
		//muestro el menu principal, utilizando función generarMenu,
		menu = generarMenu(menuPrincipal);
		//si usuario ha elegido la opción incorrecta, le muestro un mensaje y propuso elegir otra vez,
		while (!menu.equalsIgnoreCase("j") && !menu.equalsIgnoreCase("r") && !menu.equalsIgnoreCase("q")) {
			System.out.println("Por favor, elige la opción correcta");
			menu = generarMenu(menuPrincipal);
		}
		//mientras jugador quiere jugar(no elige botón "Q"), le muestro menu principal,
		while (!menu.equalsIgnoreCase("q") || menu.equalsIgnoreCase("j") || menu.equalsIgnoreCase("r")) {
			//si ha elegido j - jugar,
			if (menu.equalsIgnoreCase("j")) {

				//creamos y mostramos menu secundario con niveles del juego,
				menu = generarMenu(menuNiveles);

				//en caso de error muestro mensaje y propuesto elegir la opción correcta,
				while (!menu.equalsIgnoreCase("3") && !menu.equalsIgnoreCase("2") &&
						!menu.equalsIgnoreCase("1") && !menu.equalsIgnoreCase("q")){	

					System.out.println("Nivel no existe");
					//y menu con niveles de dificultad,
					menu = generarMenu(menuNiveles);
				}
				//cuando elige opción 1 se empieza partida de nivel más facil,
				if (menu.equalsIgnoreCase("1")) {					
					//el labirinto inicial,
					demostrarMatriz(matriz[0]);		
					jugarPartida(matriz[0]);
					/*do {
						//muestro botones del juego y labirinto con cada paso de pepito,						
						demostrarMatriz(pepitoMover(matriz[0]));
						//partida continua hasta que el usuario no elige la opción Q - salir o 
						//mientras no llegará al final del labirinto ,
					} while (salidaPepito && !botones.equalsIgnoreCase("q"));*/
					//muestro resultados según la opción de salida elegida,
					// utilizando el método mostrarResultado,
					finDePartida();
					//genero desde nuevo la matriz inicial y mostramos el menu inicial,
					matriz = generarMatriz();
					menu = generarMenu(menuPrincipal);														
				}

				//cuando elige opción 2 se empieza partida de dificultad media,
				else if (menu.equalsIgnoreCase("2")) {
					//al principio muestro el labirinto,
					demostrarMatriz(matriz[1]);
					jugarPartida(matriz[1]);
					//muestro resultados según la opción de salida elegida,
					// utilizando el método mostrarResultado,
					finDePartida();
					//genero desde nuevo la matriz inicial y mostramos el menu inicial,
					matriz = generarMatriz();
					menu = generarMenu(menuPrincipal);

					//partida continua hasta que el usuario no elige opción Q - salir o no llega al final
					//del labirinto,
					/*do {
						//muestro botones del juego y labirinto con cada paso de pepito,
						demostrarMatriz(pepitoMover(matriz[1]));
					} while (!botones.equalsIgnoreCase("q"));
					//acabando la partida muestro el menu principal,
					System.out.println("Ha salido de partida");
					menu = generarMenu(menuPrincipal);*/

				}
				//cuando elige opción 3 empieza partida de dificultad alta,
				else if (menu.equalsIgnoreCase("3")) {
					//al principio muestro el labirinto,
					demostrarMatriz(matriz[2]);
					jugarPartida(matriz[2]);
					//muestro resultados según la opción de salida elegida,
					// utilizando el método mostrarResultado,
					finDePartida();
					//genero desde nuevo la matriz inicial y mostramos el menu inicial,
					matriz = generarMatriz();
					menu = generarMenu(menuPrincipal);
					//partida continua hasta que el usuario no elige opción Q - salir o no llega al final
					//del labirinto,
					///////
					/*do {
						//muestro botones del juego,
						botones = generarMenu(menuBotonesJuego);
						//y labirinto con cada paso de pepito,
						demostrarMatriz(pepitoMover(matriz[2]));
					} while (!botones.equalsIgnoreCase("q"));
					//acabando la partida muestro el menu principal,
					System.out.println("Ha salido de partida");
					menu = generarMenu(menuPrincipal);*/
				}
				//botón Q: en cualquier momento de partida se puese salir al menu principal,
				else if (menu.equalsIgnoreCase("q")) {
					menu = generarMenu(menuPrincipal);
				}
			}

			//si en menu principal ha elegido r - resultado
			else if (menu.equalsIgnoreCase("r")) {
				//muestro el menu con variantes de los resultados,
				menu = generarMenu (menuResultado);
				//en caso de error demuestro mensaje,
				while (!menu.equalsIgnoreCase("1") && !menu.equalsIgnoreCase("2") 
						&& !menu.equalsIgnoreCase("q")){
					System.out.println("La opción no existe. Elige entre 1 y 2");
					menu = generarMenu (menuResultado);
				}

				//para ver resultados por niveles,
				if (menu.equalsIgnoreCase("1")) {

				}

				//para ver resultados por orden de los juegos,
				else if (menu.equalsIgnoreCase("2")) {

				}
				//botón Q: en cualquier momento de partida se puese salir al menu principal,
				else if (menu.equalsIgnoreCase("q")) {
					menu = generarMenu(menuPrincipal);
				}
			}
		}
		//cuando en menu principal ha elegido q - salir, 
		//acabo el juego y le muestro un mensaje a usuario,
		System.out.println("El juego se ha terminado. Hasta próximo!");

		teclado.close();
	}


	//función para hacer menu,	
	static String generarMenu (String[]menu)
	{
		//mientras hay lineas de menu los imprimo,
		for (int i = 0; i < menu.length; i++) {
			System.out.println(menu[i]);
		}
		return teclado.next();
	}

	//función para rellenar matriz desde un documento txt,
	static String[][][]generarMatriz () throws FileNotFoundException {
		//leo lo que hay en el documento txt,
		Scanner entrada = new Scanner(new File("laberints.txt"));
		//ya que tenemos tres niveles del juego creamos 3d matriz,
		String[][][]matriz;
		//inicializo 3d matriz,
		matriz= new String [3][][];

		//mientras hay dados en el documento,
		while (entrada.hasNext()) {
			//para cada nivel de matriz,
			for (int i = 0; i < matriz.length; i++) {
				//cojo desde txt tamaño de cada matriz,
				int fila = entrada.nextInt();
				int columna = entrada.nextInt();
				//y los inicializo con esos datos,
				String [][] matrizSinNombre = new String[fila][columna];

				//relleno cada matriz de su contenido,
				for (int j = 0; j < matrizSinNombre.length; j++) {
					for (int j2 = 0; j2 < matrizSinNombre[j].length; j2++) {

						matrizSinNombre[j][j2] = entrada.next();

						if (matrizSinNombre[j][j2].equalsIgnoreCase(pepito)) {
							filaPepito = j;
							columnaPepito = j2;
						}
					}
				}
				matriz[i] = matrizSinNombre;
			}
		}
		entrada.close();
		return matriz;
	}
	//método para mostrar matriz,
	static void demostrarMatriz(String[][]matriz) {
		for (int i = 0; i < matriz.length; i++) {
			System.out.println(" ");
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + " ");
			} 
		}
	}

	static void jugarPartida(String [][]matriz) throws FileNotFoundException  {			
		do {
			//muestro botones del juego y labirinto con cada paso de pepito,						
			demostrarMatriz(pepitoMover(matriz));
			//partida continua hasta que el usuario no elige la opción Q - salir o 
			//mientras no llegará al final del labirinto ,
		} while (salidaPepito && !botones.equalsIgnoreCase("q"));
	}

	//funcion para mover pepito,
	static String[][]pepitoMover(String[][]matriz) throws FileNotFoundException{
		//variable contador para mover pepito a un paso solo,
		int contador = 0;

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {

				//compruebo posición de pepito,
				if (matriz[i][j].equalsIgnoreCase(pepito)) {						
					System.out.println("\n1");				
					//compruebo que contador menos que 1 para hacer solo un paso,
					if (contador < 1) {
						System.out.println("2");

						botones = generarMenu(menuBotonesJuego);				
						//cambio el contenido de esa celda a pepito,
						matriz[i][j] = vacia;
						//si ha elegido botón a: izquierda y una celda atrás no es menor que 0 y  
						//está vacia, muevo alla pepito,
						if (botones.equalsIgnoreCase("a")){
							if ((j-1) >= 0 && (matriz[i][j-1].equalsIgnoreCase(vacia))) {
								matriz[i][j-1] = pepito;
								System.out.println("a");
							}	
							else if ((j-1) >= 0 && (matriz[i][j-1].equalsIgnoreCase(finJuego))) {
								matriz[i][j-1] = pepito;
								salidaPepito = false;
							}
							else {
								matriz[i][j] = pepito;
								System.out.println("za");								
							}
						}
						//si ha elegido botón w: subir, y una celda atrás no es menor que 0 y  
						//está vacia, muevo alla pepito,
						else if (botones.equalsIgnoreCase("w")) {
							if ((i-1) >= 0 && (matriz[i-1][j].equalsIgnoreCase(vacia))) {
								matriz[i-1][j] = pepito;
								System.out.println("w");
							}
							else if ((i-1) >= 0 && (matriz[i-1][j].equalsIgnoreCase(finJuego))) {
								matriz[i-1][j] = pepito;
								salidaPepito = false;
							}
							else {
								matriz[i][j] = pepito;
								System.out.println("zw");								
							}
						}
						//si ha elegido botón d: derecha y una celda adelante es menor que la última posición    
						//de matriz y está vacia, muevo alla pepito,
						else if (botones.equalsIgnoreCase("d")) {
							if ((j+1) < matriz[i].length && (matriz[i][j+1].equalsIgnoreCase(vacia))) {
								matriz[i][j+1] = pepito;
								System.out.println("d");
							}
							else if ((j+1) < matriz[i].length && (matriz[i][j+1].equalsIgnoreCase(finJuego))) {
								matriz[i][j+1] = pepito;
								salidaPepito = false;
							}
							else {
								matriz[i][j] = pepito;
								System.out.println("zd");								
							}
						}		

						//si ha elegido botón s: bajar y una celda adelante es menor que la última posición    
						//de matriz y está vacia, muevo alla pepito,
						/*else if (botones.equalsIgnoreCase("s") && ((i+1) < matriz.length) &&  
								matriz[i+1][j].equalsIgnoreCase(vacia) || (i+1) < (matriz.length) && matriz[i+1][j].equalsIgnoreCase(finJuego)) {
							matriz[i+1][j] = pepito;
							System.out.println("s");
						}*/

						else if (botones.equalsIgnoreCase("s")) {
							if(((i+1) < matriz.length) && matriz[i+1][j].equalsIgnoreCase(vacia)){
								matriz[i+1][j] = pepito;
								System.out.println("s");							
							}
							else if((i+1) < matriz.length && matriz[i+1][j].equalsIgnoreCase(finJuego)) { 															
								matriz[i+1][j] = pepito;									
								salidaPepito = false;												
							}
							else {
								matriz[i][j] = pepito;
								System.out.println("zs");								
							}
						}
						else {
							matriz[i][j] = pepito;
							System.out.println("p");
						}
					}
					contador ++;
				}
			}
		}

		return matriz;
	}
	//método para mostrar fin de partida,
	static void finDePartida() {

		if (botones.equalsIgnoreCase("q")) {
			//si ha elegido boton Q para salir muestro mensaje y menu principal,
			System.out.println("\nHa salido de partida");
		}
		else if (salidaPepito == false) {
			System.out.println("\n*------------------------------*");
			System.out.println("Pepito ha salido del labirinto");
			System.out.println(" ☻ ___");
			System.out.println("*------------------------------*");
		}
	}

	static String botonesAW(String [][] matriz) {

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {


				if ((j-1) >= 0 && (matriz[i][j-1].equalsIgnoreCase(vacia))) {
					matriz[i][j-1] = pepito;
					System.out.println("a");
				}	
				else if ((j-1) >= 0 && (matriz[i][j-1].equalsIgnoreCase(finJuego))) {
					matriz[i][j-1] = pepito;
					salidaPepito = false;
				}
				else {
					matriz[i][j] = pepito;
					System.out.println("za");								
				}	
			}
		}
		return botones;

	}
}