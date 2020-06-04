package desing.Backtracking;

import java.util.Scanner;

public class Backtracking {


	public void menu() {
		System.out.println("Bienvenido\nPor favor ingrese el numero de personas");

		Scanner sc = new Scanner(System.in);
		int personas = sc.nextInt();
		System.out.println(personas);
//		Tarea[] tareas = tareas(personas);
		Tarea[] tareas = {
				//tarea costo persona 
				new Tarea(1,4,1),
				new Tarea(2,7,1),
				new Tarea(3,3,1),
				new Tarea(1,2,2),
				new Tarea(2,6,2),
				new Tarea(3,1,2),
				new Tarea(1,3,3),
				new Tarea(2,9,3),
				new Tarea(3,4,3)
		};
		
		for (int i = 0; i < tareas.length; i++) {
			System.out.println( tareas[i].toString() );
		}

		Persona p_base = new Persona(personas, tareas.length);
		Persona p_opt = new Persona(personas, tareas.length);

		llenarTareas(p_base, tareas, false, p_opt);
		System.out.println(p_opt.toString());

	}

	public Tarea[] tareas(int personas) {
		Tarea[] tarea = new Tarea[personas];
		System.out.println("Por favor ingrese el el coste");
		for (int i = 0; i < tarea.length; i++) {
			for (int j = 0; j < tarea.length; j++) {
				Scanner sc = new Scanner(System.in);
				System.out.println("Por favor ingrese el coste para la tarea: " + (j+1) + " de la persona: " + (i+1));
				int coste = sc.nextInt();
				tarea[i] = new Tarea( (j+1), coste, (i+1) );
			}
		}

		return tarea;
	}

	/*
	 * Posicion incial, maximo persona, matriz, costo
	 */
	public void llenarTareas(Persona p_base, Tarea[] tareas, boolean llena, Persona p_opt) {

		if(llena) {
			if(p_base.getCosto() < p_opt.getCosto()) {
				Tarea[] tareasLlenar = p_base.getTareas();
				p_opt.clear();
				for(Tarea t: tareasLlenar) {
					if(t != null)
					{
						p_opt.anexarTarea(t);
					}
				}
			}
		} else {
			for (int i = 0; i < tareas.length; i++) {
				if(!p_base.existeTarea( tareas[i] ) ) {
					if(p_base.getTareasMaximas() > p_base.getTarea() + 1) {
						p_base.anexarTarea(tareas[i]);
						llenarTareas(p_base, tareas, false, p_opt);
						p_base.eliminarTarea( tareas[i] );
					} else {
						llenarTareas(p_base, tareas, true, p_opt);
					}
				}

			}
		}


	}

}
