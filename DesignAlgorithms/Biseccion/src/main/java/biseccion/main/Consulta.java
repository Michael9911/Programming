package biseccion.main;
import java.util.Scanner;

public class Consulta {


	//declaracion de variables
	//se acumula el valor mininmo del comparativo
	private int minimo;
	//ruta final del valor minimo
	private String ruta;
	//inicio del embarcadero y el destino donde va el barco
	private int inicio;
	private int destino;

	Scanner Entradadedato = new Scanner(System.in);

	public void ProgramacionDinamica() {
		System.out.println("PROGRAMACIÓN DINÁMICA");
		System.out.println("Indique la cantidad de embarcaderos");
		int embarcaderos = Entradadedato.nextInt();
		//llena tabla de tarifas
		int[][] tarifas = TablaTarifas(embarcaderos);
		System.out.println("Matriz de tarifas");
		mostrarMatriz(tarifas);
		System.out.println("Ingrese el embardaero de salida:");
		inicio = Entradadedato.nextInt() - 1;
		System.out.println("Ingrese el embarcadero de llegada");
		destino = Entradadedato.nextInt() - 1;
		Coste(tarifas);
		System.out.println("------------------------------------------------------");
		System.out.println("Respuesta final ruta y costo mas optimo");
		System.out.println("Ruta: " + ruta);
		System.out.println("Costo mínimo: " + minimo);
	}
	//pide tabla de tarifas 
	private int[][] TablaTarifas(int embarcaderos) {
		int[][] tarifas = new int[embarcaderos][embarcaderos];
		for (int i = 0; i < embarcaderos; i++) {
			for (int j = i + 1; j < embarcaderos; j++) {
				System.out.println("Ingrese la tarifa del embarcadero " + (i + 1) + " al embarcadero " + (j + 1));
				tarifas[i][j] = Entradadedato.nextInt();
			}
		}
		return tarifas;
	}
	// paso el la lista de las tarifas
	private void Coste(int[][] tarifas) {
		minimo = tarifas[inicio][destino];
		ruta = (inicio + 1) + "-" + (destino + 1) + " ";//solucion para el minimo
		//crea un punto intermedio entre inio y el final el i es para intermedia 
		for (int i = inicio + 1; i < destino; i++) { 
			int costoparcial = tarifas[inicio][i];
			String rutaparcial = (inicio + 1) + "-" + (i + 1) + " + ";
			Minimo(tarifas, i, costoparcial, rutaparcial);//se va aminimo
		}
	}
	//Recibe tabla de tarifas , punto medio de referencia, costo parcial y la ruta hasta ese momento 
	private void Minimo(int[][] tarifas, int i, int costoparcial, String rutaparcial) {
		System.out.println("Ruta:" + rutaparcial + (i + 1) + "-" + (destino + 1) + " " + " Costo:" + (costoparcial + tarifas[i][destino]));
		//
		if ((costoparcial + tarifas[i][destino]) < minimo) {
			minimo = costoparcial + tarifas[i][destino];
			ruta = rutaparcial + (i + 1) + "-" + (destino + 1) + " + ";
		}

		//valida la ruta inicial y luego pivote
		for (int j = i + 1; j < destino; j++) {
			Minimo(tarifas, j, costoparcial + tarifas[i][j], rutaparcial + (i + 1) + "-" + (j + 1) + " + ");

		}
	}

	//Metodo mostrar matriz
	static void mostrarMatriz(int matriz[][]) {
		for(int i = 0;i < matriz.length; i++){
			System.out.print((i+1)+"|");
			for(int j = 0;j < matriz[i].length; j++){
				System.out.print(matriz[i][j]);
				if (j!=matriz[i].length-1) {
					System.out.print("\t");
				}
			}
			System.out.print("|");
			System.out.print("\n");
		}

		System.out.print("---------------------------------------------------------");
		System.out.print("\n");
	}	
}
