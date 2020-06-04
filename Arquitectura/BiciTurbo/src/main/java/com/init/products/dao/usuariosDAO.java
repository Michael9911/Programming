package com.init.products.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.init.products.entitys.usuario;

public interface usuariosDAO extends JpaRepository<usuario, Long> {
	
	usuario findByEmail(String emil);
}
