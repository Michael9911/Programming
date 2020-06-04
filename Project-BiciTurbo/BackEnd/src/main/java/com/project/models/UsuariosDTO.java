package com.project.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usr_usuarios")
public class UsuariosDTO {
	
	@Id
	@Column(name = "documento", nullable = false, length = 20, unique = true)
	private Long documento;
	
	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;
	
	
	@Column(name = "email", nullable = false, length = 50)
	private String email;
	
	@Column(name = "password", nullable = false, length = 30)
	private String password;
	
	@Column(name = "tipoDocumento", nullable = false, length = 3)
	private String tipoDocumento;
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public Long getDocumento() {
		return documento;
	}

	public void setDocumento(Long documento) {
		this.documento = documento;
	}
	
	
	
}
