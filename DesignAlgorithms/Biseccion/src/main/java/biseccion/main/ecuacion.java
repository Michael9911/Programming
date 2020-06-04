package biseccion.main;
import java.text.DecimalFormat;
import java.util.Scanner;

public class ecuacion{

	public static int numero, potencia;
	
	
	// Andres Felipe Garcia Fiscal, Maicol Stiven Pulido Reyes
	
	
	public static void main(String[] args) {
		
		Consulta s = new Consulta();
		s.ProgramacionDinamica();
		// TODO Auto-generated method stub
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
				System.out.println("Limite superior :" + a + 
									"\nLimite Inferior : " + b);
				System.out.println("Limite medio : " + result);
				System.out.println("-----------------");

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

	
	public static int[]  validacion(String[] parts, int numero, int potencia, int parte) {
		/*
		Pattern p = Pattern.compile(".*x.*"); //si la x esta en algun lugar
		Pattern pfin = Pattern.compile(".*x$");//si la x esta al final
		Pattern pini = Pattern.compile("^x.*");//si la x esta al principio
		
		
		String separo;
		String[] separacion = null;
		
		if(parts[parte] != "0") {
			
			separo = parts[parte];
			
			Matcher m = p.matcher(separo);
			Matcher mini = pini.matcher(separo);
			Matcher mfin = pfin.matcher(separo);
			//si hay una x 
			if(m.matches()) {
				//valido si la x esta al inicio    x^a
				if(mini.matches()) {
					numero=1;
					
					char c= separo.charAt(0);
					String cad = Character.toString(c);
					
					potencia = Integer.parseInt(cad);
					
					//valido si la x esta al final   ax
				}else if(mfin.matches()) {
					char c= separo.charAt(0);
					String cad = Character.toString(c);
					numero = Integer.parseInt(cad);
					potencia =1;
					
				}else {
				//separo el numero entero de la potencia       ax^b
				separacion = separo.split("x");
				numero = Integer.parseInt(separacion[0]);
				potencia = Integer.parseInt(separacion[1]);
				}
			}else {
				//si no hay x devuelve solo el numero       a
				numero=Integer.parseInt(separo);
				potencia =1;
			}
			
		}
		
		*/
		return new int[] {numero, potencia};
		
	}
	
static double funcion(double x) {
		
/*
	//si se borra de esta linea a la linea 182 funciona
	Scanner sc = new Scanner(System.in);
	
	int numero1=0;
	int numero2=0;
	int numero3=0;
	int numero4=0;
	int numero5=0;
	int potencia1=0;
	int potencia2=0;
	int potencia3=0;
	int potencia4=0;
	int potencia5=0;
	
	
	String polinomio;
	
	System.out.println("ingrese el polinomio con el = 0");  //nota: numero maximo de coeficientes permitidos: 5
	polinomio = sc.nextLine();
	
	//se estraen los numeros y variable x
	String[] parts = polinomio.split("\\+|\\-|\\=");  
	for(int i =0; i < parts.length; i++) {
		System.out.println(parts[i]);	
	}
	
	//primer parte ax^b
	
	int numeros[] = validacion(parts, numero1, potencia1, 0);
	numero1=numeros[0]; potencia1=numeros[1];
	
	//segunda parte cx^d
	
	int numeros2[] = validacion(parts, numero2, potencia2, 1);
	numero2=numeros2[0]; potencia2=numeros2[1];
	
	//tercera parte ex
	
	int numeros3[] = validacion(parts, numero3, potencia3, 2);
	numero3=numeros3[0]; potencia3=numeros3[1];
	
	
	// si aun hay variable en la parte 4 
	
	if(parts[3] != "0") {
		
		int numeros4[] = validacion(parts, numero4, potencia4, 3);
		numero4=numeros4[0]; potencia4=numeros4[1];	
	}
	
	// si aun hay variable en la parte 5 
	
	if(parts[4] != "0") {
	
		int numeros5[] = validacion(parts, numero5, potencia5, 4);
		numero5=numeros5[0]; potencia5=numeros5[1];			
	}
	
	//System.out.println("numero1: "+numero1+" potencia1: "+potencia1);
	//System.out.println("numero2: "+numero2+" potencia2: "+potencia2);
	//System.out.println("numero3: "+numero3+" potencia3: "+potencia3);
	//System.out.println("numero4: "+numero4+" potencia4: "+potencia4);
	
	
	
	//ecuacion tipo 2x+1=0
	//if(parts.length==2) {
	//	double resultado = (numero1*Math.pow(x, potencia1)) - (numero2 * (Math.pow(x, potencia2)));
	//}
	
	//ecuacion tipo 2x2+bx+1=0
	//if(parts.length==3) {
	//	double resultado = (numero1*Math.pow(x, potencia1)) - (numero2 * (Math.pow(x, potencia2))) + (numero3 * (Math.pow(x, potencia3)));		
	//}
	//ecuacion tipo 2x3+bx2+cx+1=0
	//if(parts.length==4) {
	//	double resultado = (numero1*Math.pow(x, potencia1)) - (numero2 * (Math.pow(x, potencia2))) + (numero3 * (Math.pow(x, potencia3))) + (numero4 * (Math.pow(x, potencia4)));
	//}
	//ecuacion tipo 2x4+bx3+cx2+dx+1=0
	//if(parts.length==2) {
		//double resultado = (numero1*Math.pow(x, potencia1)) - (numero2 * (Math.pow(x, potencia2))) + (numero3 * (Math.pow(x, potencia3)) + (numero4 * (Math.pow(x, potencia4)))+(numero5*(Math.pow(x, potencia4))));		
	//}
	
	
	*/
	//return resultado;
		
		return (Math.pow(x, 3)) - (2 * (Math.pow(x, 2))) + (3 * x) -(4); // Cambia esto por la función aquí se utiliza: x3-8x2+3x+2=0 como ejemplo.
	}
}
