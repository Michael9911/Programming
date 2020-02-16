package matriz;

public class GenerarMatriz {

	public GenerarMatriz(){}

	/*
	 * Generador de matrices 
	 */
	public int [][] GenerarMatrizCuadrada(int num)
	{
		int [][] matriz = new int[num][num];
		int valorM = 0;

		for (int i = 0; i < matriz.length; i++) {

			for (int j = 0; j < matriz.length; j++) {

				valorM = generarRandom();

				matriz[i][j] = valorM;
			}
		}

		return matriz;
	}

	/*
	 * Numero Random no mayor a 100
	 */
	private int generarRandom()
	{
		int aux = 0;

		aux =  (int) (Math.random() * 100) + 1;

		return aux;
	}

	/*
	 * Concatenar valores de la Matriz
	 */
	public String imprimirArray(int[][] Array)
	{
		String respuesta = "";
		for (int i = 0; i < Array.length; i++) 
		{
			for (int j = 0; j < Array.length; j++) 
			{
				respuesta = respuesta + Array[i][j] + " : ";
			}
			respuesta = respuesta + "\n";
		}
		return respuesta;
	}
}
