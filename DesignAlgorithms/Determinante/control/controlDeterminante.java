package control;

import matriz.GenerarMatriz;
import matrizDeterminante.MatrizDeterminante;

public class controlDeterminante {

	public static void main(String[] args) {
		
		GenerarMatriz gr = new GenerarMatriz();
		MatrizDeterminante matrix = new MatrizDeterminante();
		
		
		int[][] matriz =  gr.GenerarMatrizCuadrada(50); //Generador de una matriz N*N
		
		String respuesta = gr.imprimirArray(matriz); //Muestreo de la matriz
		System.out.println(respuesta);
		
		int determinante = matrix.getDeterminante(matriz); //Calculo de la determinante
		System.out.println(determinante); //Determinante
		
		
	}

}
