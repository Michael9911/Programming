package matrizDeterminante;


public class MatrizDeterminante {
	
	public MatrizDeterminante(){}
	
	public static int getDeterminante(int[][] matriz){
		
		final int cero = 0;
		final int uno = 1;
		final int dos = 2;
		int det = cero;
		
		for(int i = cero; i < matriz[cero].length; i++){
			
			int indice = (int) Math.pow(-uno, i) * matriz[cero][i];
			int[][] subMatriz = new int[matriz[cero].length - uno][matriz[cero].length - uno];
			
			for(int j = uno; j < matriz[cero].length; j++)
			{
				int m = cero;
				
				for(int k = cero; k < matriz[cero].length; k++)
				{
					if(k != i)
					{
						subMatriz[j-uno][m] = matriz[j][k];
						m++;
					}
				}
			}
			
			if(dos == matriz[cero].length)
			{
				int detAux;
				
				detAux = (matriz[cero][cero] * matriz[uno][uno]) - (matriz[cero][uno] * matriz[uno][cero]);
				
				return detAux;
				
			}
			else
			{
				det += indice * getDeterminante(subMatriz);
			}
		}
		return det;
	}
}
