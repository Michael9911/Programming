package Algoritmo;

import java.util.Scanner;

import Utilidades.utilidades;

public class voraz {

	public voraz() {}

	/*
	 * Genera matrix entre los candidatos y votantes
	 */
	public void generarMatrix(int candidatos, int votantes, int candidato, int[][]costo) 
	{
		int[][] matrix = new int[candidatos][votantes];
		utilidades u = new utilidades();

		for (int i = 0; i < votantes; i++) {
			int[] aux = u.probabilidadVotantes(candidatos);
			
			for (int j = 0; j < candidatos; j++) {
				matrix[j][i] = aux[j];
			}
		}
		System.out.println("\nMatriz de probabilidad de voto");
		u.imprimirMatrix(matrix);
		
		int[] candidatoEstrella = new int[votantes];
		
		for (int i = 0; i < candidatoEstrella.length; i++) {
			candidatoEstrella[i] = matrix[candidato-1][i];
		}
		
		System.out.println("\nMatriz de Costo por cada votante");
		u.imprimirMatrix(costo);
		
		costo = u.sortArray(costo);
		
		System.out.println("\nMatriz de Costo por menor valor");
		u.imprimirMatrix(costo);
		
		System.out.println("\nProbilidad de votantes del candidato Estrella");
		u.imprimirArray(candidatoEstrella);
		
		calculoAlgoritmo(candidatoEstrella, costo);
		
		
	}

	/*
	 * el candidatos con los % de los votantes es un Array y el costo es una matriz
	 */
	public void calculoAlgoritmo(int[] votantes, int[][] costo) 
	{
		int numVotantes = 0;
		double costoTotal = 0;
		for (int i = 0; i < votantes.length; i++) {
			double valor = 0;

			if(votantes[i] >= 0 && votantes[i] <= 50)
			{
				valor = costoVotante(i , costo);
			} else if(votantes[i] > 50 && votantes[i] <= 90)
			{
				valor = costoVotante(i , costo);
				valor = valor / 2;
			} else if(votantes[i] > 90)
			{
				valor = 0;
			} 
			
			costoTotal = costoTotal + valor;
			
			numVotantes ++;
			
			if(calcularPorcentaje(votantes.length, numVotantes) >= 70) {
				break;
			}
			
		}
		
		System.out.println("\nCosto Total = " + costoTotal + "\nVotantes = " + numVotantes);
	}
	
	/*
	 * Buscar el costo de dicho votante
	 */
	public int costoVotante(int position, int[][]costo) 
	{
		int respuesta = 0;
		
		for (int i = 0; i < costo[1].length; i++) {
			if(costo[0][i] == position+1)
			{
				respuesta = costo[1][i];
			}
		}
		return respuesta;
	}
	
	/*
	 * Calcular % completado de los votantes
	 */
	
	public double calcularPorcentaje(int votantes, int numVotantes)
	{
		double respuesta = 0;
		
		
		respuesta = numVotantes * 100;
		
		respuesta = respuesta / votantes;
		
		return respuesta;
	}
	
	
	/*
	 * Pedir los costos por el votante
	 */
	public int[][] matrizCosto(int numVotantes)
	{
		int[][] matrixCosto = new int[2][numVotantes];
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Por favor ingrese el datos para el siguiente votante: ");
		
		for (int i = 0; i < numVotantes; i++) {
			System.out.println("Votante " + (i+1));
			matrixCosto[0][i] = i+1;
			matrixCosto[1][i] = sc.nextInt();
		}
		
		return matrixCosto;
	}

}
