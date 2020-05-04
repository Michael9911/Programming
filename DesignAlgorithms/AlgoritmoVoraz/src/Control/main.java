package Control;


/*
 * Hecho por: Michael Stiven Pulido Reyes
 * email: maicol1696@gmail.com
 * 
 * Fecha generada: 15 de abril del 2020
 */

import java.util.Scanner;

import Algoritmo.voraz;

public class main {

	public static void main(String[] args) {
		menu();
		
	}
	
	public static void menu() {
		System.out.println("Bienvenido");
		Scanner sc = new Scanner(System.in);
		int opcion = 1;
		while (opcion == 1) {
			System.out.println("Que desea hacer?\n1. Ejecutar algoritmo Voraz\n2. Salir");
			opcion = sc.nextInt();
			
			if(opcion == 1)
			{
				voraz v = new voraz();
				/*
				 * Candidatos
				 * Votantes
				 * Candidato
				 */
				System.out.println("Ingrese el numero de Candidatos");
				int candidatos = sc.nextInt();
				System.out.println("Ingrese el numero de Votantes");
				int votantes = sc.nextInt();
				System.out.println("Ingrese el candidato que desea que gane");
				int candidato = sc.nextInt();
				while (candidato > candidatos) {
					System.out.println("Ingrese nuevamente");
					candidato = sc.nextInt();
				}
				
				System.out.println("Por favor ingrese los costos para cada candidato");
				int[][] costo = v.matrizCosto(votantes);
				v.generarMatrix(candidatos, votantes, candidato, costo);
			} else if(opcion != 1 && opcion != 2)
			{
				opcion = 1;
				System.out.println("Error, ingrese una opcion valida!");
			}
		}
		System.out.println("Gracias!!");
		
	}
	

}
