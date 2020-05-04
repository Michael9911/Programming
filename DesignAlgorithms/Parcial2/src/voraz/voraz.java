package voraz;

import java.text.DecimalFormat;
import java.util.Scanner;

import utilidades.utilidades;

public class voraz {

	public voraz() {}


	public void algoritmoVoraz(float[][] matriz)
	{
		utilidades u = new utilidades();
		System.out.println("Matriz inicial");
		u.imprimirMatrix(matriz);
		System.out.println("Matriz Ordenada por tiempo");
		matriz = u.sortArray(matriz);
		u.imprimirMatrix(matriz);
		DecimalFormat formato = new DecimalFormat("0.00");

		float tiempo = 0;
		float propinas = 0;
		float aux = 0;


		for (int i = 0; i < matriz[1].length; i++) {
			if(i != 0)
			{
				aux = 1/tiempo;
				propinas = propinas + aux;
				
			} else 
			{
				aux = 1;
				propinas = 1;
			}
			System.out.println("Se atendio al cliente Nro: " + (matriz[0][i]) + "\n"
					+ "su tiempo de atencion es de: " + matriz[1][i] + " minutos\n"
					+ "su tiempo de espera es de: " + tiempo + " minutos\n"
					+ "y su propina es de: $" + formato.format(aux));
			tiempo = tiempo + matriz[1][i];
			

		}
		
		System.out.println("La propina maxima recibida por los cliente es de: $" + formato.format(propinas));

	}

	/*
	 * Pedir los costos por el votante
	 */
	public float[][] matrizTiempo(int numClientes)
	{
		float[][] matrixCosto = new float[2][numClientes];

		Scanner sc = new Scanner(System.in);

		System.out.println("Por favor ingrese el tiempo para el siguiente cliente: ");

		for (int i = 0; i < numClientes; i++) {
			System.out.println("Cliente " + (i+1));
			matrixCosto[0][i] = i+1;
			matrixCosto[1][i] = sc.nextInt();
		}

		return matrixCosto;
	}

}
