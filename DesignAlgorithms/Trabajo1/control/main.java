package control;

import Algoritmos.Insercion;
import Algoritmos.Seleccion;
import Arrays.GenerarArrays;

public class main {
	

	public static void main(String[] args) 
	{
		
		int[] ArrayNO = GenerarArrays.ArrayNoOrdenado(10);
		int[] ArrayO = GenerarArrays.ArrayOrdenado(10);
		System.out.println("Arrays");
		System.out.println("No Ordenado");
		GenerarArrays.imprimirArray(ArrayNO);
		System.out.println("Ordenado");
		GenerarArrays.imprimirArray(ArrayO);
		System.out.println("Ordenamiento\n");
		System.out.println("---------------------------------------------");
		System.out.println("Seleccion");
		System.out.println("No Ordenado : "+ Seleccion.algoritmoSeleccion(ArrayNO));
		System.out.println("Ordenado : " + Seleccion.algoritmoSeleccion(ArrayO));
		System.out.println("---------------------------------------------");
		System.out.println("Insercion");
		System.out.println("No Ordenado : "+ Insercion.algortimoInsercion(ArrayNO));
		System.out.println("Ordenado : " + Insercion.algortimoInsercion(ArrayO));
		
		
	}

}
