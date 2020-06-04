package desing.DividirVencer;

import java.util.Arrays;
import java.util.Scanner;

public class DividirVencer {

	private int matrix[][] = null;
	private int posicion = 0;

	public void menu() {
		System.out.println("Bienvenido");
		System.out.println("Por favor ingrese el numero de jugadores");
		Scanner sc = new Scanner(System.in);
		int tam = sc.nextInt();
		matrix = new int[tam][tam];
		jugadoresTennis(matrix);
		limpiarMatrix();
		imprimirMatrix(matrix);
	}

	/*
	 * Generacion de dividir y vencer
	 */
	public void jugadoresTennis(int[][] matrix)
	{
		if(matrix.length <= 1) return;
		int mitad = matrix.length / 2;
		int[][] izq = Arrays.copyOfRange(matrix, 0, mitad);
		int[][] der = Arrays.copyOfRange(matrix, mitad, matrix.length);
		jugadoresTennis(izq);
		jugadoresTennis(der);
		if(izq.length == 1)
		{
			generacionPartidos(izq[0]);
			combinarVector(izq);

		}
		if(der.length == 1)
		{
			generacionPartidos(der[0]);
			combinarVector(der);

		}
	}

	/*
	 * Generacion de partidos segun el dia
	 */
	public void generacionPartidos(int[] vector)
	{
		for (int k = 0; k < vector.length; k++) {

			int valor = generarRandom(vector.length);

			while(validarNumero(vector, valor))
			{
				valor = generarRandom(vector.length);
			}
			vector[k] = valor;
		}
	}

	/*
	 * Limpiza de la matriz, donde si encuentra la posicion "i" es el dia de descanso
	 */
	public void limpiarMatrix()
	{
		for (int i = 0; i < matrix.length; i++) {

			for (int j = 0; j < matrix.length; j++) {
				if(matrix[i][j] == i+1) {
					matrix[i][j] = 0;
				}
			}
		}
	}

	
	/*
	 * Validar si un numero se encuentra en un array
	 */
	public boolean validarNumero(int[] vector, int numero)
	{
		for (int i = 0; i < vector.length; i++) {
			if(vector[i] == numero) {
				return true;
			}
		}
		return false;
	}


	public void combinarVector(int[][] vec) 
	{
		matrix[posicion] = vec[0];
		posicion ++;	
	}

	/*
	 * Generar numero aleatorio entre 0 y 100
	 */
	private int generarRandom(int max)
	{
		int aux = 0;

		aux =  (int) Math.floor(Math.random()*max+1);;

		return aux;
	}

	/*
	 * Impimir una matrix de tamaño m*n
	 */
	public void imprimirMatrix(int[][] Array)
	{
		String texto = "";
		System.out.printf("%s \t", "Jug" );
		for (int i = 0; i < Array.length; i++) {
			texto = "d"+ (i+1);
			System.out.printf("%s \t", texto );
		}
		System.out.println();
		for (int i = 0; i < Array.length; i++) {
			texto = (i+1) + " | ";
			System.out.printf("%s \t", texto );
			for (int j = 0; j < Array[i].length; j++) {
				String aux = "";
				if(Array[i][j] == 0)
				{
					aux = "-";
				} else {
					aux = ""+Array[i][j];
				}

				System.out.printf("%s \t",  aux);
			}
			System.out.println();
		}
		System.out.println("------------------------------------------");
	}

}
