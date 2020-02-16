package Algoritmos;

public class Seleccion {

	public Seleccion() {}

	/*
	 * Algoritmo de insercion para ordenamiento de numeros
	 * Toma como parametros un Array de N
	 */
	public static int algoritmoSeleccion( int[] Array ) 
	{
		int minj = 0;
		int minx = 0;
		int operaciones = 0;

		if(Array.length != 0)
		{
			for (int i = 1; i < ( Array.length - 1 ); i++) 
			{
				minj = i;
				minx = Array[i];
				for (int j = i + 1; j < Array.length; j++) 
				{
					if(Array[j] < minx)
					{
						minj = j;
						minx = Array[j];
						operaciones ++;
					}
					operaciones ++;
				}

				Array[minj] = Array[i];
				Array[i] = minx;
				operaciones ++;
			}
			return operaciones;
		}
		else
		{
			System.out.println("Error el Array no posee valores");
			return 0;
		}
	}
}
