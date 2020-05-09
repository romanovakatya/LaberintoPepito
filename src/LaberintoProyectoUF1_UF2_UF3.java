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
	public static boolean salidaPepito = true; //variable para acabar el juego,cuando pepito llega al final,
	public static String [] nivelesDePartidasJugadas = new String [5]; //para guardar niveles de partidas jugadas,
	public static String nivelesDePartidas;
	public static String [] resultadoDePartidasJugadas = new String [5]; // para guardar el resultado de la partida,	
	public static String resultadoDePartida;
	public static void main(String[] args) throws FileNotFoundException {

		String[][][] matriz;

		//llenamos matriz con el contenido de un documento txt(tres niveles del juego,
		//utilizando función generarMatriz,
		matriz = generarMatriz();

		System.out.println("¡Bienvenido al LABERINTO DE PEPIT☻!"); //Saludamos al jugador,

		menu = mostrarMenu(menuPrincipal); //muestro el menu principal, utilizando función generarMenu,

		//si usuario ha elegido la opción incorrecta, le muestro un mensaje y propuso elegir otra vez,
		while (!menu.equalsIgnoreCase("j") && !menu.equalsIgnoreCase("r") && !menu.equalsIgnoreCase("q")) {
			System.out.println("Por favor, elige la opción correcta");
			menu = mostrarMenu(menuPrincipal);
		}
		//mientras jugador quiere jugar(no elige botón "Q"), le muestro menu principal,
		while (!menu.equalsIgnoreCase("q") || menu.equalsIgnoreCase("j") || menu.equalsIgnoreCase("r")) 
		{
			//bucle para guardar resultados de partidas (max 5),
			for (int i = 0; i < nivelesDePartidasJugadas.length; i++) {
				if (menu.equalsIgnoreCase("j")) { //si ha elegido j - jugar,

					menu = mostrarMenu(menuNiveles); //creamos y mostramos menu secundario con niveles del juego,

					//en caso de error muestro mensaje y propuesto elegir la opción correcta,
					while (!menu.equalsIgnoreCase("3") && !menu.equalsIgnoreCase("2") &&
							!menu.equalsIgnoreCase("1") && !menu.equalsIgnoreCase("q"))	
					{
						System.out.println("Nivel no existe");					
						menu = mostrarMenu(menuNiveles); //y menu con niveles de dificultad,					
					}

					//cuando elige la opción 1 se empieza partida de nivel más facil,
					if (menu.equalsIgnoreCase("1")) 					
					{										
						demostrarMatriz(matriz[0]);	//muestro el labirinto inicial,	

						jugarPartida(matriz[0]);//con la función jugarPartida pepito se mueve,

						finDePartida(); //partida se acabará cuando pepito llega al final o se elige boton q, 

						//guardo nivel de la partida en un array,
						nivelesDePartidasJugadas[i] = nivelDePartidas();

						resultadoDePartidasJugadas[i] = resultadoDePartida; //guardo resultado de la partida en un array,

						matriz = generarMatriz(); //en este caso genero desde nuevo la matriz inicial,

						menu = mostrarMenu(menuPrincipal); //y muestro al usuario el menu inicial,														
					}
					//cuando elige opción 2 se empieza partida de dificultad media,
					else if (menu.equalsIgnoreCase("2")) 
					{
						demostrarMatriz(matriz[1]); //muestro el labirinto inicial,

						jugarPartida(matriz[1]); //con la función jugarPartida pepito se mueve,

						finDePartida(); //partida se acabará cuando pepito llega al final o se elige boton q,

						//guardo nivel de la partida en un array,
						nivelesDePartidasJugadas[i] = nivelDePartidas();

						resultadoDePartidasJugadas[i] = resultadoDePartida; //guardo resultado de la partida en un array,

						matriz = generarMatriz(); //en este caso genero desde nuevo la matriz inicial,

						menu = mostrarMenu(menuPrincipal); //y muestro al usuario el menu inicial,
					}
					//cuando elige opción 3 empieza partida de dificultad alta,
					else if (menu.equalsIgnoreCase("3")) 
					{
						demostrarMatriz(matriz[2]); //muestro el labirinto inicial,

						jugarPartida(matriz[2]); //con la función jugarPartida pepito se mueve,

						finDePartida(); //partida se acabará cuando pepito llega al final o se elige boton q,

						//guardo nivel de la partida en un array,
						nivelesDePartidasJugadas[i] = nivelDePartidas();

						resultadoDePartidasJugadas[i] = resultadoDePartida; //guardo resultado de la partida en un array,

						matriz = generarMatriz(); //en este caso genero desde nuevo la matriz inicial,

						menu = mostrarMenu(menuPrincipal); //y muestro al usuario el menu inicial,					
					}
					else if (menu.equalsIgnoreCase("q")) //botón Q: permite salir al menu principal,
					{ 
						menu = mostrarMenu(menuPrincipal);
					}
				}

				else if (menu.equalsIgnoreCase("r"))  //si en menu principal ha elegido r - resultado,
				{
					menu = mostrarMenu (menuResultado); //muestro el menu con variantes de los resultados,

					while (!menu.equalsIgnoreCase("1") && !menu.equalsIgnoreCase("2") //en caso de error,
							&& !menu.equalsIgnoreCase("q"))
					{
						System.out.println("La opción no existe. Elige entre 1 y 2"); //muestro un mensaje,
						menu = mostrarMenu (menuResultado);
					}
					//para ver resultados por niveles,
					if (menu.equalsIgnoreCase("1")) {

						//tengo que ordenar array de menor a mayor,
					}

					//para ver resultados por orden de las partidas,
					else if (menu.equalsIgnoreCase("2")) {
						//mostrar resultado como hay utilizando método mostrar resultado,
						mostrarResultado(nivelesDePartidasJugadas, resultadoDePartidasJugadas);
						//corregir que muestra intentos quedados,
					}

					else if (menu.equalsIgnoreCase("q")) //permite salir al menu principal,
					{
						menu = mostrarMenu(menuPrincipal);
					}
				}
			}
		}
		//cuando en menu principal ha elegido q - salir, 
		//acabo el juego y le muestro un mensaje a usuario,
		System.out.println("El juego se ha terminado. Hasta próximo!");

		teclado.close();
	}


	//función para mostrar menu,	
	static String mostrarMenu (String[]menu)
	{
		//mientras hay lineas de menu los imprimo,
		for (int i = 0; i < menu.length; i++) {
			System.out.println(menu[i]);
		}
		return teclado.next();
	}

	//función para rellenar matriz desde un documento txt,
	static String[][][]generarMatriz () throws FileNotFoundException {

		Scanner entrada = new Scanner(new File("laberints.txt"));//leo lo que hay en el documento txt,

		String[][][]matriz; //ya que tenemos tres niveles del juego creamos 3d matriz,

		matriz= new String [3][][];  //inicializo 3d matriz,

		while (entrada.hasNext()) //mientras hay dados en el documento,
		{			
			for (int i = 0; i < matriz.length; i++) //para cada nivel de matriz,
			{
				//cojo desde txt tamaño de cada matriz,
				int fila = entrada.nextInt();
				int columna = entrada.nextInt();

				String [][] matrizSinNombre = new String[fila][columna];//y los inicializo con los datos del documento,

				for (int j = 0; j < matrizSinNombre.length; j++) {
					for (int j2 = 0; j2 < matrizSinNombre[j].length; j2++) {

						matrizSinNombre[j][j2] = entrada.next(); //relleno cada matriz de su contenido,

						if (matrizSinNombre[j][j2].equalsIgnoreCase(pepito)) //guardo posición de pepito en variables,
						{
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

	static void demostrarMatriz(String[][]matriz) //método para mostrar matriz,
	{
		for (int i = 0; i < matriz.length; i++) {
			System.out.println(" ");
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + " ");
			} 
		}
	}

	static void jugarPartida(String [][]matriz) throws FileNotFoundException //metodo para mostrar pasos del pepito, 
	{			                                                             
		do {									
			demostrarMatriz(pepitoMover(matriz));//muestro botones del juego y laberinto con cada paso de pepito,
			//partida continua mientras el usuario no elige la opción Q - salir o no llegará al			
		} while (salidaPepito && !botones.equalsIgnoreCase("q")); //final del labirinto(salidaPepito = true),
	}

	static String[][]pepitoMover(String[][]matriz) throws FileNotFoundException //funcion para mover pepito,
	{
		//variable contador para mover pepito a un paso solo,
		int contador = 0;
		salidaPepito = true;

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {

				if (matriz[i][j].equalsIgnoreCase(pepito)) //compruebo posición de pepito,
				{						
					//System.out.println("\n1");				
					if (contador < 1) //compruebo que contador menos que 1 para hacer solo un paso,
					{
						//System.out.println("2");
						botones = mostrarMenu(menuBotonesJuego); //muestro botones del juego,				

						matriz[i][j] = vacia; //cambio el contenido de esa celda de pepito a vacia,

						if (botones.equalsIgnoreCase("a"))//si ha elegido botón a: izquierda  						
						{   //y una celda atrás no es menor que 0 y está vacia,
							if ((j-1) >= 0 && (matriz[i][j-1].equalsIgnoreCase(vacia))) {

								matriz[i][j-1] = pepito; // muevo allá el pepito,
								//System.out.println("a");
							}	//si una celda atrás no es menor que 0 y es fin de juego, 
							else if ((j-1) >= 0 && (matriz[i][j-1].equalsIgnoreCase(finJuego))) 
							{ 
								matriz[i][j-1] = pepito; //muevo allá el pepito,
								//y salida Pepito cambia su contenido a false que es una de las, 
								salidaPepito = false; //condiciones de fin de partida,
							}
							else //en cualquier otro caso pepito no se mueve,
							{
								matriz[i][j] = pepito;
								//System.out.println("za");								
							}
						}						
						else if (botones.equalsIgnoreCase("w")) //si ha elegido botón w: subir,  
						{ //y una celda atrás no es menor que 0 y está vacia,
							if ((i-1) >= 0 && (matriz[i-1][j].equalsIgnoreCase(vacia)))   								
							{
								matriz[i-1][j] = pepito; //muevo alla pepito,
								//System.out.println("w");
							} //si una celda atrás no es menor que 0 y es fin de juego,
							else if ((i-1) >= 0 && (matriz[i-1][j].equalsIgnoreCase(finJuego))) 
							{
								matriz[i-1][j] = pepito; //muevo alla pepito,
								//y salida Pepito cambia su contenido a false que es una de las,
								salidaPepito = false; //condiciones de fin de partida,
							}
							else //en cualquier otro caso pepito no se mueve,
							{
								matriz[i][j] = pepito; 
								//System.out.println("zw");								
							}
						}						    
						else if (botones.equalsIgnoreCase("d")) //si ha elegido botón d: derecha, 
						{  //y una celda adelante es menor que la última posición de matriz y está vacia,
							if ((j+1) < matriz[i].length && (matriz[i][j+1].equalsIgnoreCase(vacia))) 
							{
								matriz[i][j+1] = pepito; //muevo alla pepito,
								//System.out.println("d");
							} //si una celda adelante es menor que la última posición de matriz y es fin de juego,
							else if ((j+1) < matriz[i].length && (matriz[i][j+1].equalsIgnoreCase(finJuego))) 
							{
								matriz[i][j+1] = pepito; //muevo alla pepito,
								//y salida Pepito cambia su contenido a false que es una de las,
								salidaPepito = false; //condiciones de fin de partida,
							}
							else //en cualquier otro caso pepito no se mueve,
							{
								matriz[i][j] = pepito; 
								//System.out.println("zd");								
							}
						}								     						
						else if (botones.equalsIgnoreCase("s")) //si ha elegido botón s: bajar,
						{  //y una celda adelante es menor que la última posición de matriz y está vacia,
							if(((i+1) < matriz.length) && matriz[i+1][j].equalsIgnoreCase(vacia))
							{
								matriz[i+1][j] = pepito; //muevo alla pepito,
								//System.out.println("s");							
							} //si una celda adelante es menor que la última posición de matriz y es fin de juego,
							else if((i+1) < matriz.length && matriz[i+1][j].equalsIgnoreCase(finJuego)) 
							{ 															
								matriz[i+1][j] = pepito; //muevo alla pepito,									
								salidaPepito = false;												
							}
							else //en cualquier otro caso pepito no se mueve,
							{
								matriz[i][j] = pepito; 
								//System.out.println("zs");								
							}
						}
						else //en cualquier otro caso pepito no se mueve,
						{
							matriz[i][j] = pepito;
							//System.out.println("p");
						}
					}
					contador ++; //conto cantidad de ejecuciones,
				}
			}
		}
		return matriz;
	}
	static void finDePartida() //método para mostrar fin de partida,
	{ 
		if (botones.equalsIgnoreCase("q")) //si ha elegido boton Q para salir,
		{   // muestro un mensaje,			
			System.out.println("\nHa salido de la partida");

			resultadoDePartida = "no se ha finalizada"; //resultado de partida para mostrarlo en los resultados,

		}
		else if (salidaPepito == false) //si el pepito ha llegado al final de laberinto,
		{   // muestro un mensaje del final de partida,
			System.out.println("\n*------------------------------*");
			System.out.println("Pepito ha salido del laberinto");
			System.out.println(" ☻ ___");
			System.out.println("*------------------------------*");
					//resultado de partida para mostrarlo en los resultados,			
			resultadoDePartida = "el pepito se ha salido del laberinto";
		}
	}
	//función para guardar resultado por nivel !!!(no acabada),
	static String nivelDePartidas() 
	{			
		if (menu.equalsIgnoreCase("1")) {

			nivelesDePartidas = "1";			
		}
		else if (menu.equalsIgnoreCase("2")) {
			
			nivelesDePartidas = "2";
		}
		else if (menu.equalsIgnoreCase("3")) {

			nivelesDePartidas = "3";
		}
		else {
			nivelesDePartidas = "No ha jugado esta partida"; //no funciona,
		}								

		return nivelesDePartidas;
	}
	//método para mostrar resultados de partidas,
	static void mostrarResultado(String [] array, String [] array2) {
		for (int i = 0; i < array.length; i++) {		
			System.out.print ("Partida " + (i+1) + ". Nivel del juego: " + array[i] + ". ");
			System.out.println("Resultado: " + array2[i]);						
		}
	}
	/*
	static String botonesAW(String [][] matriz) 
	{
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {

				if ((j-1) >= 0 && (matriz[i][j-1].equalsIgnoreCase(vacia))) 
				{
					matriz[i][j-1] = pepito;
					System.out.println("a");
				}	
				else if ((j-1) >= 0 && (matriz[i][j-1].equalsIgnoreCase(finJuego))) 
				{
					matriz[i][j-1] = pepito;
					salidaPepito = false;
				}
				else 
				{
					matriz[i][j] = pepito;
					System.out.println("za");								
				}	
			}
		}
		return botones;

	}*/
}