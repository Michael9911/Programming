package biseccion.main;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
	static double funcion(double x) {
		return (Math.pow(x, 3)) - (8 * (Math.pow(x, 2))) + (3 * x) + (2); // Cambia esto por tu función aquí se utiliza: x3-2x+1 como ejemplo.
	}

	public static void main(String[] args) {
		double a , b, result, aux = 0;
		double error = 1;
		DecimalFormat formato = new DecimalFormat("0.00000");

		Scanner leer = new Scanner(System.in);
		System.out.println("Por favor ingrese el intervalo A B");
		System.out.println("Ingrese el limite superior A");
		a = leer.nextDouble();
		System.out.println("Ingrese el limite inferior B");
		b = leer.nextDouble();

		if (funcion(a) * funcion(b) > 0) 
		{
			System.out.println("La raíz no se encuentra en el intervalo");
		} else {
			do {
				result = (a + b) / 2; 
				error = Math.abs((result - aux) / result);
				aux = result; 

				if (funcion(a) * funcion(result) > 0) 
				{
					a = result;
				} else {
					b = result;
				}

			} while (0 != error);
			System.out.println("Raiz de f(x) es : " + formato.format(result));
		}
	}
}
