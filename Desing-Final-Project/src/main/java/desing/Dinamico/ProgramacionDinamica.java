package desing.Dinamico;

import java.util.Scanner;

/*
 * Hecho por: Michael Pulido
 */

public class ProgramacionDinamica {

	/*
	 * Inicio y destino de la rutaEmbarcadero de embarcaderos
	 */
	private int inicio;
	private int destino;

	//Variable para acumular el valor minimoTotal total
	private int minimoTotal;

	//Resultado de la rutaEmbarcadero
	private String rutaEmbarcadero;

	public void Embarcaderos() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Bienvenido al programa de Programacion Dinamica");
		System.out.println("Por favor ingrese la cantidad de embarcaderos");
		int embarcaderos = sc.nextInt();

		//Llenado de la matriz de las tarifas
		int[][] tarifas = MatrizTarifas(embarcaderos);
		System.out.println("Matriz de tarifas");
		imprimirMatrix(tarifas);

		/*
		 * Al recoger el embarcadero de salida y llegada se le debe restar un 1
		 * esto ya que en un array el tamaño maximo debe ser n-1
		 */
		System.out.println("Ingrese el embardaero de salida:");
		inicio = sc.nextInt() - 1;
		System.out.println("Ingrese el embarcadero de llegada");
		destino = sc.nextInt() - 1;
		CosteTotal(tarifas);
		System.out.println("---------------------------------------------------------");
		System.out.println("Resultado costo mas optimo y ruta a seguir del embarcadero");
		System.out.println("Ruta: " + rutaEmbarcadero);
		System.out.println("Costo minimo optimo: " + minimoTotal);
	}



	/*
	 * Calculo de coste
	 */
	private void CosteTotal(int[][] tarifas) {
		minimoTotal = tarifas[inicio][destino];
		/*
		 * Ruta para calcular el minimo total
		 */
		rutaEmbarcadero = (inicio + 1) + " - > " + (destino + 1) + " ";
		/*
		 * Creacion del punto intermedio entre el incio y final
		 * donde i es para el punto intermedio
		 */ 
		for (int i = inicio + 1; i < destino; i++) 
		{ 
			int costoPar = tarifas[inicio][i];
			String rutaEmbarcaderoparcial = (inicio + 1) + " - > " + (i + 1) + " + ";

			//Llamado calculo del minimo total
			calculoMinimoTotal(tarifas, i, costoPar, rutaEmbarcaderoparcial);
		}
	}

	/*
	 * Calculo del minimo total
	 * Recibe la matriz de las tarifas, el punto medio que sera la referencia
	 * el costo parical y la ruta del embarcadero hasta ese momento
	 */ 
	private void calculoMinimoTotal(int[][] tarifas, int i, int costoparcial, String rutaEmbarcaderoparcial) {
		System.out.println("Ruta del Embarcadero:" + rutaEmbarcaderoparcial + (i + 1) 
				+ " - > " + (destino + 1) + " " + " Costo:" + (costoparcial + tarifas[i][destino]));

		if ((costoparcial + tarifas[i][destino]) < minimoTotal) {
			minimoTotal = costoparcial + tarifas[i][destino];
			rutaEmbarcadero = rutaEmbarcaderoparcial + (i + 1) + " - > " + (destino + 1) + " + ";
		}

		//valida la ruta inicial y luego el pivote correspondiente
		for (int j = i + 1; j < destino; j++) 
		{
			calculoMinimoTotal(tarifas, j, costoparcial + tarifas[i][j], rutaEmbarcaderoparcial + (i + 1) + "-" + (j + 1) + " + ");

		}
	}


	//-------------------------------------UTILIDADES-------------------------------------

	/*
	 * Llenado de las tarifas del embarcadero que sera de tamaño m*m
	 */
	private int[][] MatrizTarifas(int embarcaderosTotal) {
		Scanner sc = new Scanner(System.in);
		int[][] matrix = new int[embarcaderosTotal][embarcaderosTotal];
		for (int i = 0; i < embarcaderosTotal; i++) 
		{
			for (int j = i + 1; j < embarcaderosTotal; j++) 
			{
				System.out.println("Ingrese el costo tarifa del embarcadero " + (i + 1) + " al embarcadero " + (j + 1));
				matrix[i][j] = sc.nextInt();
			}
		}
		return matrix;
	}


	/*
	 * Impimir una matrix de tamaño m*n
	 */
	public void imprimirMatrix(int[][] Array)
	{
		String texto = "";
		for (int i = 0; i < Array.length; i++) {
			texto = (i+1) + " | ";
			System.out.printf("%s \t", texto );
			for (int j = 0; j < Array[i].length; j++) {
				System.out.printf("%d \t",  Array[i][j]);
			}
			System.out.println();
		}
		System.out.println("---------------------------------------------------------");
	}

}
