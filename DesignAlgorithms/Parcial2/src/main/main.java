package main;

import java.util.Scanner;

import voraz.voraz;

public class main {

	public static void main(String[] args) {
		menu();

	}
	
	
	public static void menu() {
		System.out.println("Bienvenido\nAlgoritmo Voraz\nHecho por: Michael Stiven Pulido Reyes\nID:563098");
		Scanner sc = new Scanner(System.in);
		int opcion = 1;
		while (opcion == 1) {
			System.out.println("Que desea hacer?\n1. Ejecutar algoritmo Voraz\n2. Salir");
			opcion = sc.nextInt();
			
			if(opcion == 1)
			{
				voraz v = new voraz();
				/*
				 * Clientes
				 * Tiempo
				 */
				System.out.println("Ingrese el numero de Clientes");
				int clientes = sc.nextInt();
				
				System.out.println("Por favor ingrese los tiempos para cada cliente");
				float[][] matriz = v.matrizTiempo(clientes);
				v.algoritmoVoraz(matriz);
				
			} else if(opcion != 1 && opcion != 2)
			{
				opcion = 1;
				System.out.println("Error, ingrese una opcion valida!");
			}
		}
		System.out.println("Gracias!!");
		
	}

}
