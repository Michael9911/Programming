package desing.Backtracking;

public class Tarea {

	private int tarea;
	private int persona;
	private int costo;
	
	public Tarea(int tarea, int costo, int persona) {
		this.tarea = tarea;
		this.costo = costo;
		this.persona = persona;
	}
	
	

	public int getPersona() {
		return persona;
	}



	public void setPersona(int persona) {
		this.persona = persona;
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
	
	
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		
		if(obj == null) {
			return true;
		}
		
		if(getClass() != obj.getClass()){
			return false;
		}
		
		final Tarea other = (Tarea) obj;
		if(this.tarea != other.tarea) {
			return false;
		}
		
		if(this.costo != other.costo) {
			return false;
		}
		
		if(this.persona != other.persona) {
			return false;
		}
		
		return true;
	}

	
	@Override
	public String toString() {
		return "Persona: " + persona + " -> Tarea: " + tarea + " -> Costo: " + costo;
	}
}
