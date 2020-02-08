package Algoritmos;

public class Insercion {
	
	public Insercion() {}
	
	
	/*
	 * Algoritmo de Insercion para ordenamiento de numeros
	 * Parametros Array[] de longitud N
	 */
	public static int algortimoInsercion(int[] Array) 
	{
		int j = 0;
		int x = 0;
		int operaciones = 0;
		if( Array.length > 0 )
		{
			for (int i = 2; i < Array.length; i++) 
			{
				x = Array[i];
				j = i -1;
				
				while ( j > 0 && x < Array[j] ) 
				{
					Array[j+1] = Array[j];
					j = j- 1;
					operaciones ++;
				}
				Array[j+1] = x;
				operaciones ++;
			}
			return operaciones;
		}
		else
		{
			System.out.println("Error, el array en invalido");
			return 0;
		}
		
	}
}
