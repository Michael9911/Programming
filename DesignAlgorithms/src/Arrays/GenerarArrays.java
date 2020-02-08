package Arrays;

public class GenerarArrays {

	public GenerarArrays() {}
	
	/*
	 * Generar Arrays en orden ascendente ordenados
	 */
	public static int[] ArrayOrdenado(int num)
	{
		int[] Array = new int[num];
		
		for (int i = 0; i < Array.length; i++) 
		{
			Array[i] = i + 1;
		}
		
		return Array;
	}
	
	/*
	 * Generar Arrays de n posiciones NO ordenado 
	 */
	public static int[] ArrayNoOrdenado(int num)
	{
		int[] Array = new int[num];
		int aux = 0;
		for (int i = 0; i < Array.length; i++) 
		{
			aux = generarRandom(num);
			while(estaArray(Array,aux) == true)
			{
				aux = generarRandom(num);
			}
			Array[i] = aux;
		}
		
		return Array;
	}
	
	/*
	 * Generar numero Random dentro de un rango num
	 */
	private static int generarRandom(int num)
	{
		int aux = 0;
		
		aux = (int) (Math.random() * num) + 1;
		
		return aux;
		
	}
	
	private static boolean estaArray(int[] Array, int num) 
	{
		for (int i = 0; i < Array.length; i++) 
		{
			if(Array[i] == num)
			{
				return true;
			}
		}
		
		return false;
	}
	
	/*
	 * Validar si un numero esta o no en un array
	 */
	public static void imprimirArray(int[] Array)
	{
		for (int i = 0; i < Array.length; i++) 
		{
			System.out.println(i + " : " + Array[i]);
		}
	}
}
