package com.project.DAO;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.models.UsuariosDTO;

public interface UsuariosDAO extends JpaRepository<UsuariosDTO, Long> {

	
	@Query("SELECT u.email, u.password FROM UsuariosDTO u WHERE u.email = :email")
	List<Object> findByEmailAddress(String email);
	
	@Query("SELECT u.email FROM UsuariosDTO u WHERE u.email = :email")
	List<Object> findByEmail(String email);
	
}
