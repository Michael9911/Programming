package desing.Backtracking;

public class Persona {

	private int tareasMaximas;
	private Tarea[] tareas;

	private int tarea;
	private int costo;

	public Persona(int tareasMaximas, int numTareas) {
		this.tareasMaximas = tareasMaximas;
		this.tareas = new Tarea[numTareas];
		this.tarea = 0;
		this.costo = 0;
	}

	public int getTareasMaximas() {
		return tareasMaximas;
	}

	public void setTareasMaximas(int tareasMaximas) {
		this.tareasMaximas = tareasMaximas;
	}

	public Tarea[] getTareas() {
		return tareas;
	}

	public void setTareas(Tarea[] tareas) {
		this.tareas = tareas;
	}

	public int getTarea() {
		return tarea;
	}

	public void setTarea(int tarea) {
		this.tarea = tarea;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public void anexarTarea(Tarea t) {
		for (int i = 0; i < this.tareas.length; i++) {
			if(this.tareas[i] == null) {
				this.tareas[i] = t;
				this.tarea += 1;
				this.costo += t.getCosto();
				break;
			}
		}
	}

	public void clear() {
		for (int i = 0; i < this.tareas.length; i++) {
			this.tareas[i] = null;
			this.tarea = 0;
			this.costo = 0;
		}
	}

	public void eliminarTarea(Tarea t) {
		for (int i = 0; i < this.tareas.length; i++) {
			if(this.tareas[i] != null)
			{
				if(this.tareas[i].equals(t)) {
					this.tareas[i] = null;
					this.tarea -= 1;
					this.costo -= t.getCosto();
				}
			}
		}
	}

	public boolean existeTarea(Tarea t) {
		for (int i = 0; i < this.tareas.length; i++) {
			if (this.tareas[i] != null ) {
				if(this.tareas[i].equals(t) || 
						(this.tareas[i].getTarea() == t.getTarea() && this.tareas[i].getPersona() == t.getPersona())  
						) {
					System.out.println(this.tareas[i].getTarea() + " ----- " + t.getTarea() + "/" + this.tareas[i].getPersona() + " ----- " + t.getPersona());
					return true;
				}
			}
		}

		return false;
	}

	@Override
	public String toString() {
		String cadena = "";

		for (int i = 0; i < this.tareas.length; i++) {
			if(this.tareas[i] != null) {
				cadena += tareas[i] + "\n";
			}
		}

		cadena += "Tareas: " + getTarea() + "\n";
		cadena += "Costo: " + getCosto() + "\n";

		return cadena;
	}
}
