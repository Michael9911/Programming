package com.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.DAO.UsuariosDAO;
import com.project.models.UsuariosDTO;

@RestController
@RequestMapping("user")
public class Usuarios {
	
	@Autowired
	private UsuariosDAO userDAO;
	
	
	/*
	 * Retornar informacion del usuario
	 */
	@RequestMapping(value = "/{userDocumento}")
	public ResponseEntity<UsuariosDTO> getUserByDocumento(@PathVariable("userDocumento")  long userDocumento)
	{
		Optional<UsuariosDTO> optionalProduct = userDAO.findById( userDocumento );

		if(optionalProduct.isPresent())
		{
			return ResponseEntity.ok( optionalProduct.get() );
		} else {
			return ResponseEntity.noContent().build();
		}

	}
	
	/*
	 * Retorno de Email y Password
	 */
	@RequestMapping(value = "login/{email}")
	public ResponseEntity<Object> getLogin(@PathVariable("email")  String  email)
	{
		List<Object> optionalProduct = userDAO.findByEmailAddress(email);

		if(optionalProduct != null)
		{
			return ResponseEntity.ok( optionalProduct.get(0) );
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	/*
	 * Buscar si existe un email
	 */
	@RequestMapping(value = "email/{email}")
	public ResponseEntity<Object> getEmail(@PathVariable("email")  String  email)
	{
		List<Object> optionalProduct = userDAO.findByEmail(email);

		if(optionalProduct != null)
		{
			return ResponseEntity.ok( optionalProduct.get(0) );
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	
	/*
	 * Crear Usuario
	 */
	@PostMapping
	public ResponseEntity<UsuariosDTO> createUser(@RequestBody UsuariosDTO usuario)
	{
		UsuariosDTO newProduct = userDAO.save(usuario);
		return ResponseEntity.ok(newProduct);
	}
	
	/*
	 * Eliminar usuario por numero de documento
	 */
	@DeleteMapping(value = "{usuarioDocumento}")
	public ResponseEntity<Void> deleteUser(@PathVariable("usuarioDocumento")  Long usuarioDocumento)
	{
		userDAO.deleteById(usuarioDocumento);
		return ResponseEntity.ok(null);
	}
	
	
	/*
	 * Actualizar usuario
	 */
	@PutMapping
	public ResponseEntity<UsuariosDTO> updateUser(@RequestBody UsuariosDTO usuario)
	{
		Optional<UsuariosDTO> optionalUser = userDAO.findById(usuario.getDocumento());

		if(optionalUser.isPresent())
		{
			UsuariosDTO updateUser = optionalUser.get();
			
			/*
			 * Solo puede actualizar nombre y email
			 */
			updateUser.setNombre(usuario.getNombre());
			updateUser.setEmail(usuario.getEmail());
			userDAO.save(updateUser);
			
			return ResponseEntity.ok(updateUser);
			
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	/*
	 * Actualizar Password
	 */
	@PutMapping
	@RequestMapping(value = "password/update")
	public ResponseEntity<UsuariosDTO> updatePassword(@RequestBody UsuariosDTO usuario)
	{
		Optional<UsuariosDTO> optionalUser = userDAO.findById(usuario.getDocumento());

		if(optionalUser.isPresent())
		{
			UsuariosDTO updateUser = optionalUser.get();
			
			/*
			 * Actualizar solo el password
			 */
			if (usuario.getPassword().equals("") == false) {
				updateUser.setPassword(usuario.getPassword());
				userDAO.save(updateUser);
				return ResponseEntity.ok(updateUser); //Cambio de clave exitoso
			} else {
				return ResponseEntity.noContent().build(); //Error en la clave
			}
			
		} else {
			return ResponseEntity.notFound().build(); //Usuario no encontrado
		}
	}
}
