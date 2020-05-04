package Utilidades;

public class utilidades {

	public utilidades() {}

	/*
	 * Generar probabilidad de voto en un numero n
	 * de candidatos.
	 * 
	 * Entrada:
	 * - Numero de candidatos.
	 * 
	 * Salida:
	 * - Devuelve Array de probabilidad de votos.
	 */
	public int[] probabilidadVotantes(int numCandidatos) 
	{
		//Declara Array de respuesta
		int[] respuesta = new int[numCandidatos];
		int aux = 0;

		for (int i = 0; i < respuesta.length; i++) {

			if(i != respuesta.length - 1)
			{
				aux = generarRandom();

				if( sumatoria(respuesta, aux) )
				{
					respuesta[i] = aux;
				}
			} else {
				respuesta[i] = numFaltante(respuesta);
			}
		}

		return respuesta;
	}

	/*
	 * Generar numero aleatorio entre 0 y 100
	 */
	private int generarRandom()
	{
		int aux = 0;

		aux =  (int) (Math.random() * 100);

		return aux;
	}

	/*
	 * Calcular si el siguiente numero es valido para la
	 * probabilidad de voto
	 */
	private boolean sumatoria(int[] Array, int siguiente)
	{
		boolean respuesta = false;
		int sum = 0;

		for (int i = 0; i < Array.length; i++) {
			sum = sum + Array[i];
		}

		if(sum + siguiente > 100)
		{
			respuesta = false;
		} else if(sum + siguiente <= 100)
		{
			respuesta = true;
		}

		return respuesta;
	}

	/*
	 * Calcular numero faltante para que sea
	 * 100 la probabilidad total
	 */
	private int numFaltante(int[] Array) 
	{
		int sum = 0;
		int faltante = 0;

		for (int i = 0; i < Array.length; i++) {
			sum = sum + Array[i];
		}

		faltante = 100 - sum;

		return faltante;
	}

	/*
	 * Impimir una matrix de tamaño m*n
	 */
	public void imprimirMatrix(int[][] Array)
	{
		String texto = "";
		for (int i = 0; i < Array.length; i++) {
			texto = (i+1) + " : ";
			System.out.printf("%s \t", texto );
			for (int j = 0; j < Array[i].length; j++) {
					System.out.printf("%d \t",  Array[i][j]);
			}
			System.out.println();
		}
	}
	
	/*
	 * Impimir una matrix de tamaño m
	 */
	public void imprimirArray(int[] Array)
	{
		String texto = "";
		for (int i = 0; i < Array.length; i++) {
			texto = (i+1) + " : " + Array[i];
			System.out.printf("%s \t", texto );
		}
	}
	
	/*
	 * Implementacion de algoritmo SORT
	 */
	public void swap(int[][] array, int a, int b) {
		int value = array[1][b];
		int value2 = array[0][b];
		
		array[1][b] = array[1][a];
		array[0][b] = array[0][a];
		
		array[1][a] = value;
		array[0][a] = value2;
	}
	
	public int[][] sortArray(int[][] array) {
		for (int i = array[1].length - 1; i > 0; i--) {
			int maxValue = 0;
			for (int j = 0; j < i; j++) {
				if (array[1][j + 1] > array[1][maxValue]) {
					maxValue = j + 1;
				}
			}
			swap(array, i, maxValue);
		}
		
		return array;
	}

}
