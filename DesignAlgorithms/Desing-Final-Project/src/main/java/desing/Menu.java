package desing;

import java.util.Scanner;

import desing.Backtracking.Backtracking;
import desing.Dinamico.ProgramacionDinamica;
import desing.DividirVencer.DividirVencer;

/**
 * Hello world!
 *
 */
public class Menu 
{
	public static void main( String[] args )
	{
		menu();
	}

	public static void menu()
	{
		System.out.println("Bienvenido!");
		Scanner sc = new Scanner(System.in);
		int opcion = 0;
		while(opcion != 4)
		{
			System.out.println("Seleccione una opcion");
			System.out.println("1.Dividir y Vencer"
					+ "\n2.Programacion Dinamica"
					+ "\n3.Backtracking"
					+ "\n4.Salir");
				opcion = sc.nextInt();
				
			switch (opcion) {
			case 1:
				DividirVencer dv = new DividirVencer();
				dv.menu();
				break;
			case 2:
				ProgramacionDinamica pd = new ProgramacionDinamica();
				pd.Embarcaderos();
				break;
			case 3:
				Backtracking b = new Backtracking();
				b.menu();
				break;
			case 4:
				System.out.println("Gracias");
				break;
			default:
				System.out.println("Error, Por favor ingrese una opcion valida");
				break;
			}
		}


	}

}
