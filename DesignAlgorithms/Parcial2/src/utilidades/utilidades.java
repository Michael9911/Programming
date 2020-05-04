package utilidades;

public class utilidades {
	
	public utilidades() {}
	
	
	/*
	 * Impimir una matrix de tamaño m*n
	 */
	public void imprimirMatrix(float[][] Array)
	{
		String texto = "";
		for (int i = 0; i < Array.length; i++) {
			texto = (i+1) + " : ";
			System.out.printf("%s \t", texto );
			for (int j = 0; j < Array[i].length; j++) {
					System.out.printf("%s \t",  Array[i][j]);
			}
			System.out.println();
		}
	}
	
	/*
	 * Implementacion de algoritmo SORT
	 */
	public void swap(float[][] array, int a, int b) {
		float value = array[1][b];
		float value2 = array[0][b];
		
		array[1][b] = array[1][a];
		array[0][b] = array[0][a];
		
		array[1][a] = value;
		array[0][a] = value2;
	}
	
	public float[][] sortArray(float[][] array) {
		for (int i = array[1].length - 1; i > 0; i--) {
			int maxValue = 0;
			for (int j = 0; j < i; j++) {
				if (array[1][j + 1] > array[1][maxValue]) {
					maxValue = j + 1;
				}
			}
			swap(array, i, maxValue);
		}
		
		return array;
	}


}
