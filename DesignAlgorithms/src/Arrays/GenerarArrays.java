package Arrays;

public class GenerarArrays {

	public GenerarArrays() {}
	
	public static int[] ArrayOrdenado(int num)
	{
		int[] Array = new int[num];
		
		for (int i = 0; i < Array.length; i++) 
		{
			Array[i] = i + 1;
		}
		
		return Array;
	}
}
